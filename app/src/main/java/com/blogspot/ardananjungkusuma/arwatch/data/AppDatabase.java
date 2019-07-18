package com.blogspot.ardananjungkusuma.arwatch.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {WatchItem.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WatchItemDao watchItemDao();
}
