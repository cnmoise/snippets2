package com.example.claud.sarahswiper;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

    private TextView swiperHome;
    private GestureDetectorCompat claudeGestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swiperHome = (TextView) findViewById(R.id.swiperHome);
        this.claudeGestureDetector = new GestureDetectorCompat(this,this);
        claudeGestureDetector.setOnDoubleTapListener(this);
    }

    //the master method for anything that happens
    @Override
    public boolean onTouchEvent(MotionEvent event){
        //we need to first see if a gesture happened, then carry it out
        //or keep going as normal
        this.claudeGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        swiperHome.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        swiperHome.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        swiperHome.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        swiperHome.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        swiperHome.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        swiperHome.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        swiperHome.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        swiperHome.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        swiperHome.setText("onFling");
        return true;
    }
}
