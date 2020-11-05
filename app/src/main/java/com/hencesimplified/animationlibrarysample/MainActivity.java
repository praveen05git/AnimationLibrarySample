package com.hencesimplified.animationlibrarysample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hencesimplified.animationlibrary.AnimationLibrary;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button animateButton;
    Button intentButton;
    TextView textView;
    AnimationLibrary animationLibrary; //Object for Animation Library

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        animateButton = findViewById(R.id.animateButton);
        intentButton = findViewById(R.id.intentButton);
        animationLibrary = new AnimationLibrary(); //Object for Animation Library

        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Animation for Views
                animationLibrary.doFadeInAnimation(textView, getApplicationContext());
                animationLibrary.doShakeAnimation(button, getApplicationContext());
            }
        });

        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);

                //Transition Animation between Activities
                animationLibrary.rightEnterLeftOut(MainActivity.this);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent ExitIntent = new Intent(Intent.ACTION_MAIN);
        ExitIntent.addCategory(Intent.CATEGORY_HOME);
        ExitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ExitIntent);
    }
}