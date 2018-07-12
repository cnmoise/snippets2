package com.example.android.momapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import static java.lang.Integer.parseInt;

public class TimerFragment extends Fragment{

    private static final long START_TIME_IN_MILLIS = 600000;
    private EditText mSecondsEditText;
    private EditText mMinutesEditText;
    private Button mUserTimerInput;


    private TextView mTextViewCountdownTimer;
    private Button mTimerStartPause;
    private Button mTimerReset;

    private boolean mTimerRunning;
    private static long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private CountDownTimer mCountdownTimer;
    private static final String TAG = MainActivity.class.getSimpleName();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            //Restore the fragment's state here
            Log.d(TAG, "Claude Lifecycle: fragment state here");
            System.out.println("SOPL fragment's state here");
            //mTimeLeftInMillis = savedInstanceState.get();

            Fragment mContent = getFragmentManager().getFragment(savedInstanceState, "TimerFragment");
        }

        //good practice, allows for referencing
        View v = inflater.inflate(R.layout.fr_timer, container, false);

        mTextViewCountdownTimer = (TextView) v.findViewById(R.id.tv_timer);
        mSecondsEditText = (EditText) v.findViewById(R.id.et_timer_entry_s);
        mMinutesEditText = (EditText) v.findViewById(R.id.et_timer_entry_m);


        mUserTimerInput = (Button) v.findViewById(R.id.bt_timer_input);
        mUserTimerInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long inputSecondsInMillis;
                long inputMinutesInMillis;

                if(mSecondsEditText.getText().toString().equals("")){
                    inputSecondsInMillis = 0;
                }
                else{
                    String woah = mSecondsEditText.getText().toString();
                    int dude = parseInt(woah);
                    inputSecondsInMillis = dude*1000;
                }

                if(mMinutesEditText.getText().toString().equals("")){
                    inputMinutesInMillis = 0;
                }
                else {
                    String woah2 = mMinutesEditText.getText().toString();
                    int dude2 = parseInt(woah2);
                    inputMinutesInMillis = dude2*60000;
                }

                mTimeLeftInMillis = inputSecondsInMillis+inputMinutesInMillis;

                startTimer();
            }
        });

        mTimerStartPause = (Button) v.findViewById(R.id.bt_timer_start_pause);
        mTimerStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(mTimerRunning){
                        pauseTimer();
                    } else{
                        startTimer();
                    }

            }
        }



        );

        mTimerReset = v.findViewById(R.id.bt_timer_reset);
        mTimerReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountdownText();

        return v;
    }

    private void startTimer(){
        //how many times the onTick method will be called
        mCountdownTimer = new CountDownTimer(mTimeLeftInMillis, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mTimerStartPause.setText("Start");
                mTimerStartPause.setVisibility(View.INVISIBLE);
                mTimerReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mTimerStartPause.setText("Pause");
        mTimerReset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer(){
        mCountdownTimer.cancel();
        mTimerRunning = false;
        //how to do it w resources?
        mTimerStartPause.setText("Start Timer");
        mTimerReset.setVisibility(View.VISIBLE);

    }
    private void resetTimer(){
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountdownText();

        mTimerReset.setVisibility(View.INVISIBLE);
        mTimerStartPause.setVisibility(View.VISIBLE);
    }
    //where we write into the timer
    private void updateCountdownText(){
        int minutes = (int) mTimeLeftInMillis / 1000 / 60;
        int seconds = (int) mTimeLeftInMillis / 1000 % 60;


        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        mTextViewCountdownTimer.setText(timeLeftFormatted);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Claude Lifecycle: onStart");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Claude Lifecycle: onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Claude Lifecycle: onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Claude Lifecycle: onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Claude Lifecycle: onStop");
//        onSaveInstanceState();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Claude Lifecycle: onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //reffering to THIS fragment
        getFragmentManager().putFragment(outState, "TimerFragment", this);

        //String lifecycleDisplayTextViewContents = mLifecycleDisplay.getText().toString();
        //outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, lifecycleDisplayTextViewContents);
    }

}
