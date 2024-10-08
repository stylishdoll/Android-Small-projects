package com.example.spalashactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Retrieve SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("onboardin", MODE_PRIVATE);
                boolean isOnboardingCompleted = sharedPreferences.getBoolean("onboarding_completed", false);

                // Check if onboarding is completed
                if (isOnboardingCompleted) {
                    // If onboarding completed, launch MainActivity
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Otherwise, launch OnboardingActivity
                    Intent intent = new Intent(SplashActivity.this, OnboardibgActivity.class);
                    startActivity(intent);
                }

                // Close the splash activity so it's not in the back stack
                finish();
            }


        },3000);
    }
}