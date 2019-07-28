package com.ardananjung.arwatch.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ardananjung.arwatch.data.Watch;
import com.ardananjung.arwatch.repository.WatchRepository;

import java.util.List;


public class MainViewModel extends AndroidViewModel {
    private WatchRepository watchRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        this.watchRepository = new WatchRepository(application);
    }

    //mendapatkan semua kontak yang ada didalam database
    public LiveData<List<Watch>> getWatchList(){
        //mengambil data dari repo
        return this.watchRepository.getWatchList();
    }

    //untuk menyimpan kontak
    public void saveWatch(Watch watch){
        this.watchRepository.saveWatch(watch);
    }
}
