package com.hencesimplified.animationlibrarysample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hencesimplified.animationlibrary.AnimationLibrary;

public class MainActivity2 extends AppCompatActivity {

    Button button2;
    Button animationButton;
    Button backButton;
    TextView textView2;
    AnimationLibrary animationLibrary; //Object for Animation Library

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        animationButton = findViewById(R.id.animationButton);
        backButton = findViewById(R.id.backButton);
        animationLibrary = new AnimationLibrary(); //Object for Animation Library

        animationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Animation for Views
                animationLibrary.doLeftEnterAnimation(textView2, getApplicationContext());
                animationLibrary.doRightExitAnimation(button2, getApplicationContext());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeIntent);

                //Transition Animation between Activities
                animationLibrary.leftEnterRightOut(MainActivity2.this);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(homeIntent);

        //Transition Animation between Activities
        animationLibrary.leftEnterRightOut(MainActivity2.this);
    }
}