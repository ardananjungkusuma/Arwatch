package com.blogspot.ardananjungkusuma.arwatch.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.blogspot.ardananjungkusuma.arwatch.data.AppDatabase;
import com.blogspot.ardananjungkusuma.arwatch.data.AppDbProvider;
import com.blogspot.ardananjungkusuma.arwatch.data.WatchItem;
import com.blogspot.ardananjungkusuma.arwatch.data.WatchItemDao;
import com.blogspot.ardananjungkusuma.arwatch.remotedata.AppServiceProvider;
import com.blogspot.ardananjungkusuma.arwatch.remotedata.ArwatchService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WatchRepository {
    private AppDatabase database;
    private ArwatchService service;

    private LiveData<List<WatchItem>> watchList;

    public WatchRepository(Context context){
        this.database= AppDbProvider.getAppDbInstance(context);
        this.service= AppServiceProvider.getArwatchService();
    }
    public LiveData<List<WatchItem>>getWatchList(){
        if(this.isOnline()){
            this.getWatchListFromDb();
            this.getWatchListFromWeb();
        }else{
            this.getWatchListFromDb();
        }
        return this.watchList;
    }
    private boolean isOnline(){
        return true;
    }
    private class DeleteAllWatchItem extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            database.watchItemDao().removeAll();
            return null;
        }
    }
    private void getWatchListFromWeb(){
        Call<List<WatchItem>> watchItemListCall=this.service.getWatchItem();
        watchItemListCall.enqueue(new Callback<List<WatchItem>>() {
            @Override
            public void onResponse(Call<List<WatchItem>> call, Response<List<WatchItem>> response) {
                new DeleteAllWatchItem().execute();
                List<WatchItem>watchItemList=response.body();
                WatchItem[] arrWatchItem = new WatchItem[watchItemList.size()];
                for(int i=0;i<arrWatchItem.length;i++){
                    arrWatchItem[i]= watchItemList.get(i);
                }new SaveWatchItemTask().execute(arrWatchItem);
            }

            @Override
            public void onFailure(Call<List<WatchItem>> call, Throwable t) {
                Log.e("Errorrrrrrrr","erroorrrrrr " + t.getMessage());
            }
        });
    }

    private void getWatchListFromDb(){
        WatchItemDao dao = database.watchItemDao();

        this.watchList=dao.findAll();
    }
    public class SaveWatchItemTask extends AsyncTask<WatchItem,Void,Void>{

        @Override
        protected Void doInBackground(WatchItem... watchItems) {
            WatchItemDao dao = database.watchItemDao();

            for(int i=0;i<watchItems.length;i++){
                WatchItem w = watchItems[i];
                dao.addNew(w);
            }

            return null;
        }
    }
    private void saveWatchItemToWeb(WatchItem watchItem){
        Call<WatchItem>postWatchItemCall=this.service.postWatchItem(watchItem);
        postWatchItemCall.enqueue(new Callback<WatchItem>() {
            @Override
            public void onResponse(Call<WatchItem> call, Response<WatchItem> response) {
                getWatchListFromWeb();
            }

            @Override
            public void onFailure(Call<WatchItem> call, Throwable t) {

            }
        });
    }

    private void saveWatchItemToDb(WatchItem watchItem){
        new SaveWatchItemTask().execute(watchItem);
    }

//todo:2 Cek ini
    public void saveWatchItem(WatchItem watchItem){
        if(this.isOnline()){
            this.saveWatchItemToWeb(watchItem);
        }else{
            this.saveWatchItemToDb(watchItem);
        }
    }
}
