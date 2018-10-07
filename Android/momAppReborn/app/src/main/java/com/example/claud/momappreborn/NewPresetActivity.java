package com.example.claud.momappreborn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by claud on 8/20/2018.
 */

public class NewPresetActivity extends AppCompatActivity{

    private EditText mCombinedEditText;
    private EditText mTimerTitleEditText;
    private Button mHomeButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_new_preset);
        Bundle extras = getIntent().getExtras();



        mTimerTitleEditText = (EditText) findViewById(R.id.et_timer_title);

        mCombinedEditText = (EditText) findViewById(R.id.et_timer_entry_c);
        mCombinedEditText.addTextChangedListener(mCombinedWatcher);

        mCombinedEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int position = mCombinedEditText.length();
                if (hasFocus) {
                    //Log.d(TAG, "position " + position);
                    mCombinedEditText.setSelection(mCombinedEditText.length());

                }
            }

        });

        mHomeButton = (Button) findViewById(R.id.bt_timer_input);
        mHomeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendMeHome();
                    }
                }
        );

        if (extras != null) {
            String timeAsText = extras.getString("timeAsText");
            String timerTitle = extras.getString("timerTitle");
            //The key argument here must match that used in the other activity

            mCombinedEditText.setText(timeAsText);
            mTimerTitleEditText.setText(timerTitle);

        }
    }

    public void sendMeHome(){
        Intent i = new Intent();

        String timeAsText = mCombinedEditText.getText().toString();
        String timerTitle = mTimerTitleEditText.getText().toString();


        //key value to lookup in prev. activity
        i.putExtra("timeAsText", timeAsText);
        i.putExtra("timerTitle", timerTitle);

        setResult(RESULT_OK, i);
        finish();
    }

    //autofills colons for the users convenience
    private TextWatcher mCombinedWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String working = s.toString();
            //Log.d(TAG, "Before "+ before);
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
}
