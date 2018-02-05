package com.example.claud.strangeturn;

/**
 * Created by claud on 1/23/2018.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    //constructor
    //static - variable shared among all instances of the object
    public Question(int textResId, boolean answerTrue){

        mTextResId = textResId;
        mAnswerTrue = answerTrue;

    }

    public int getTextResId() {
        return mTextResId;
    }
    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

}
