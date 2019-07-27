package com.blogspot.ardananjungkusuma.arwatch.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.blogspot.ardananjungkusuma.arwatch.data.AppDatabase;
import com.blogspot.ardananjungkusuma.arwatch.data.AppDbProvider;
import com.blogspot.ardananjungkusuma.arwatch.data.Watch;
import com.blogspot.ardananjungkusuma.arwatch.data.WatchDao;
import com.blogspot.ardananjungkusuma.arwatch.remotedata.AppServiceProvider;
import com.blogspot.ardananjungkusuma.arwatch.remotedata.ArwatchService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WatchRepository {
    //property instance databse
    private AppDatabase database;
    //property instance service
    private ArwatchService service;

    private LiveData<List<Watch>> watchList;

    public WatchRepository(Context context){
        //isi instance database
        this.database= AppDbProvider.getAppDbInstance(context);

        //isi instance service
        this.service = AppServiceProvider.getArwatchService();
    }

    public LiveData<List<Watch>>getWatchList(){
        if(this.isOnline()){
            this.getWatchListFromDb();
            this.getWatchListFromWeb();
        }
        else{
            this.getWatchListFromDb();
        }
        return this.watchList;
    }

    private boolean isOnline(){
        return true;
    }

    private void getWatchListFromWeb() {
        Call<List<Watch>> watchListCall=this.service.getWatch();

        //kirim request
        watchListCall.enqueue(new Callback<List<Watch>>() {
            @Override
            public void onResponse(Call<List<Watch>> call, Response<List<Watch>> response) {
                //hapus dulu semua database sebelum download
                new DeleteAllWatches().execute();
                List<Watch>watchList=response.body();
                Watch [] arrWatch = new Watch[watchList.size()];
                for(int i=0;i<arrWatch.length;i++){
                    arrWatch [i] = watchList.get(i);
                }new SaveWatchTask().execute(arrWatch);
            }

            @Override
            public void onFailure(Call<List<Watch>> call, Throwable t) {
                Log.e("Errorrrrrrrr","erroorrrrrr " + t.getMessage());
            }
        });
    }

    private void getWatchListFromDb(){
        //Ambil dao dari database
        WatchDao dao = this.database.watchDao();

        //ambil data dari tabel lewat dao
        this.watchList= dao.findAll();
    }
    public class SaveWatchTask extends AsyncTask<Watch,Void,Void> {

        @Override
        protected Void doInBackground(Watch... watches) {
            WatchDao dao = database.watchDao();
            //ambil kontak pertama dari parameter

            for(int i=0;i<watches.length;i++){
                Watch c = watches[i];
                dao.addNew(c);
            }
            return null;
        }
    }
    public void saveWatch(Watch watch){
        if(this.isOnline()){
            this.saveWatchToWeb(watch);
        }
        else{
            this.saveWatchToDb(watch);
        }
    }

    private class DeleteAllWatches extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            //hapus data lewat DAO
            database.watchDao().removeAll();

            return null;
        }
    }
    private void saveWatchToWeb(Watch watch) {
        Call<Watch>postWatchCall=this.service.postWatch(watch);
        postWatchCall.enqueue(new Callback<Watch>() {
            @Override
            public void onResponse(Call<Watch> call, Response<Watch> response) {
                getWatchListFromWeb();
            }

            @Override
            public void onFailure(Call<Watch> call, Throwable t) {

            }
        });
    }

    private void saveWatchToDb(Watch watch) {
        new SaveWatchTask().execute(watch);
    }
}
