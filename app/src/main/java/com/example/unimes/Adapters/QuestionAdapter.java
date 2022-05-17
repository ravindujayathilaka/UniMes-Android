package com.example.unimes.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unimes.R;
import com.example.unimes.models.QuestionPoll;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{

    ArrayList<QuestionPoll> list;
    Context context;

    public QuestionAdapter(ArrayList<QuestionPoll> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_question_poll, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        QuestionPoll questionPoll = list.get(position);

        holder.question.setText(questionPoll.getQuestion());
        holder.answerText1.setText(questionPoll.getAnswer1());
        holder.answerText2.setText(questionPoll.getAnswer2());
        holder.answerText3.setText(questionPoll.getAnswer3());
        holder.answerText4.setText(questionPoll.getAnswer4());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete Question")
                        .setMessage("Are you sure you want to delete this Question ?")
                        .setCancelable(false)
                        .setPositiveButton(Html.fromHtml("<font color='#000000'>YES</font>"), (dialogInterface, i) -> {
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            database.getReference().child("Question Poll")
                                    .child(questionPoll.getQuestion())
                                    .setValue(null);
                        }).setNegativeButton(Html.fromHtml("<font color='#000000'>NO</font>"), (dialogInterface, i) -> dialogInterface.dismiss()).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView question, answerText1, answerText2, answerText3, answerText4;

        public ViewHolder(View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.question);
            answerText1 = itemView.findViewById(R.id.answerText1);
            answerText2 = itemView.findViewById(R.id.answerText2);
            answerText3 = itemView.findViewById(R.id.answerText3);
            answerText4 = itemView.findViewById(R.id.answerText4);

        }
    }
}
