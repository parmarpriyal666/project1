package com.example.ganesh.cons;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

public class splash extends AppCompatActivity {
    ImageView logo;
    ProgressBar pg1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = (ImageView) findViewById(R.id.logo);
        pg1=(ProgressBar) findViewById(R.id.pg1);
        Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        logo.startAnimation(rotateAnim);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {

               Intent myint = new Intent(splash.this,MainActivity.class);
               startActivity(myint);
                finish();
            }
        }, 5000);


    }
}
