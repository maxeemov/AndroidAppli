package com.example.max.myprog;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity     implements View.OnClickListener{

    TextView textMail;
    TextView text1;
    TextView textPassword;
    Button buttonSubmit;
    Intent intent;

    public String mail = "admin@mail.com";
    public String pass = "admin";

    private static final int SHORT_DELAY = 2000; // 2 seconds




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMail =(EditText) findViewById(R.id.textMail);
        text1 =(TextView)    findViewById(R.id.text1);
        textPassword =(EditText) findViewById(R.id.textPassword);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(this);
        intent = new Intent(this, Activity2.class);


    }
/*
    метод обработки нажатия мыши имплементированный от интерфейса OnClickListener
 */
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonSubmit:

                    goNexActivity();

                break;
            default:
                break;
        }



    }

   public boolean chekin (String str){

       Pattern pattern = Pattern.compile("^[a-zA-Z]{1,30}[a-zA-Z0-9_-]{0,30}[@][a-zA-z0-9]{1,30}[.][a-zA-z]{2,10}$");
       Matcher matcher = pattern.matcher(str);
       return matcher.matches();

   }

public boolean equals(String str1, String str2) {

    if (str1.equals(str2)) {

        return true;
    }
    else   {
        return false;

    }

}

    public void goNexActivity(){
        Toast toast = Toast.makeText(getApplicationContext(), "Переход на следующее Activity", Toast.LENGTH_SHORT);
        if(chekin(textMail.getText().toString())& equals(textMail.getText().toString(),mail)&&
                equals(textPassword.getText().toString(),pass)==true){

            intent.putExtra("mail",textMail.getText().toString());
            intent.putExtra("password",textPassword.getText().toString());
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            startActivity(intent);
        }
        else {
            text1.setText("Неверный Mail или Password");

        }

    }
}