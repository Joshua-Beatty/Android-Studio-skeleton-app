package com.example.myskeletonapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * ChoseShape class is a screen that allows the user to choose between a circle and a square to calculate.
 *
 * @author Derek Xu
 * @version 10/4/19
 */

public class ChoseShape extends AppCompatActivity {
    singleton single = singleton.getInstance();

    ConstraintLayout relativeLayout;
    /**
     * onCreate method makes the buttons clickable to change screens
     * changes title on top to No More Geometry
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_shape);
        getSupportActionBar().setTitle("No More Geometry");
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
                    startActivity(new Intent(ChoseShape.this, SquareCalc.class));
                }
            });
        relativeLayout = findViewById(R.id.backg);
        bgChanger();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            startActivity(new Intent(ChoseShape.this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
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
