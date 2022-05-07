package com.example.supprotive.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
//import android.widget.Toast;

//import com.example.unimes.R;
import com.example.supprotive.Constants.Constants;
import com.example.supprotive.MainActivity;
import com.example.unimes.databinding.ActivitySignInBinding;
import com.example.unimes.utilities.Constants;
import com.example.unimes.utilities.PreferenceManager;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

//import java.lang.reflect.Constructor;

//import com.google.firebase.firestore.FirebaseFirestore;

//import java.util.HashMap;

public class SignInActivity1 extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManager = new PreferenceManager(getApplicationContext());
        if(preferenceManager.getBoolean(Constants.KEY_IS_SIGNED_IN)) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setlisteners();
    }

    private void setlisteners() {
        binding.textCreateNewAccount.setOnClickListener( v ->
                startActivity(new Intent(getApplicationContext(), SignUpActivity1.class)));
//        binding.buttonsignin.setOnClickListener(v -> addDataToFirebase());
        binding.buttonsignin.setOnClickListener( v -> {
            if (isValidSignDetails()) {
                signIn();
            }
        });
    }


    //Testing the data sending
    private void addDataToFirebase() {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> data = new HashMap<>();
        data.put("First_Name", "Ravindu");
        data.put("Last_Name", "Jayathilaka");
        database.collection("users")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(exception ->{
                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

