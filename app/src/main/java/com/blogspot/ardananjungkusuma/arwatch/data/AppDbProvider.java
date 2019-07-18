package com.blogspot.ardananjungkusuma.arwatch.data;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDbProvider {
    //Singleton
    private static AppDatabase appDbInstance;

    public static AppDatabase getAppDbInstance(Context context){
        if(AppDbProvider.appDbInstance==null){
            AppDbProvider.appDbInstance= Room.databaseBuilder(context, AppDatabase.class,"app_database.db").build();
        }
        return AppDbProvider.appDbInstance;
    }
}
