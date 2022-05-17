package com.example.unimes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unimes.databinding.ActivityAboutUsBinding;

public class AboutUsActivity extends AppCompatActivity {

    ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAboutUsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.back.setOnClickListener((view) -> {
            Intent intent = new Intent(AboutUsActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }
}