package com.blogspot.ardananjungkusuma.arwatch.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import androidx.lifecycle.LiveData;


import java.util.List;


@Dao
public interface WatchDao {
    @Insert
    public void addNew(Watch watch);

    @Query("select * from watch")
    public LiveData<List<Watch>> findAll();

    @Query("delete from watch")
    public void removeAll();
}
