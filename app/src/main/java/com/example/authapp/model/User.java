package com.example.authapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    private int id;
    @ColumnInfo(name = "userName")
    private String name;
    @ColumnInfo(name = "userCity")
    private String city;
}
