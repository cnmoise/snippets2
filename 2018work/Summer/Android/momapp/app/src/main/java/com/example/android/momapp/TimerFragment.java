package com.example.android.momapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TimerFragment extends Fragment implements View.OnClickListener{

    private TextView mCountdownTimer;
    private Button mTimerStartPause;
    private Button mTimerReset;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //good practice, allows for referencing
        View v = inflater.inflate(R.layout.fr_timer, container, false);

        mCountdownTimer = (TextView) v.findViewById(R.id.tv_timer);

        mTimerStartPause = (Button) v.findViewById(R.id.bt_timer_start);
        mTimerStartPause.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mCountdownTimer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mCountdownTimer.setText("Done!");
            }
        }.start();
    }

}
