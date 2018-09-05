package com.example.claud.strangeturn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =  "QUIZACTIVITY";
    private static final String KEY_INDEX =  "index";

    //alt enter to add imports
    //mVariable instance(member) variable
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };

    private int mCurrentIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate + Bundle");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex =(mCurrentIndex+1) % mQuestionBank.length;
                UpdateQuestion();
            }
        });

        UpdateQuestion();

        //all resources are compiled inside R.java file
        mTrueButton = (Button)findViewById(R.id.tbutton);
        //add listener for our event
        mTrueButton.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v){
                   //Context is a class

                   Toast customT = Toast.makeText(MainActivity.this, R.string.correct_answer, Toast.LENGTH_LONG);
                   customT.setGravity(Gravity.TOP, 0,0);
                   customT.show();
                   checkAnswer(true);
               }
           }
        );
        mFalseButton = (Button)findViewById(R.id.fbutton);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //displays a message to the log console
        //can be filtered out/searched for
        //d stands for debug
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState: ");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    //listeners is where alot of your code lives
    private void UpdateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userChoice){

        boolean correctAnswer = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;
        if (userChoice == correctAnswer){
            messageResId = R.string.correct_answer;
        } else{
            messageResId = R.string.incorrect_answer;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }



    //linked to thing we created
    public void onFalseClick(View v){
        Toast customT = Toast.makeText(MainActivity.this, R.string.incorrect_answer, Toast.LENGTH_LONG);
        customT.setGravity(Gravity.TOP, 0,0);
        customT.show();
        checkAnswer(false);
    }

}