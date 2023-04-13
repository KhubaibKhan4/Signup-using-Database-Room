package com.example.signupandroid.Database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.signupandroid.DAO.UsersDao;
import com.example.signupandroid.Models.Users;

@Database(entities = Users.class, exportSchema = false, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DB_NAME = "UsersDB";
    private static UserDatabase instance;

    public static synchronized UserDatabase getDB(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, UserDatabase.class, DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return instance;
    }

    public abstract UsersDao usersDao();
}
