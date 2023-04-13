package com.example.signupandroid.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.signupandroid.Models.Users;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UsersDao {

    @Query("select * from Users")
    List<Users> getUsersData();

    @Insert
    void addUsers(Users users);

    @Update
    void updateUsers(Users users);

    @Delete
    void deleteUsers(Users users);
}
