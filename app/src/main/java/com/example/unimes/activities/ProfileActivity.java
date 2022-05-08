package com.example.unimes.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unimes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    Button deleteAccount;
    ProgressBar progessBar;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        deleteAccount=findViewById(R.id.btnDeleteAccount);
        progessBar=findViewById(R.id.progressBar);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ProfileActivity.this);
                dialog.setTitle("Are You Sure?");
                dialog.setMessage("Are you sure you want to delete your account?if you delete your account you will permanently losee your profile,messages and photos ");
           dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {

                   progessBar.setVisibility(View.VISIBLE);

                   firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>(){
                       @Override
                       public void onComplete(@NonNull Tasks task){
                           progessBar.setVisibility(View.GONE);
                           if (task.isSuccessful()){
                               Toast.makeText(ProfileActivity.this, "Account Deleted", Toast.LENGTH_SHORT).show();

                               Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);


                           }else {Toast.makeText(ProfileActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                           }
                       }

                   });
               }
           });
           dialog.setNegativeButton("Dissmiss", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   dialogInterface.dismiss();
               }
           });
           AlertDialog alertDialog = dialog.create();
           alertDialog.show();
            }
        });

    }
}
