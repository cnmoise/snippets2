package com.example.claudiumoise.refresher2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //in this exercise we create a non-static UI programmatically through JAVA and Relative layout
        //make basic customizations

        RelativeLayout claudeLayout = new RelativeLayout(this);
        claudeLayout.setBackgroundColor(Color.GREEN);

        //main button
        Button redButton = new Button(this);
        redButton.setText("Log IN");
        redButton.setBackgroundColor(Color.RED);

        //username input
        EditText username = new EditText(this);

        //makes it easier to reffer to widgets
        redButton.setId(1);
        username.setId(2);

        //set dimensions
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //position button in the middle
        //addRule()

        //possition this elem above the second one (the button
        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //give our elements some SPACE
        usernameDetails.setMargins(0,0,0,50);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        //gets a piece of info about our code
        //meant to enlarge the username box, and make it the same on all devices
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200, r.getDisplayMetrics());

        username.setWidth(px);

        //every widget is also a view
        //we need to pass in the specifications as the second parameter
        claudeLayout.addView(redButton, buttonDetails);
        claudeLayout.addView(username, usernameDetails);


        //set this activities content to this view
        setContentView(claudeLayout);
    }
}
