package com.example.unimes.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unimes.R;

public class ProfileActivity extends AppCompatActivity {
    Button deleteAccount;
    ProgressBar progessBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        deleteAccount=findViewById(R.id.btnDeleteAccount);
        progessBar=findViewById(R.id.progressBar);

        //firebaseAuth=FirebaseAuth.getInstance();
        //firebaseUser=firebase.getCurrentUser();

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ProfileActivity.this);
                dialog.setTitle("Are You Sure?");
                dialog.setMessage("Are you sure you want to delete your account?if you delete your account you will permanently losee your profile,messages and photos ");
           dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {

               }
           });
            }
        });

    }
}
