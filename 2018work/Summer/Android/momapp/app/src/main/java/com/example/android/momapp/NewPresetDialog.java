package com.example.android.momapp;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import static java.lang.Integer.parseInt;

public class NewPresetDialog extends DialogFragment {

    private EditText mCombinedEditText;
    private static long mTimeAtCreationInMillis = 1000;
    private static long mTimeLeftInMillis = 1000;

    private  NewPresetDialogListener listener;

    private static final String TAG = "Claude Preset";
    private static final String LifeCycleTag = TAG + " Lifecycle";
    private static final String ActionTag = TAG + " Action";


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
        builder.setView(v)
            .setTitle("Enter New Preset")
            .setPositiveButton(R.string.di_bt_save, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            String timeAsText = mCombinedEditText.getText().toString();
                            listener.passTimeFromDialog(timeAsText);
                        }
                    })
            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });


        mCombinedEditText = (EditText) v.findViewById(R.id.et_timer_entry_c);
        mCombinedEditText.addTextChangedListener(mCombinedWatcher);

        mCombinedEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int position = mCombinedEditText.length();
                if (hasFocus) {
                    Log.d(TAG, "position " + position);
                    mCombinedEditText.setSelection(mCombinedEditText.length());

                }
            }

        });

        return builder.create();
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



    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (NewPresetDialogListener) context;
        } catch (ClassCastException e){
            e.printStackTrace();
            //throw new ClassCastException(context.toString() + "implement DialogListener fucker");
        }
    }

    public interface NewPresetDialogListener{
        void passTimeFromDialog(String timeAsText);
    }

}