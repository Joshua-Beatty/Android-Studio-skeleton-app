package com.example.myskeletonapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.Button;
import android.util.*;
import android.widget.RelativeLayout;

import com.example.myskeletonapplication.R;

public class LoginActivity extends AppCompatActivity {

    singleton single = singleton.getInstance();
    ConstraintLayout relativeLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        relativeLayout = findViewById(R.id.backg);

        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("No More Geometry");

        final Button button = findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.d("debugging", "Clicked");
                startActivity(new Intent(LoginActivity.this, ChoseShape.class));
            }
        });
        //bgChanger();
    }
    public void onStart() {
        super.onStart();

    }
    public void bgChanger(){
        if(single.darkMode){
            relativeLayout.setBackgroundResource(R.drawable.bg);

        } else {
            relativeLayout.setBackgroundResource(R.drawable.white);
        }

    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        bgChanger();
    }

}
