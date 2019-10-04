package com.example.myskeletonapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.util.*;

import com.example.myskeletonapplication.R;

public class LoginActivity extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("No More Geometry");

        final Button button = findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.d("debugging", "Clicked");
                startActivity(new Intent(LoginActivity.this, SquareCalc.class));
            }
        });
    }
    public void onStart() {
        super.onStart();

    }


}
