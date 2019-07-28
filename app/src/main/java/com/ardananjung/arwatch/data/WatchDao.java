package com.ardananjung.arwatch.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WatchDao {
    @Insert
    public void addNew(Watch watch);

    @Query("select*from watch")
    public LiveData<List<Watch>> findAll();

    @Query("delete from watch")
    public void removeAll();
}
