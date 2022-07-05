package com.example.bookstoreg3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.example.bookstoreg3.R;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewlipper;
    Animation slidein, slideout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewlipper = (ViewFlipper) findViewById(R.id.viewlipper);
        slidein = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        slideout = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
        viewlipper.setInAnimation(slidein);
        viewlipper.setOutAnimation(slideout);
        viewlipper.setFlipInterval(10000);
        viewlipper.setAutoStart(true);
    }
}