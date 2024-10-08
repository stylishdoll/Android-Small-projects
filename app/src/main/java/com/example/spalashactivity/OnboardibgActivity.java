package com.example.spalashactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OnboardibgActivity extends AppCompatActivity {
   RecyclerView onboardingRecyclerView;
  OnboardingAdapter onboardingAdapter;
  Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboardibg);

        btn1=findViewById(R.id.btnSkip);
        onboardingRecyclerView = findViewById(R.id.onboardingRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        onboardingRecyclerView.setLayoutManager(layoutManager);

        List<OnboardingItem> onboardingItems = new ArrayList<>();
        onboardingItems.add(new OnboardingItem(R.drawable.shopping2, "Welcome", "Welcome to our app!"));
        onboardingItems.add(new OnboardingItem(R.drawable.shopping3, "Discover", "Explore amazing features!"));
        onboardingItems.add(new OnboardingItem(R.drawable.shopping4, "Get Started", "Let’s get started!"));

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
        onboardingRecyclerView.setAdapter(onboardingAdapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("onboardin", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("onboarding_completed", true);
                editor.apply();
                Intent j = new Intent(OnboardibgActivity.this, MainActivity.class);
                startActivity(j);
            }
        });
    }
}