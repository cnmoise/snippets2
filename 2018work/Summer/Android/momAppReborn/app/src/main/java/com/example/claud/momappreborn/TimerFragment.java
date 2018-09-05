package com.example.claud.momappreborn;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;
import static java.lang.Integer.parseInt;

/**
 * Created by claud on 8/16/2018.
 */

public class TimerFragment extends Fragment{

    private static final long START_TIME_IN_MILLIS = 60000;
    private TextView mTextViewCountdownTimer;
    private TextView mTVTimerTitle;


    private Button mTimerStartPause;
    private Button mTimerReset;
    private Button mNewTimer;
    private Button mSubmitTask;
    private Toast mToast;

    private boolean mTimerRunning;
    private static long mTimeAtCreationInMillis = START_TIME_IN_MILLIS;
    private static long mTimeLeftInMillis = mTimeAtCreationInMillis;

    public static long mTimeElapsedInMillis;
    OnSubmitListener mCallback;

    String mDateTaskSubmitted;

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


    public static TimerFragment newInstance(String text) {

        TimerFragment f = new TimerFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //good practice, allows for referencing
        View v = inflater.inflate(R.layout.fr_timer, container, false);

        if(mCountdownTimer != null){
            mCountdownTimer.cancel();
            Log.d(TAG, "mCountdownTimer canceled at onCreateView ");
        }
        else{
            Log.d(TAG, "mCountdownTimer is null at onCreateView ");
        }


        Log.d(LifeCycleTag, "onCreateView");
        mTextViewCountdownTimer = (TextView) v.findViewById(R.id.tv_timer_value);
        mTVTimerTitle = (TextView) v.findViewById(R.id.tv_timer_title);

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
        //starts a new preset activity
        mNewTimer = v.findViewById(R.id.bt_create_timer);
        mNewTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //anything in fragments: use getActivity()
                Intent i = new Intent(getActivity().getApplicationContext(), PresetListActivity.class);
                startActivityForResult(i, 1);
            }
        });

        mSubmitTask = v.findViewById(R.id.bt_submit_task);
        mSubmitTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitTask();
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
                mTimerRunning = false;


                mTimerStartPause.setText("Start");
                mTimerStartPause.setVisibility(View.INVISIBLE);
                mTimerReset.setVisibility(View.VISIBLE);

//                progressBarTicker++;
//                mProgressBar.setProgress(100);
            }
        }.start();
        Log.d(ActionTag, "Timer Started");
        mTimerRunning = true;
        Log.d(ActionTag, ">startTimer >mTimerRunning " + mTimerRunning);

        mTimerStartPause.setText("Pause");
        mTimerReset.setVisibility(View.INVISIBLE);


    }
    private void pauseTimer(){
        try{
            mCountdownTimer.cancel();
            mTimerRunning = false;
            //how to do it w resources?
            mTimerStartPause.setText("Start Timer");
            mTimerReset.setVisibility(View.VISIBLE);
            Log.d(ActionTag, "TryCatch executed (PauseTimer)");

        } catch (Exception e){
            Log.d(TAG, "no Timer object to cancel (pauseTimer)");
        }

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

//        TODO: AutoStarts timer (non-expected behavior, add as option)
//        if(mCountdownTimer != null){
//            pauseTimer();
//            resetTimer();
//            startTimer();
//            Log.d(ActionTag, "pauseTimer();resetTimer(); startTimer();");
//        }
//        else{
//            resetTimer();
//            startTimer();
//        }
//        Log.d(ActionTag, "resetTimer(); startTimer();");
    }

    public void setTitle(String titleString){
        mTVTimerTitle.setText(titleString);
    }

    public void submitTask(){
        String tempTaskTitle = mTVTimerTitle.getText().toString();
        mDateTaskSubmitted = DateFormat.getDateTimeInstance().format(new Date());
        mTimeElapsedInMillis =  mTimeAtCreationInMillis - mTimeLeftInMillis;
        Log.d(TAG, "(mTimeElapsedInMillis) " + mTimeElapsedInMillis + " = "+ mTimeAtCreationInMillis + " - " + mTimeLeftInMillis);

//        String mTimeElapsedInMillisAsString = Long.toString(mTimeElapsedInMillis);

        //TODO Task statistics in bottom TV
        mCallback.onTimeSubmitted(mTimeElapsedInMillis, tempTaskTitle, mDateTaskSubmitted);

        pauseTimer();
        resetTimer();
        mToast = Toast.makeText(getActivity(), "Timer Submitted successfully", Toast.LENGTH_SHORT);
        mToast.show();
    }

    public interface OnSubmitListener {
        public void onTimeSubmitted(Long timeElapsedInMillis, String taskTitle, String dateTaskSubmittedAsText);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnSubmitListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnSubmitListener");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            createUserTimer(data.getStringExtra("timeAsText"));
            setTitle(data.getStringExtra("timerTitle"));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LifeCycleTag, "onStart");
        Log.d(LifeCycleTag, "mTimerRunning " + mTimerRunning);

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
        Log.d(LifeCycleTag, "mTimerRunning " + mTimerRunning);


        updateCountdownText();
        Log.d(LifeCycleTag, "updateCountdownText > mTimerRunning " + mTimerRunning);
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

}
