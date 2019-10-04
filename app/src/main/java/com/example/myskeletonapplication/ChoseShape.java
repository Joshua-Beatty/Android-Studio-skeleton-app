package com.example.myskeletonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChoseShape extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_shape);
            final Button circleButton = findViewById(R.id.circlebutton);
            circleButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    Log.d("debugging", "Clicked");
                    startActivity(new Intent(ChoseShape.this, CircleCalc.class));
                }
            });
            final Button squareButton = findViewById(R.id.squarebutton);
            squareButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    Log.d("debugging", "Clicked");
             //       startActivity(new Intent(ChoseShape.this, SquareCalc.class));
                }
            });
    }
}
