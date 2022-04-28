package com.example.unimes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.unimes.R;
import com.example.unimes.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setlisteners();
    }

    private void setlisteners() {
        binding.textCreateNewAccount.setOnClickListener( v ->
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));
    }
}