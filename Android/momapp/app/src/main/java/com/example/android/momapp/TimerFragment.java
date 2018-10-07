package com.example.android.momapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
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

public class TimerFragment extends Fragment implements NewPresetDialog.NewPresetDialogListener{

    private static final long START_TIME_IN_MILLIS = 60000;
    private TextView mTextViewCountdownTimer;

    private EditText mCombinedEditText;


    private Button mTimerStartPause;
    private Button mTimerReset;
    private Button mUserTimerInput;
    private Button mNewPreset;


    private RecyclerView mPresetList;
    private static final int NUM_LIST_ITEMS = 100;
    private PresetAdapter mAdapter;

    private boolean mTimerRunning;
    private static long mTimeAtCreationInMillis = START_TIME_IN_MILLIS;
    private static long mTimeLeftInMillis = mTimeAtCreationInMillis;

    ProgressBar mProgressBar;
    private static int progressBarTicker = 0;
    private static int pBarMax;

    public static final int MAX_LEVEL = 10000;
    public static final int LEVEL_DIFF = 100;
    public static final int DELAY = 30;


    private CountDownTimer mCountdownTimer;
    private static final String TAG = "Claude Timer";
    private static final String LifeCycleTag = TAG + " Lifecycle";
    private static final String ActionTag = TAG + " Action";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(LifeCycleTag, "onCreateView");
        Log.d(TAG, "is mTimerRunning onCreateView" + mTimerRunning);


        //good practice, allows for referencing
        View v = inflater.inflate(R.layout.fr_timer, container, false);

        mTextViewCountdownTimer = (TextView) v.findViewById(R.id.tv_timer);

        //Creates Progress Bar & customizes it
        mProgressBar=(ProgressBar) v.findViewById(R.id.progressbar);
        mProgressBar.setProgress(progressBarTicker);
        Drawable draw = getResources().getDrawable(R.drawable.customprogressbar, null);
        mProgressBar.setProgressDrawable(draw);

        pBarMax = (int) mTimeLeftInMillis;
        mProgressBar.setMax((int) mTimeAtCreationInMillis);
        mProgressBar.setProgress(pBarMax);

        Log.d(TAG, "Max progress (start)"+ pBarMax);
        Log.d(TAG, "mTimeLeftInMillis "+ mTimeLeftInMillis);
        Log.d(TAG, "pbar prog "+ progressBarTicker);

        //sets up RecyclerView & User Preset List
        mPresetList = (RecyclerView) v.findViewById(R.id.rv_presets);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mPresetList.setLayoutManager(layoutManager);
        mPresetList.setHasFixedSize(true);

        // The PresetAdapter is responsible for displaying each item in the list.
        mAdapter = new PresetAdapter(NUM_LIST_ITEMS);
        mPresetList.setAdapter(mAdapter);

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



        //Log.d(TAG, "before mContent mTimerRunning?" + mTimerRunning);
        //Non-critical bug: creating multiple presets won't cancel previous timers
        Fragment mContent = getFragmentManager().findFragmentByTag("SourceFragTag");
        if(mContent != null){
            Log.d(TAG, "Fragment Tag works (Newpreset click)");
            Log.d(TAG, "Frag contents " + mContent.getArguments().getString("params"));

            //Log.d(TAG, "mContent mTimerRunning?" + mTimerRunning);


            String timeFromDialog = mContent.getArguments().getString("params");
            //mTimerRunning = mContent.getArguments().getBoolean("mTimerRunning");
            Log.d(TAG, "mTimerRunning set from dialog " + mTimerRunning);

//            if(mTimerRunning){
//                mCountdownTimer.cancel();
//                Log.d(TAG, "mCountdownTimer.canceled before new timer created from Dialog");
//
//            }

            createUserTimer(timeFromDialog);
        }
        else {
            Log.d(TAG, "mContentNull (Newpreset click)");
        }

        //creates new Presets
        mNewPreset = v.findViewById(R.id.bt_save_new_preset);
        mNewPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mTimerRunning New Preset? " + mTimerRunning);
//                if(mTimerRunning){
//                    mCountdownTimer.cancel();
//                    Log.d(TAG, "mCountdownTimer.canceled before new timer created from Dialog");
//                }
                //pauseTimer();

                NewPresetDialog PresetDialog = new NewPresetDialog();
                PresetDialog.show(getFragmentManager(), "Look Ma' no tags");
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
                //Log.d(TAG, "ProgTick "+ progressBarTicker + " || millisUntilFinished: "+ millisUntilFinished);
                progressBarTicker++;
                mProgressBar.setProgress(pBarMax - (int)progressBarTicker*1000);
                //Log.d(TAG, "Calc: "+ pBarMax + " - " + progressBarTicker*1000);

            }

            @Override
            public void onFinish() {
                Log.d(ActionTag, "onFinish() called mTimerRunning " + mTimerRunning);
                mTimerRunning = false;


                mTimerStartPause.setText("Start");
                mTimerStartPause.setVisibility(View.INVISIBLE);
                mTimerReset.setVisibility(View.VISIBLE);

                Log.d(ActionTag, "onFinish() called mTimerRunning " + mTimerRunning);
//                progressBarTicker++;
//                mProgressBar.setProgress(100);
            }
        }.start();

        //
        Log.d(ActionTag, "Timer Started");

        mTimerRunning = true;
        Log.d(ActionTag, ">startTimer >mTimerRunning " + mTimerRunning);

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
        int seconds = (int) mTimeLeftInMillis / 1000 % 60;
        int minutes = (int) mTimeLeftInMillis / 60000 % 60;
        int hours = (int) mTimeLeftInMillis / 3600000;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d:%02d", hours, minutes, seconds);

        mTextViewCountdownTimer.setText(timeLeftFormatted);

        Log.d(TAG, "Calc: " + hours + " + " + minutes + " + " + seconds);
    }

    private void createUserTimer(String etext){
        long inputSecondsInMillis;
        long inputMinutesInMillis;
        long inputHoursInMillis;

        String etextArray[] = new String[3];

        if(etext.equals("")){
            inputSecondsInMillis = 0;
            inputMinutesInMillis = 0;
            inputHoursInMillis = 0;
        }
        else{
            etextArray = etext.split(":");
            String arraySeconds = etextArray[2];
            Log.d(TAG, "etextArray[2] "+ etextArray[2]);
            String arrayMinutes = etextArray[1];
            Log.d(TAG, "etextArray[1] "+ etextArray[1]);
            String arrayHours = etextArray[0];
            Log.d(TAG, "etextArray[0] "+ etextArray[0]);



            int tranS = parseInt(arraySeconds);
            inputSecondsInMillis = tranS*1000;
            Log.d(TAG, "inputSecondsInMillis "+ inputSecondsInMillis);

            int tranM = parseInt(arrayMinutes);
            inputMinutesInMillis = tranM*60000;
            Log.d(TAG, "inputMinutesInMillis "+ inputMinutesInMillis);

            int tranH = parseInt(arrayHours);
            inputHoursInMillis = tranH*3600000;
            Log.d(TAG, "inputHoursInMillis "+ inputHoursInMillis);

        }
        mTimeAtCreationInMillis = inputSecondsInMillis+inputMinutesInMillis+inputHoursInMillis;
        mTimeLeftInMillis = mTimeAtCreationInMillis;

        Log.d(ActionTag, "Created User Timer");
        updateCountdownText();
        //startTimer();
        Log.d(ActionTag, "TimerRunning before createUserTime? " + mTimerRunning);

        if(mTimerRunning){
            pauseTimer();
            resetTimer();
            startTimer();
        }
        else{
            resetTimer();
            startTimer();
        }
        Log.d(ActionTag, "resetTimer(); startTimer();");
    }

//    private void sendData(){
//        Intent i = new Intent(getActivity().getBaseContext(), MainActivity.class);
//
//        i.putExtra("bool", mTimerRunning);
//    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(LifeCycleTag, "onStart");
        Log.d(LifeCycleTag, "mTimerRunning" + mTimerRunning);

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
        Log.d(LifeCycleTag, "mTimerRunning" + mTimerRunning);


        updateCountdownText();
        Log.d(LifeCycleTag, "mTimerRunning" + mTimerRunning);

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
        Log.d(LifeCycleTag, "onSaveInstanceState");

        //reffering to THIS fragment
        getFragmentManager().putFragment(outState, "TimerFragment", this);
    }


    @Override
    public void passTimeFromDialog(String timeAsText) {
        Log.d(LifeCycleTag, "Behold Dialog" + timeAsText);

        
    }
}
