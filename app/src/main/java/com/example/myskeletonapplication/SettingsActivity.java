package com.example.myskeletonapplication;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Switch mySwitch = null;
    singleton single = singleton.getInstance();
    LinearLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        relativeLayout = findViewById(R.id.backg);
        mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setOnCheckedChangeListener(this);
        bgChanger();
        if(single.darkMode){
            mySwitch.setChecked(true);
        } else {
            mySwitch.setChecked(false);
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            single.darkMode = true;
             //or whatever your image is
            //setContentView(relativeLayout); //you might be forgetting this
        } else {
            single.darkMode = false;
            relativeLayout.setBackgroundResource(R.drawable.white);
        }
        bgChanger();
    }
    public void bgChanger(){
        if(single.darkMode){
            relativeLayout.setBackgroundResource(R.drawable.bg);

        } else {
            relativeLayout.setBackgroundResource(R.drawable.white);
        }

    }
}