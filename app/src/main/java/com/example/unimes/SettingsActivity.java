package com.example.unimes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

import com.example.unimes.databinding.ActivitySettingsBinding;
import com.example.unimes.models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class SettingsActivity extends AppCompatActivity {

    ActivitySettingsBinding binding;
    FirebaseStorage storage;
    FirebaseAuth auth;
    FirebaseDatabase database;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        storage = FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        database =FirebaseDatabase.getInstance();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.deleteUserAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(SettingsActivity.this)
                        .setTitle(Html.fromHtml("<font color='#9F0B0B'>Delete User Account</font>"))
                        .setMessage(Html.fromHtml("<font color='#9F0B0B'>Deleting this Account will result in completely removing <br/> your account from the system and you won't be access the app</font>"))
                        .setCancelable(false)
                        .setPositiveButton(Html.fromHtml("<font color='#9F0B0B'>Delete</font>"), (dialogInterface, i) -> {
                            database.getReference().child("Users")
                                    .child(user.getUid()).setValue(null).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(SettingsActivity.this, "Account Details Are Deleted", Toast.LENGTH_SHORT).show();
                                            }
                                            else {
                                                Toast.makeText(SettingsActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                            user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SettingsActivity.this, "Account Deleted", Toast.LENGTH_SHORT).show();
                                        auth.signOut();
                                        Intent intent = new Intent(SettingsActivity.this, SignInActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(SettingsActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }).setNegativeButton(Html.fromHtml("<font color='#7946D3'>Dismiss</font>"), (dialogInterface, i) -> dialogInterface.dismiss()).show();
            }
        });

        binding.privacypolicyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, ShowPrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });

        binding.aboutusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String statue = binding.Status.getText().toString();
                String userName = binding.userName.getText().toString();

                HashMap<String, Object> obj = new HashMap<>();
                obj.put("userName", userName);
                obj.put("status", statue);

                database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                        .updateChildren(obj);

                Toast.makeText(SettingsActivity.this, "User Profile Updated", Toast.LENGTH_SHORT).show();
            }
        });

        database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Users users= snapshot.getValue(Users.class);
                        Picasso.get()
                                .load(users.getProfilePic())
                                .placeholder(R.drawable.ic_profile)
                                .into(binding.profileImage);

                        binding.Status.setText(users.getStatus());
                        binding.userName.setText(users.getUserName());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*"); // */*
                startActivityForResult(intent, 33);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data.getData() != null) {
            Uri sFile = data.getData();
            binding.profileImage.setImageURI(sFile);

            final StorageReference reference = storage.getReference().child("profile pictures")
                    .child(FirebaseAuth.getInstance().getUid());

            reference.putFile(sFile).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(SettingsActivity.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                                    .child("profilePic").setValue(uri.toString());
                        }
                    });
                }
            });
        }




    }
}