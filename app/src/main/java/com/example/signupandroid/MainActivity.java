package com.example.signupandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.signupandroid.Database.UserDatabase;
import com.example.signupandroid.Models.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText Username, FullName, Email, Gender;
    DatePicker picker;
    String Date;
    Button uploadTask;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.Username);
        FullName = (EditText) findViewById(R.id.FullName);
        Email = (EditText) findViewById(R.id.Email);
        Gender = (EditText) findViewById(R.id.Gender);
        uploadTask = (Button) findViewById(R.id.uploadBtn);


        UserDatabase userDatabase = UserDatabase.getDB(this);

        picker = new DatePicker(this);
        int day = picker.getDayOfMonth();
        int month = picker.getMonth();
        int year = picker.getYear();
        Date = day + "/" + month + "/" + year;

        uploadTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userDatabase.usersDao().addUsers(new Users(Username.getText().toString(), FullName.getText().toString(), Email.getText().toString(), Gender.getText().toString(), Date));

                ArrayList<Users> usersArrayList = (ArrayList<Users>) userDatabase.usersDao().getUsersData();
                for (int i = 0; i < usersArrayList.size(); i++) {
                    Log.d("Date", "Username :" + usersArrayList.get(i).getUsername() + "FullName:" + usersArrayList.get(i).getFullName() + " Email:" + usersArrayList.get(i).getEmail() + " Gender: " + usersArrayList.get(i).getGender() + " Date:" + usersArrayList.get(i).getDate());
                }

                Username.setText("");
                FullName.setText("");
                Gender.setText("");
                Email.setText("");
                picker.clearFocus();
            }
        });

    }
}