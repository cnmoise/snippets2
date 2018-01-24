package com.example.claud.strangeturn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //alt enter to add imports
    //mVariable instance(member) variable
    private Button mTrueButton;
    private Button mFalseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //all resources are compiled inside R.java file
        mTrueButton = (Button)findViewById(R.id.tbutton);
        //add listener
        mTrueButton.setOnClickListener(new View.OnClickListener(){

               @Override
               public void onClick(View v){
                   //Context is a class

                   Toast customT = Toast.makeText(MainActivity.this, "A resounding success!!!", Toast.LENGTH_LONG);
                   customT.setGravity(Gravity.TOP, 0,0);
                   customT.show();
               }
           }
        );
        mFalseButton = (Button)findViewById(R.id.fbutton);

    }

    //linked to thing we created
    public void onFalseClick(View v){
        Toast customT = Toast.makeText(MainActivity.this, "By Jove!!!", Toast.LENGTH_LONG);
        customT.setGravity(Gravity.TOP, 0,0);
        customT.show();
    }

}