package com.example.pfgarofa.bloodpressure;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InputFragment.FollowUpHandler  {

    private static final String TAG = "MAINACTIVITY";
//    private static final String KEY_CATEGORY = "category";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if its the first time the fragments are being made
        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();

            //check for the frame
            //these sections, fill out the frame with the content in the fragment classes
            if(findViewById(R.id.fragment_input2) != null){

                InputFragment inputFragment = new InputFragment();
                //replace > add to backstack
                fm.beginTransaction().add(R.id.fragment_input2, inputFragment).commit();
            }

            if(findViewById(R.id.fragment_followup) != null){
                FollowupFragment followupFragment = new FollowupFragment();
                fm.beginTransaction().add(R.id.fragment_followup, followupFragment).commit();

            }
        }

        //Handles rotation
//        if (savedInstanceState != null) {
//            mCategory = savedInstanceState.getInt(KEY_CATEGORY, 0);
//            if (mCategory > 0) {
//                mCategoryTextView.setText(BloodPressure.mCategories[mCategory]);
//                mFollowUpTextView.setText(BloodPressure.mRecommendations[mCategory]);
//            }
//        }
    }

    @Override
    public  void displayFollowUp(int category){
        FollowupFragment frag = (FollowupFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_followup);

        frag.showFollowUp(category);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_CATEGORY, mCategory);
//    }
}
