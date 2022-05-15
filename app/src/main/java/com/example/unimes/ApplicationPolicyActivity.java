package com.example.unimes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unimes.databinding.ActivityApplicationPolicyBinding;

public class ApplicationPolicyActivity extends AppCompatActivity {

    ActivityApplicationPolicyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApplicationPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.policyBtn.setOnClickListener((view) -> {
            Intent intent = new Intent(ApplicationPolicyActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}