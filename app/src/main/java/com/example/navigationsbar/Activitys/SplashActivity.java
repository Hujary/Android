package com.example.navigationsbar.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationsbar.R;

public class SplashActivity extends AppCompatActivity {

    private TextView partyText;
    private TextView dotText;
    private TextView saverText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        partyText = findViewById(R.id.partyText);
        dotText = findViewById(R.id.dotText);
        saverText = findViewById(R.id.saverText);

        Animation splashAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_screen);
        splashAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startMainActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        partyText.startAnimation(splashAnimation);
        dotText.startAnimation(splashAnimation);
        saverText.startAnimation(splashAnimation);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}