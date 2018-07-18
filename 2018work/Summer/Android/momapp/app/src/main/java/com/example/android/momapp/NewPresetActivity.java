package com.example.android.momapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;

public class NewPresetActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_new_preset);

        String[] nums = new String[21];

        for(int i=0; i < nums.length; i++){
            nums[i] = Integer.toString(i*5);
        }

        NumberPicker np = (NumberPicker) findViewById(R.id.np);
        np.setMaxValue(60);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        np.setDisplayedValues(nums);

    }



}
