package com.example.formapp;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import javax.xml.datatype.Duration;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {
    HashSet<String> al = new HashSet<>();
    CheckBox checkB1;
    CheckBox checkB2;
    CheckBox checkB3;
    EditText userInput;
    Button button;
    TextView result;
    RadioGroup rg1;
    RadioButton rb1;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkB1 = (CheckBox) findViewById(R.id.checkBox1);
        checkB2 = (CheckBox) findViewById(R.id.checkBox2);
        checkB3 = (CheckBox) findViewById(R.id.checkBox3);
        checkB1.setOnClickListener(this);
        checkB2.setOnClickListener(this);
        checkB3.setOnClickListener(this);
        userInput = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.answer);
        rg1 = (RadioGroup) findViewById(R.id.rgButton);
        rg1.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);


        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                String s = userInput.getText().toString();
                String pp = "";

                for (String ch : al) {
                    pp = pp + "   " + ch;
                }

                final String finalResult = "User name is:" + "  " + s + "" + "\n" + "Gender is:" + "  " + gender + "" + "\n" + "Hobbies is:" + pp;

                // Alert Dialog on Submit button

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure wants to submit?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //go to logindetail page by clicking "Ok" button of alert dialog
                                Intent intent=new Intent(MainActivity.this,LoginDetails.class);
                                intent.putExtra("Detail",finalResult);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("Cancle", null);
                AlertDialog alert = builder.create();
                alert.setTitle("Hello " + " " + s + "!");
                alert.show();


                // toast on submit button
                switch (v.getId()) {
                    case R.id.button:

                     Toast toast=   Toast.makeText(getApplicationContext(), "Submited",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM | Gravity.LEFT,150,150);
                        toast.show();
                        break;

                }
                /*
                // Go to next page by clicking submit button

                Intent intent=new Intent(MainActivity.this,LoginDetails.class);
                intent.putExtra("Detail",finalResult);
                startActivity(intent);
                */
            }
        });


    }

    // Alert Diaolg on Back button
    @Override
    public void onBackPressed() {
        String s = userInput.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Really Exit?")

                .setMessage("Are you sure wants to exit" + " " + s + " " + "?")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })

                .setNegativeButton("Cancle", null).setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }


    // Radio button data fatch
    @Override
    public void onCheckedChanged(RadioGroup group, int m) {
        switch (m) {
            case R.id.radioButton1:
                gender = "Male";
                break;
            case R.id.radioButton2:
                gender = "Female";
                break;


        }
    }

// checkbox button

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkBox1:
                al.add("playing");
                break;
            case R.id.checkBox2:
                al.add("Listening Songs");
                break;
            case R.id.checkBox3:
                al.add("Driving");
                break;
        }

    }


}


