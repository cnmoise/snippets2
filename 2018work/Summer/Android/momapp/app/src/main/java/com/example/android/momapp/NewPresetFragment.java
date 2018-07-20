package com.example.android.momapp;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class NewPresetFragment extends DialogFragment {

    NumberPicker mSecondsPicker;
    NumberPicker mMinutesPicker;
    NumberPicker mHoursPicker;
    public static final long SPEED_UPDATE_PICKER = 10000;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // R.layout.my_layout - that's the layout where your textview is placed
        View view = inflater.inflate(R.layout.ac_new_preset, container, false);
        // you can use your textview.
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.ac_new_preset2, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(v);

        //how the hell do you up the scroll speed?

//        String[] minsecvalues = new String[61];
//
//        for(int i=0; i < minsecvalues.length; i++){
//            minsecvalues[i] = Integer.toString(i);
//        }
//        String[] hourvalues = new String[25];
//
//        for(int i=0; i < hourvalues.length; i++){
//            hourvalues[i] = Integer.toString(i);
//        }
//
//        mSecondsPicker = (NumberPicker) v.findViewById(R.id.np_seconds_picker);
//        mSecondsPicker.setMaxValue(60);
//        mSecondsPicker.setMinValue(0);
//        mSecondsPicker.setWrapSelectorWheel(true);
//        mSecondsPicker.setDisplayedValues(minsecvalues);
//        //mSecondsPicker.setOnLongPressUpdateInterval(8000);
//        //mSecondsPicker.scrollBy(0, 400);
//        //mSecondsPicker.computeScroll();
//        //mSecondsPicker.scrollBy(1, 20);
//
//
//        mMinutesPicker = (NumberPicker) v.findViewById(R.id.np_minutes_picker);
//        mMinutesPicker.setMaxValue(60);
//        mMinutesPicker.setMinValue(0);
//        mMinutesPicker.setWrapSelectorWheel(true);
//        mMinutesPicker.setDisplayedValues(minsecvalues);
//        mMinutesPicker.setOnLongPressUpdateInterval(SPEED_UPDATE_PICKER );
//
//        mHoursPicker = (NumberPicker) v.findViewById(R.id.np_hours_picker);
//        mHoursPicker.setMaxValue(24);
//        mHoursPicker.setMinValue(0);
//        mHoursPicker.setWrapSelectorWheel(true);
//        mHoursPicker.setDisplayedValues(hourvalues);
//        mHoursPicker.setOnLongPressUpdateInterval(SPEED_UPDATE_PICKER );



        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();

        //mSecondsPicker.set

    }

}