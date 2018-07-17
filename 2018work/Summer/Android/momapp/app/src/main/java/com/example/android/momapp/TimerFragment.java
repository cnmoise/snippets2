package com.example.android.momapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

import static java.lang.Integer.parseInt;

public class TimerFragment extends Fragment{

    private static final long START_TIME_IN_MILLIS = 60000;
    private EditText mSecondsEditText;
    private EditText mMinutesEditText;
    private Button mUserTimerInput;


    private TextView mTextViewCountdownTimer;
    private Button mTimerStartPause;
    private Button mTimerReset;

    private RecyclerView mPresetList;
    private static final int NUM_LIST_ITEMS = 100;
    private PresetAdapter mAdapter;

    private boolean mTimerRunning;
    private static long mTimeAtCreationInMillis = START_TIME_IN_MILLIS;
    private static long mTimeLeftInMillis = mTimeAtCreationInMillis;

    ProgressBar mProgressBar;
    private static int progressBarTicker = 0;
    private static int pBarMax;


    private CountDownTimer mCountdownTimer;
    private static final String TAG = "Claude Timer";
    private static final String LifeCycleTag = TAG + " Lifecycle";
    private static final String ActionTag = TAG + " Action";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            //Restore the fragment's state here
            Log.d(LifeCycleTag, "Fragment state here");
            //mTimeLeftInMillis = savedInstanceState.get();

            Fragment mContent = getFragmentManager().getFragment(savedInstanceState, "TimerFragment");
        }

        //good practice, allows for referencing
        View v = inflater.inflate(R.layout.fr_timer, container, false);

        mTextViewCountdownTimer = (TextView) v.findViewById(R.id.tv_timer);
        mSecondsEditText = (EditText) v.findViewById(R.id.et_timer_entry_s);
        mMinutesEditText = (EditText) v.findViewById(R.id.et_timer_entry_m);

        mProgressBar=(ProgressBar) v.findViewById(R.id.progressbar);
        mProgressBar.setProgress(progressBarTicker);
        // Get the Drawable custom_progressbar
        Drawable draw = getResources().getDrawable(R.drawable.customprogressbar, null);
// set the drawable as progress drawable
        mProgressBar.setProgressDrawable(draw);

        pBarMax = (int) mTimeLeftInMillis;
        mProgressBar.setMax((int) mTimeAtCreationInMillis);
        Log.d(TAG, "Max progress (start)"+ pBarMax);
        mProgressBar.setProgress(pBarMax);

        Log.d(TAG, "mTimeLeftInMillis "+ mTimeLeftInMillis);
        Log.d(TAG, "pbar prog "+ progressBarTicker);


        //sets up RecyclerView & User Preset List
        mPresetList = (RecyclerView) v.findViewById(R.id.rv_presets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mPresetList.setLayoutManager(layoutManager);
        mPresetList.setHasFixedSize(true);

        // The PresetAdapter is responsible for displaying each item in the list.
        mAdapter = new PresetAdapter(NUM_LIST_ITEMS);

        // COMPLETED (9) Set the GreenAdapter you created on mNumbersList
        mPresetList.setAdapter(mAdapter);

        //lets users make their own timers
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

                mTimeAtCreationInMillis = inputSecondsInMillis+inputMinutesInMillis;
                mTimeLeftInMillis = mTimeAtCreationInMillis;

                pauseTimer();
                resetTimer();
                startTimer();
                Log.d(ActionTag, "User Timer Reset, paused then Started");
            }
        });

        //starts paused timer and pauses running timer
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
        Log.d(LifeCycleTag, "onCreateView");

        return v;
    }

    private void startTimer(){


        //how many times the onTick method will be called
        mCountdownTimer = new CountDownTimer(mTimeLeftInMillis, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountdownText();
                //Log.d(TAG, "ProgTick "+ progressBarTicker + " || millisUntilFinished: "+ millisUntilFinished);
                progressBarTicker++;
                mProgressBar.setProgress(pBarMax - (int)progressBarTicker*1000);
                //Log.d(TAG, "Calc: "+ pBarMax + " - " + progressBarTicker*1000);

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mTimerStartPause.setText("Start");
                mTimerStartPause.setVisibility(View.INVISIBLE);
                mTimerReset.setVisibility(View.VISIBLE);

//                progressBarTicker++;
//                mProgressBar.setProgress(100);
            }
        }.start();

        //
        Log.d(ActionTag, "Timer Started");

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

        Log.d(ActionTag, "Timer Paused");
    }
    private void resetTimer(){
        mTimeLeftInMillis = mTimeAtCreationInMillis;
        updateCountdownText();
        progressBarTicker = 0;

        pBarMax = (int) mTimeAtCreationInMillis;
        mProgressBar.setMax((int) mTimeAtCreationInMillis);
        Log.d(TAG, "Max progress (reset) "+ pBarMax);
        mProgressBar.setProgress(pBarMax);

        mTimerReset.setVisibility(View.INVISIBLE);
        mTimerStartPause.setVisibility(View.VISIBLE);

        Log.d(ActionTag, "Timer Reset");
    }
    //where we write into the timer
    private void updateCountdownText(){
        int minutes = (int) mTimeLeftInMillis / 1000 / 60;
        int seconds = (int) mTimeLeftInMillis / 1000 % 60;


        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        mTextViewCountdownTimer.setText(timeLeftFormatted);
        //Log.d(TAG, "Updated CountdownText");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LifeCycleTag, "onStart");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifeCycleTag, "onCreate");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LifeCycleTag, "onResume");

        updateCountdownText();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LifeCycleTag, "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LifeCycleTag, "onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LifeCycleTag, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //reffering to THIS fragment
        getFragmentManager().putFragment(outState, "TimerFragment", this);
        Log.d(LifeCycleTag, "onSaveInstanceState");


        //String lifecycleDisplayTextViewContents = mLifecycleDisplay.getText().toString();
        //outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, lifecycleDisplayTextViewContents);
    }

}
