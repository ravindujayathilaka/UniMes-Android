package com.example.unimes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unimes.R;
import com.example.unimes.databinding.ActivityChatBinding;
import com.example.unimes.databinding.ActivityUsersBinding;
import com.example.unimes.models.User;
import com.example.unimes.utilities.Constants;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private User receiverUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();
        loadReceiverDetails();
    }

    private void loadReceiverDetails() {
        receiverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
        binding.textName.setText(receiverUser.name);
    }

    private void setListener() {
        binding.imageBack.setOnClickListener(v -> onBackPressed());
    }
}