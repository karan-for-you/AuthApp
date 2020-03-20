package com.example.authapp.db;

import android.content.Context;

public class DatabaseClass extends UserRoomDatabase {

    private Context context;

    DatabaseClass(Context context){
        this.context = context;
    }

    UserRoomDatabase db = UserRoomDatabase.getDatabase(context);

    @Override
    public UserDao userDao() {
        return null;
    }
}
