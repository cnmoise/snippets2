package com.example.android.momapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
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
    private TextView mTextViewCountdownTimer;

    private EditText mSecondsEditText;
    private EditText mMinutesEditText;
    private EditText mCombinedEditText;


    private Button mTimerStartPause;
    private Button mTimerReset;
    private Button mUserTimerInput;
    private Button mNewPreset;


    private RecyclerView mPresetList;
    private static final int NUM_LIST_ITEMS = 100;
    //private PresetAdapter mAdapter;

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
//        mSecondsEditText = (EditText) v.findViewById(R.id.et_timer_entry_s);
//        mMinutesEditText = (EditText) v.findViewById(R.id.et_timer_entry_m);
        mCombinedEditText = (EditText) v.findViewById(R.id.et_timer_entry_c);
        mCombinedEditText.addTextChangedListener(mCombinedWatcher);

        mCombinedEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int position = mCombinedEditText.length();
                if (hasFocus) {
                    Log.d(TAG, "position " + position);
                    mCombinedEditText.setSelection(mCombinedEditText.length());
                    //mCombinedEditText.setSelection(0);
                    //mCombinedEditText.setText("42");
                    //Editable etext = mCombinedEditText.getText();
                    //Selection.setSelection(etext, position);
                }
            }

        });



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
//        mPresetList = (RecyclerView) v.findViewById(R.id.rv_presets);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        mPresetList.setLayoutManager(layoutManager);
//        mPresetList.setHasFixedSize(true);

        // The PresetAdapter is responsible for displaying each item in the list.
        //mAdapter = new PresetAdapter(NUM_LIST_ITEMS);

        // COMPLETED (9) Set the GreenAdapter you created on mNumbersList
        //mPresetList.setAdapter(mAdapter);

        //lets users make their own timers
        mUserTimerInput = (Button) v.findViewById(R.id.bt_timer_input);
        mUserTimerInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUserTimer();
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

        //creates new Presets
        mNewPreset = v.findViewById(R.id.bt_save_new_preset);
        mNewPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Context context = this;
//                Class destinationActivity = NewPresetActivity.class;
//
//                Intent startNewPresetIntent = new Intent(getActivity(), destinationActivity);
//                startActivity(startNewPresetIntent);
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setMessage(R.string.dialog_message)
//                        .setTitle(R.string.dialog_title);
//                AlertDialog dialog = builder.create();

                DialogFragment newFragment = new NewPresetFragment();
                newFragment.show(getFragmentManager(), "missiles");

            }
        });

        updateCountdownText();
        Log.d(LifeCycleTag, "onCreateView");

        return v;
    }

    //autofills colons for the users convenience
    private TextWatcher mCombinedWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String working = s.toString();
            Log.d(TAG, "Before "+ before);
            boolean isValid = true;
            if (working.length()==2 && before ==0) {
                working+=":";
                mCombinedEditText.setText(working);
                mCombinedEditText.setSelection(working.length());
            }
            else if (working.length()==5 && before ==0) {
                working+=":";
                mCombinedEditText.setText(working);
                mCombinedEditText.setSelection(working.length());
               //int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            }
            else if (working.length()!=9) {
                isValid = false;
            }

            if (!isValid) {
                mCombinedEditText.setError(null);
            } else {
                mCombinedEditText.setError(null);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    };

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
        int seconds = (int) mTimeLeftInMillis / 1000 % 60;
        int minutes = (int) mTimeLeftInMillis / 60000 % 60;
        int hours = (int) mTimeLeftInMillis / 3600000;

//        int seconds = (int) mTimeLeftInMillis / 1000 % 60;
//        int minutes = seconds * 60;
//        int hours = minutes * 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d:%02d", hours, minutes, seconds);

        mTextViewCountdownTimer.setText(timeLeftFormatted);
        //Log.d(TAG, "Updated CountdownText");
        Log.d(TAG, "Calc: " + hours + " + " + minutes + " + " + seconds);
    }
    private void createUserTimer(){
        long inputSecondsInMillis;
        long inputMinutesInMillis;
        long inputHoursInMillis;

        String etext = mCombinedEditText.getText().toString();
        String etextArray[] = new String[3];

        if(mCombinedEditText.getText().toString().equals("")){
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

        if(mTimerRunning){
            pauseTimer();
            resetTimer();
            startTimer();

            Log.d(ActionTag, "pauseTimer();" + "resetTimer();" + "startTimer();");
        } else {
            resetTimer();
            startTimer();

            Log.d(ActionTag, "resetTimer();" + "startTimer();");
        }
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
