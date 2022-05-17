package com.example.unimes.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.unimes.Adapters.QuestionAdapter;
import com.example.unimes.databinding.FragmentQuestionPollBinding;
import com.example.unimes.models.QuestionPoll;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class QuestionPollFragment extends Fragment {


    private Button QDelete;

    public QuestionPollFragment() {
        // Required empty public constructor
    }

    FragmentQuestionPollBinding binding;
    ArrayList<QuestionPoll> list = new ArrayList<>();
    FirebaseDatabase database;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionPollBinding.inflate(inflater, container, false);

        database = FirebaseDatabase.getInstance();
        QuestionAdapter adapter = new QuestionAdapter(list, getContext());
        binding.QPollRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.QPollRecyclerView.setLayoutManager(layoutManager);

        database.getReference().child("Question Poll").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    QuestionPoll questionPoll = dataSnapshot.getValue(QuestionPoll.class);
                    questionPoll.setQuestionId(dataSnapshot.getKey());
                    list.add(questionPoll);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return binding.getRoot();
    }
}