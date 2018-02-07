package com.example.pfgarofa.bloodpressure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAINACTIVITY";
//    private static final String KEY_CATEGORY = "category";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Handles rotation
//        if (savedInstanceState != null) {
//            mCategory = savedInstanceState.getInt(KEY_CATEGORY, 0);
//            if (mCategory > 0) {
//                mCategoryTextView.setText(BloodPressure.mCategories[mCategory]);
//                mFollowUpTextView.setText(BloodPressure.mRecommendations[mCategory]);
//            }
//        }
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_CATEGORY, mCategory);
//    }
}
