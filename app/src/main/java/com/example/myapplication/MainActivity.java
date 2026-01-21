package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_IN_MILLIS = 10000; // 10 seconds

    private ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingBar = findViewById(R.id.loading_bar);
        loadingBar.setMax(100);

        new CountDownTimer(SPLASH_TIME_IN_MILLIS, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                long elapsedTime = SPLASH_TIME_IN_MILLIS - millisUntilFinished;
                int progress = (int) (elapsedTime * 100 / SPLASH_TIME_IN_MILLIS);
                loadingBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                Intent homeIntent = new Intent(MainActivity.this, HomepageActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }.start();
    }
}