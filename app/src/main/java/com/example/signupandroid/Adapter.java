package com.example.signupandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signupandroid.Database.UserDatabase;
import com.example.signupandroid.Models.Users;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Users> usersArrayList;

    public Adapter(Context context, ArrayList<Users> usersArrayList) {
        this.context = context;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_users_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserDatabase userDatabase = UserDatabase.getDB(context);
        usersArrayList = (ArrayList<Users>) userDatabase.usersDao().getUsersData();
        for (int i = 0; i < usersArrayList.size(); i++) {
            holder.username.setText("Username: "+usersArrayList.get(i).getUsername());
        }
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView username, fullname, email, gender, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.usernameTxt);
            fullname = itemView.findViewById(R.id.fullNameTxt);
            email = itemView.findViewById(R.id.emailTxt);
            gender = itemView.findViewById(R.id.genderTxt);
            date = itemView.findViewById(R.id.dateTxt);
        }
    }
}
