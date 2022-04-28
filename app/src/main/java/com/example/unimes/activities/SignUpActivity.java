package com.example.unimes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.unimes.R;
import com.example.unimes.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListners();
    }

    private void setListners() {
        binding.textSignIn.setOnClickListener( v ->
                startActivity(new Intent(getApplicationContext(), SignInActivity.class)));
    }
}