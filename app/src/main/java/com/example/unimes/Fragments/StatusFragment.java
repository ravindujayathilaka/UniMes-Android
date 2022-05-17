package com.example.unimes.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unimes.Adapters.TopStatusAdapter;
import com.example.unimes.R;
import com.example.unimes.databinding.FragmentStatusBinding;
import com.example.unimes.models.UserStatus;
import com.example.unimes.models.Users;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class StatusFragment extends Fragment {


    public StatusFragment() {
        // Required empty public constructor
    }

    FragmentStatusBinding binding;
    ArrayList<Users> list = new ArrayList<>();
    FirebaseDatabase database;
    ArrayList<UserStatus> userStatuses;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStatusBinding.inflate(inflater, container, false);
        database = FirebaseDatabase.getInstance();
        userStatuses = new ArrayList<>();
        final TopStatusAdapter statusAdapter = new TopStatusAdapter( getContext(), userStatuses);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.statusList.setLayoutManager(layoutManager);
        binding.statusList.setAdapter(statusAdapter);



        return inflater.inflate(R.layout.fragment_status, container, false);
    }
}