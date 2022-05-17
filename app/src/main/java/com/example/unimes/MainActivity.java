package com.example.unimes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.unimes.Adapters.FragmentsAdapter;
import com.example.unimes.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.setting:
                Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
                break;

            case R.id.logout:
                auth.signOut();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                break;

            case R.id.chatRoom:
                Toast.makeText(this, "Chat Room Activated", Toast.LENGTH_SHORT).show();
                Intent crIntent = new Intent(MainActivity.this, GroupChatActivity.class);
                startActivity(crIntent);
                break;

            case R.id.qPoll:
                Toast.makeText(this, "Create Question Poll", Toast.LENGTH_SHORT).show();
                Intent pollIntent = new Intent(MainActivity.this, CreateQuestionActivity.class);
                startActivity(pollIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}