package com.example.unimes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unimes.databinding.ActivityShowPrivacyPolicyBinding;

public class ShowPrivacyPolicyActivity extends AppCompatActivity {

    ActivityShowPrivacyPolicyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityShowPrivacyPolicyBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.policyBtn.setOnClickListener((view)-> {
            Intent intent = new Intent(ShowPrivacyPolicyActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }
}