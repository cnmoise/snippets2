package com.example.claud.momappreborn;

import java.util.Date;

/**
 * Created by claud on 8/21/2018.
 */


//AKA a model object
public class SubmittedTaskRow {

    int id;
    long mTimeElapsed;
    String timerTitle;
    Date dateTaskSubmitted;

    public int getId(){
        return id;
    }

    public void setId(){
       this.id = id;
    }

    public String getTimerTitle(){
        return timerTitle;
    }

    public void setTimerTitle(String inputTimerTitle){
        this.timerTitle = inputTimerTitle;
    }

    public Long getTimeElapsed(){
        return mTimeElapsed;
    }

    public void setTimeElapsed(Long inputTimeElapsed){
        this.mTimeElapsed = inputTimeElapsed;
    }

    public Date getDateTaskSubmitted(){return dateTaskSubmitted;}

    public void setDateTaskSubmitted(Date inputDateTaskSubmitted){this.dateTaskSubmitted = inputDateTaskSubmitted;}

}
