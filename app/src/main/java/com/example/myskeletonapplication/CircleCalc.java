package com.example.myskeletonapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CircleCalc extends AppCompatActivity  {

    double radius = 0;
    double diameter = 0;
    double circumference = 0;
    double area = 0;

    private EditText radiustextfield;
    private EditText diametertextfield;
    private EditText circumferencetextfield;
    private EditText areatextfield;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_calc);

        radiustextfield = (EditText) findViewById(R.id.radiustextfield);
        diametertextfield = (EditText) findViewById(R.id.diametertextfield);
        circumferencetextfield = (EditText) findViewById(R.id.circumfrencetextfeild);
        areatextfield = (EditText) findViewById(R.id.areatextfield);

        /* Set Text Watcher listener */
        radiustextfield.addTextChangedListener(radiusWatcher);


    }
    protected void changeValues(double rad, int given){


        if(given != 0){
            diametertextfield.setText("test");
        }
        if(given != 1){
            diametertextfield.setText("test");
        }
        if(given != 2){
            diametertextfield.setText("test");
        }
        if(given != 3){
            diametertextfield.setText("test");
        }
    }
     TextWatcher radiusWatcher = new TextWatcher() {
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         public void onTextChanged(CharSequence s, int start, int before, int count) {
             if (s.length() != 0) {
                 changeValues(Double.toString(s), 0);
             }
         }

         public void afterTextChanged(@org.jetbrains.annotations.NotNull Editable s) {

        }
    };
}
