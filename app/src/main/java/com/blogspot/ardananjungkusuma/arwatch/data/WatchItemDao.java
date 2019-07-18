package com.blogspot.ardananjungkusuma.arwatch.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface WatchItemDao {
    @Insert
    public void addNew(WatchItem watchItem);

    @Query("select*from watch")
    public LiveData<List<WatchItem>>findAll();
    //Todo:1 cek watch
    @Query("delete from watch")
    public void removeAll();
}
