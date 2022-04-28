package com.example.unimes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.widget.Toast;

//import com.example.unimes.R;
import com.example.unimes.databinding.ActivitySignInBinding;

//import com.google.firebase.firestore.FirebaseFirestore;

//import java.util.HashMap;

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
//        binding.buttonsignin.setOnClickListener(v -> addDataToFirebase());
    }

    //Testing the data sending
//    private void addDataToFirebase() {
//        FirebaseFirestore database = FirebaseFirestore.getInstance();
//        HashMap<String, Object> data = new HashMap<>();
//        data.put("First_Name", "Ravindu");
//        data.put("Last_Name", "Jayathilaka");
//        database.collection("users")
//                .add(data)
//                .addOnSuccessListener(documentReference -> {
//                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
//                })
//                .addOnFailureListener(exception ->{
//                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
//                });
//    }
}