package com.example.android.momapp;

import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
//import android.support.design.widget.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements NewPresetDialog.NewPresetDialogListener {

    private TextView mTextMessage;
    private TextView mCountdownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets the initial screen to be the home fragment
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_container, new HomeFragment());
        tx.commit();

        //Wires up navigation to XML
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);
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

    @Override
    public void passTimeFromDialog(String timeAsText) {
        Log.d("claude Main", "timeAsText " + timeAsText);
    }
}
