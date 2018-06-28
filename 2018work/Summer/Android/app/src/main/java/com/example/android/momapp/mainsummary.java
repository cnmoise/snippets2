package com.example.android.momapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class mainsummary extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mCountdownTimer;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//
//    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsummary);

        mCountdownTimer = (TextView) findViewById(R.id.tv_countdown);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mCountdownTimer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mCountdownTimer.setText("Done!");
            }
        }.start();
    }

    //Create listener in the same manner we make buttons
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.timer:
                    selectedFragment = new TimerFragment();
                    break;
                //more cases for more tabs
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

}
