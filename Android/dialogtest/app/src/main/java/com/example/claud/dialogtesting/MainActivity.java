package com.example.claud.dialogtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    private TextView textViewUsername;
    private TextView textViewPassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUsername = (TextView) findViewById(R.id.textview_username);
        textViewPassword = (TextView) findViewById(R.id.textview_password);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }

    public  void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String username, String password) {
//        textViewUsername.setText(username);
//        textViewPassword.setText(password);
        Log.d("claude", "Behold Dialog" + username);
        Log.d("claude", "Behold Dialog" + password);
    }
}
