package com.example.unimes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unimes.databinding.ActivityCreateQuestionBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CreateQuestionActivity extends AppCompatActivity {

    ActivityCreateQuestionBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateQuestionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        binding.btnCreateQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String question = binding.createdQuestion.getText().toString();
                String answer1 = binding.Answer1.getText().toString();
                String answer2 = binding.Answer2.getText().toString();
                String answer3 = binding.Answer3.getText().toString();
                String answer4 = binding.Answer4.getText().toString();

                HashMap<String, Object> obj = new HashMap<>();
                obj.put("question", question);
                obj.put("answer1", answer1);
                obj.put("answer2", answer2);
                obj.put("answer3", answer3);
                obj.put("answer4", answer4);

                database.getReference().child("Question Poll").child(question).setValue(obj);

                Toast.makeText(CreateQuestionActivity.this, "Question Created", Toast.LENGTH_SHORT).show();
            }
        });
    }
}