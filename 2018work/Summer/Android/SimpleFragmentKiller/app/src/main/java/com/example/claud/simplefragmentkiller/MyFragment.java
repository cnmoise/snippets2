package com.example.claud.simplefragmentkiller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by claud on 8/17/2018.
 */

public class MyFragment extends Fragment {

    TextView mTestTextView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, container, false);

        mTestTextView = (TextView) view.findViewById(R.id.tv_test);
        mTestTextView.setText("GOGOFUCKYOURSELF");
        return view;
    }
}