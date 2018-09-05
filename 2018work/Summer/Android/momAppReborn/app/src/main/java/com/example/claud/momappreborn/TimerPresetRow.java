package com.example.claud.momappreborn;

/**
 * Created by claud on 8/21/2018.
 */


//AKA a model object
public class TimerPresetRow {

    int id;
    String timerTitle, timeAsText;

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

    public String getTimeAsText(){
        return timeAsText;
    }

    public void setTimeAsText(String inputTimeAsText){
        this.timeAsText = inputTimeAsText;
    }

}
