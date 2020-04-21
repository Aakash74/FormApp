package com.example.formapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginDetails extends AppCompatActivity {
  TextView ldetails;
  Button bhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);

        //for details come from home page
        ldetails=(TextView) findViewById(R.id.details);
        final Intent intent=getIntent();
        String finalResult=intent.getStringExtra("Detail");
        ldetails.setText(finalResult);


        //for go to MainActivity page by clicking button "Home"
        bhome=(Button)findViewById(R.id.homebutton);
        bhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent1=new Intent(LoginDetails.this,MainActivity.class);
                 startActivity(intent1);
                 // or    startActivity(new Intent(LoginDetails.this, MainActivity.class));
            }
        });

    }
}
