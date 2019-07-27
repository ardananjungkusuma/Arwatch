package com.blogspot.ardananjungkusuma.arwatch.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Watch.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WatchDao watchDao();
}



