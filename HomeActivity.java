package com.androidexample.thecroutongame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {

    public String bundleCrouton;
    private int mCurrRotation = 0;
    public ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        bundleCrouton = b.getString("crouton");
        final View view = findViewById(android.R.id.content);
        imageview = findViewById(R.id.croutonIMG);
        imageview.setImageResource(getResources().getIdentifier(bundleCrouton, "drawable", getPackageName()));

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layoutID);
        rainbowBackground(layout);

        rotateHandler(view);
    }

    public void rainbowBackground(final RelativeLayout view){

        goToRed(view);
        goToYellow(view);
        goToGreen(view);
        goToBlue(view);
        goToMagenta(view);

        //rainbowBackground(view);
    }

    public void goToRed(final RelativeLayout view){
        view.setBackgroundColor(Color.RED);
    }

    public void goToYellow(final RelativeLayout view){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        view.setBackgroundColor(Color.YELLOW);
                    }
                }, 1000);
    }

    public void goToGreen(final RelativeLayout view){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        view.setBackgroundColor(Color.GREEN);
                    }
                }, 2000);
    }

    public void goToBlue(final RelativeLayout view){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        view.setBackgroundColor(Color.BLUE);
                    }
                }, 3000);
    }

    public void goToMagenta(final RelativeLayout view){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        view.setBackgroundColor(Color.MAGENTA);
                    }
                }, 4000);
    }

    public void rotateCrouton(View view){
        mCurrRotation %= 360;
        float from = mCurrRotation;
        float to = mCurrRotation += 90;

        final RotateAnimation rotateAnim = new RotateAnimation(
                from, to, imageview.getWidth()/2, imageview.getHeight()/2);
        rotateAnim.setDuration(1000);
        rotateAnim.setFillAfter(true);

        imageview.startAnimation(rotateAnim);
    }

    public void rotateHandler(final View view){
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        rotateCrouton(view);
                    }
                }, 1000);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        rotateCrouton(view);
                    }
                }, 2000);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        rotateCrouton(view);
                    }
                }, 3000);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        rotateCrouton(view);
                    }
                }, 4000);
    }
}

