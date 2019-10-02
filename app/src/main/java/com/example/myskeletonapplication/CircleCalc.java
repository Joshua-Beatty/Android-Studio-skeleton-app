package com.example.myskeletonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import java.lang.Math;
import java.util.Locale;

public class CircleCalc extends AppCompatActivity{

    Double radius = 0d;
    Double diameter = 0d;
    Double circumference = 0d;
    Double area = 0d;
    Double pi = 3.14159d;

    private EditText radiusTextField;
    private EditText diameterTextField;
    private EditText circumferenceTextField;
    private EditText areaTextField;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_calc);

        radiusTextField = findViewById(R.id.radiusTextField);
        diameterTextField = findViewById(R.id.diameterTextField);
        circumferenceTextField = findViewById(R.id.circumfrencetextfeild);
        areaTextField = findViewById(R.id.areaTextField);

        /* Set Text Watcher listener */
        radiusTextField.addTextChangedListener(radiusWatcher);
        diameterTextField.addTextChangedListener(diameterWatcher);
        circumferenceTextField.addTextChangedListener(circumferenceWatcher);
        areaTextField.addTextChangedListener(areaWatcher);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    protected void changeValues(double rad, int given){
        radius = rad;
        diameter = radius * 2;
        circumference = pi * diameter;
        area = pi * radius * radius;
        if(area > 100000000d || circumference > 100000000d){
            valueToLarge();
            return;
        }
        radiusTextField.removeTextChangedListener(radiusWatcher);
        diameterTextField.removeTextChangedListener(diameterWatcher);
        circumferenceTextField.removeTextChangedListener(circumferenceWatcher);
        areaTextField.removeTextChangedListener(areaWatcher);

        radiusTextField.setHint("");
        diameterTextField.setHint("");
        circumferenceTextField.setHint("");
        areaTextField.setHint("");

        if(given != 0){
            radiusTextField.setText(String.format(Locale.getDefault(), "%1$,.2f", radius));
        }
        if(given != 1){
            diameterTextField.setText(String.format(Locale.getDefault(), "%1$,.2f", diameter));
        }
        if(given != 2){
            circumferenceTextField.setText(String.format(Locale.getDefault(), "%1$,.2f", circumference));
        }
        if(given != 3){
            areaTextField.setText(String.format(Locale.getDefault(), "%1$,.2f", area));
        }
        radiusTextField.addTextChangedListener(radiusWatcher);
        diameterTextField.addTextChangedListener(diameterWatcher);
        circumferenceTextField.addTextChangedListener(circumferenceWatcher);
        areaTextField.addTextChangedListener(areaWatcher);
    }
    protected void valueToLarge(){
        radiusTextField.removeTextChangedListener(radiusWatcher);
        diameterTextField.removeTextChangedListener(diameterWatcher);
        circumferenceTextField.removeTextChangedListener(circumferenceWatcher);
        areaTextField.removeTextChangedListener(areaWatcher);

        radiusTextField.setHint("Too Large");
        radiusTextField.setText("");
        diameterTextField.setHint("Too Large");
        diameterTextField.setText("");
        circumferenceTextField.setHint("Too Large");
        circumferenceTextField.setText("");
        areaTextField.setHint("Too Large");
        areaTextField.setText("");

        radiusTextField.addTextChangedListener(radiusWatcher);
        diameterTextField.addTextChangedListener(diameterWatcher);
        circumferenceTextField.addTextChangedListener(circumferenceWatcher);
        areaTextField.addTextChangedListener(areaWatcher);

    }
    TextWatcher radiusWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() != 0) {
                changeValues(Double.parseDouble(s.toString()), 0);
            }
        }

        public void afterTextChanged(Editable s) {}
    };
    TextWatcher diameterWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() != 0) {
                changeValues(Double.parseDouble(s.toString()) * .5d, 1);
            }
        }

        public void afterTextChanged(Editable s) {}
    };
    TextWatcher circumferenceWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() != 0) {
                changeValues(Double.parseDouble(s.toString()) /  (2 * pi), 2);
            }
        }

        public void afterTextChanged(Editable s) {}
    };
    TextWatcher areaWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() != 0) {
                Double temp = (Math.sqrt(Double.parseDouble(s.toString()) / pi));
                if(temp > 100000000d){
                    valueToLarge();
                } else {
                    changeValues(temp, 3);
                }
            }
        }

        public void afterTextChanged(Editable s) {}
    };
}
