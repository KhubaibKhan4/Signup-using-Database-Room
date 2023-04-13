package com.example.signupandroid.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class Users {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "Username")
    String username;

    @ColumnInfo(name = "FullName")
    String fullName;

    @ColumnInfo(name = "Email")
    String email;

    @ColumnInfo(name = "Gender")
    String gender;

    @ColumnInfo(name = "Date")
    String date;

    public Users(int id, String username, String fullName, String email, String gender, String date) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.date = date;
    }

    @Ignore
    public Users(String username, String fullName, String email, String gender, String date) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
