package com.example.android.momapp;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class HomeFragment extends Fragment {

    private EditText etPercent;
    private ClipDrawable mImageDrawable;
    private Button mOk;

    // a field in your class
    private int mLevel = 0;
    private int fromLevel = 0;
    private int toLevel = 0;

    public static final int MAX_LEVEL = 10000;
    public static final int LEVEL_DIFF = 100;
    public static final int DELAY = 30;

    private Handler mUpHandler = new Handler();
    private Runnable animateUpImage = new Runnable() {

        @Override
        public void run() {
            doTheUpAnimation(fromLevel, toLevel);
        }
    };

    private Handler mLeftHandler = new Handler();
    private Runnable animateLeftImage = new Runnable() {

        @Override
        public void run() {
            doTheLeft(fromLevel, toLevel);
        }
    };

    private Handler mDownHandler = new Handler();
    private Runnable animateDownImage = new Runnable() {

        @Override
        public void run() {
            doTheDownAnimation(fromLevel, toLevel);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_home, container, false);

        super.onCreate(savedInstanceState);


        etPercent = (EditText) v.findViewById(R.id.etPercent);

        ImageView img = (ImageView) v.findViewById(R.id.imageView1);
        mOk = (Button) v.findViewById(R.id.bt_ok);
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAltOkClick(getView());
            }
        });


        mImageDrawable = (ClipDrawable) img.getDrawable();
        mImageDrawable.setLevel(0);


        return v;
    }

    private void doTheUpAnimation(int fromLevel, int toLevel) {
        mLevel += LEVEL_DIFF;
        mImageDrawable.setLevel(mLevel);
        if (mLevel <= toLevel) {
            mUpHandler.postDelayed(animateUpImage, DELAY);
        } else {
            mUpHandler.removeCallbacks(animateUpImage);
            fromLevel = toLevel;
        }
    }

    private void doTheLeft(int fromLevel, int toLevel) {
        mLevel += LEVEL_DIFF;
        mImageDrawable.setLevel(mLevel);
        if (mLevel <= toLevel) {
            mUpHandler.postDelayed(animateLeftImage, DELAY);
        } else {
            mUpHandler.removeCallbacks(animateUpImage);
            fromLevel = toLevel;
        }
    }

    private void doTheDownAnimation(int fromLevel, int toLevel) {
        mLevel -= LEVEL_DIFF;
        mImageDrawable.setLevel(mLevel);
        if (mLevel >= toLevel) {
            mDownHandler.postDelayed(animateDownImage, DELAY);
        } else {
            mDownHandler.removeCallbacks(animateDownImage);
            fromLevel = toLevel;
        }
    }

    public void onOkClick(View v) {
        int temp_level = ((Integer.parseInt(etPercent.getText().toString())) * MAX_LEVEL) / 100;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }
        if(temp_level <= MAX_LEVEL){
            toLevel = temp_level;
        }
        else
        {
            toLevel = toLevel;
        }

        //toLevel = (temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {
            // cancel previous process first
            mDownHandler.removeCallbacks(animateDownImage);
            fromLevel = toLevel;

            mUpHandler.post(animateUpImage);
        } else {
            // cancel previous process first
            mUpHandler.removeCallbacks(animateUpImage);
            fromLevel = toLevel;

            mDownHandler.post(animateDownImage);
        }
    }

    public void onAltOkClick(View v) {
        int temp_level = ((Integer.parseInt(etPercent.getText().toString())) * MAX_LEVEL) / 100;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }

        if(temp_level <= MAX_LEVEL){

            toLevel = temp_level;
        }
        else
        {
            toLevel = toLevel;
        }

        //toLevel = (temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {
            // cancel previous process first
            mDownHandler.removeCallbacks(animateDownImage);
            fromLevel = toLevel;

            mLeftHandler.post(animateLeftImage);
        } else {
            // cancel previous process first
            mLeftHandler.removeCallbacks(animateUpImage);
            fromLevel = toLevel;

            mLeftHandler.post(animateLeftImage);
        }
    }
}

