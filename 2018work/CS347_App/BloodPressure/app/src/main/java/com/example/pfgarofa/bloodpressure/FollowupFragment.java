package com.example.pfgarofa.bloodpressure;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FollowupFragment extends Fragment {
    TextView mFollowUpTextView;


    public FollowupFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_followup, container, false);

        mFollowUpTextView = v.findViewById(R.id.recommendation);

        return v;
    }

    public void showFollowUp(int category){
        mFollowUpTextView.setText(BloodPressure.mRecommendations[category]);
    }
}
