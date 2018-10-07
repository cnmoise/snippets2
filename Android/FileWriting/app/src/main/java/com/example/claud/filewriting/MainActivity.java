package com.example.claud.filewriting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String filename = "myfile.txt";
    String fileContents = "NEW FILE CREATED!";
    TextView mTVfile;

    EditText mEditText;
    FileInputStream fisExample = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.et_edittext);



        try {
            if (fisExample != null){
                fisExample = openFileInput(filename);
                InputStreamReader isrExample = new InputStreamReader(fisExample);
                BufferedReader br = new BufferedReader(isrExample);
                StringBuilder sb = new StringBuilder();
                String tempText;

                while((tempText = br.readLine()) != null){
                    sb.append(tempText).append("\n");
                }

                mEditText.setText(sb.toString());
            }
            else{
                mEditText.setText("NO FILE");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fisExample != null) {
                try {
                    fisExample.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void xmlsave(View v){
        String etContents = mEditText.getText().toString();
        FileOutputStream FOS = null;

        try {
            FOS = openFileOutput(filename, MODE_PRIVATE);
            FOS.write(etContents.getBytes());

            mEditText.getText().clear();
            Toast.makeText(this, "saved to " + getFilesDir() + "/" + filename, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (FOS != null){
                try {
                    FOS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
