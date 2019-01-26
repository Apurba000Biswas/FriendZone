package com.example.apurba.friendzone.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.apurba.friendzone.R;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        String name = getIntent().getStringExtra("Name");
        int imgId = getIntent().getIntExtra("ImgId", -1);
    }
}
