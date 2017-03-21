package com.example.max.myprog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String txtMail = getIntent().getStringExtra("mail");
        String txtPassword = getIntent().getStringExtra("password");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView textV;
        textV = (TextView) findViewById(R.id.textView);
       textV.setText("Вы ввели: \n Email: "+txtMail+"\nPassword"+txtPassword);



    }
}
