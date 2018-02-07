package com.example.pfgarofa.bloodpressure;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {
    EditText mSystolic;
    EditText mDiastolic;
    Button mDiagnoseBtn;
    TextView mCategoryTextView;

    int mCategory = 0;

    public InputFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_input, container, false);


        mSystolic = v.findViewById(R.id.systolic_number);
        mDiastolic = v.findViewById(R.id.diastolic_number);
        mDiagnoseBtn = v.findViewById(R.id.diagnose_button);
        mDiagnoseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int systolic = Integer.parseInt(mSystolic.getText().toString());
                    int diastolic = Integer.parseInt(mDiastolic.getText().toString());
                    mCategory = BloodPressure.bp(systolic, diastolic);
                    mCategoryTextView.setText(BloodPressure.mCategories[mCategory]);
                    //mFollowUpTextView.setText(BloodPressure.mRecommendations[mCategory]);
                } catch (RuntimeException rtex) {
                    mCategoryTextView.setText("Input fields must contain numbers");
                    //mFollowUpTextView.setText("");
                    mCategory = 0;
                }
            }
        });
        mCategoryTextView = v.findViewById(R.id.category_text);
        //mFollowUpTextView = findViewById(R.id.recommendation);

        return v;

    }

}
