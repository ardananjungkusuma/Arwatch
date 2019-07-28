package com.ardananjung.arwatch.data;

import android.content.Context;

import androidx.room.Room;

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
