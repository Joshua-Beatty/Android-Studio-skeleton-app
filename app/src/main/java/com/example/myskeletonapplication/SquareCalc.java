package com.example.myskeletonapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Locale;

public class SquareCalc extends AppCompatActivity{
    singleton single = singleton.getInstance();
    Double radius = 0d;
    Double circumference = 0d;
    Double area = 0d;
    ConstraintLayout relativeLayout;
    private EditText radiusTextField;
    private EditText circumferenceTextField;
    private EditText areaTextField;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_calc);
        getSupportActionBar().setTitle("No More Geometry");

        radiusTextField = findViewById(R.id.radiusTextField);
        circumferenceTextField = findViewById(R.id.circumfrencetextfeild);
        areaTextField = findViewById(R.id.areaTextField);

        /* Set Text Watcher listener */
        radiusTextField.addTextChangedListener(radiusWatcher);
        circumferenceTextField.addTextChangedListener(circumferenceWatcher);
        areaTextField.addTextChangedListener(areaWatcher);
        relativeLayout = findViewById(R.id.backg);
        bgChanger();


    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        bgChanger();
    }
    protected void changeValues(double rad, int given){
        radius = rad;
        circumference = radius * 4;
        area = radius * radius;
        if(area > 100000000d || circumference > 100000000d){
            valueToLarge();
            return;
        }
        radiusTextField.removeTextChangedListener(radiusWatcher);
        circumferenceTextField.removeTextChangedListener(circumferenceWatcher);
        areaTextField.removeTextChangedListener(areaWatcher);

        radiusTextField.setHint("");
        circumferenceTextField.setHint("");
        areaTextField.setHint("");

        if(given != 0){
            radiusTextField.setText(String.format(Locale.getDefault(), "%1$,.2f", radius));
        }
        if(given != 2){
            circumferenceTextField.setText(String.format(Locale.getDefault(), "%1$,.2f", circumference));
        }
        if(given != 3){
            areaTextField.setText(String.format(Locale.getDefault(), "%1$,.2f", area));
        }
        radiusTextField.addTextChangedListener(radiusWatcher);
        circumferenceTextField.addTextChangedListener(circumferenceWatcher);
        areaTextField.addTextChangedListener(areaWatcher);
    }
    protected void valueToLarge(){
        radiusTextField.removeTextChangedListener(radiusWatcher);
        circumferenceTextField.removeTextChangedListener(circumferenceWatcher);
        areaTextField.removeTextChangedListener(areaWatcher);

        radiusTextField.setHint("Too Large");
        radiusTextField.setText("");
        circumferenceTextField.setHint("Too Large");
        circumferenceTextField.setText("");
        areaTextField.setHint("Too Large");
        areaTextField.setText("");

        radiusTextField.addTextChangedListener(radiusWatcher);
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
    TextWatcher circumferenceWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() != 0) {
                changeValues(Double.parseDouble(s.toString()) /  (4), 2);
            }
        }

        public void afterTextChanged(Editable s) {}
    };
    TextWatcher areaWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() != 0) {
                Double temp = (Math.sqrt(Double.parseDouble(s.toString())));
                if(temp > 100000000d){
                    valueToLarge();
                } else {
                    changeValues(temp, 3);
                }
            }
        }

        public void afterTextChanged(Editable s) {}
    };
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
            startActivity(new Intent(SquareCalc.this, SettingsActivity.class));
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
}
