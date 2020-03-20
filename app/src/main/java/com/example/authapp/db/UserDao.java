package com.example.authapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.authapp.model.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("DELETE FROM users where userId = :id")
    void deleteUser(int id);

    @Query("SELECT * FROM users")
    LiveData<User> listUsers();
}
