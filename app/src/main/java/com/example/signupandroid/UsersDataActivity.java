package com.example.signupandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.signupandroid.Database.UserDatabase;
import com.example.signupandroid.Models.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersDataActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_data);
        UserDatabase userDatabase = UserDatabase.getDB(this);

        TextView username = (TextView) findViewById(R.id.usernameTxt);
        TextView fullname = (TextView) findViewById(R.id.fullNameTxt);
        TextView email = (TextView) findViewById(R.id.emailTxt);
        TextView gender = (TextView) findViewById(R.id.genderTxt);
        TextView date = (TextView) findViewById(R.id.dateTxt);
        UserDatabase userDatabase1 = UserDatabase.getDB(this);
        List<Users> usersList = userDatabase1.usersDao().getUsersData();
        for (int i = 0; i < usersList.size(); i++) {
           username.setText("Username :"+usersList.get(i).getUsername());
            fullname.setText("FullName :"+usersList.get(i).getFullName());
            email.setText("Email :"+usersList.get(i).getEmail());
            gender.setText("Gender :"+usersList.get(i).getGender());
            date.setText("Date :"+usersList.get(i).getDate());
        }
    }
}