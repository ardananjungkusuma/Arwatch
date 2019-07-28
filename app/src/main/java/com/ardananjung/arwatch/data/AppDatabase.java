package com.ardananjung.arwatch.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Watch.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
public abstract WatchDao watchDao();
}
