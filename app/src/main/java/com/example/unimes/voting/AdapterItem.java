package com.example.unimes.voting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ItemViewHolder> {
    Context context;
    ArrayList<dataUser> dataUserArrayList;
    Locale id = new Locale("in","ID");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-YYYY",id);

    public AdapterItem(Context context, ArrayList<dataUser> dataUserArrayList) {
        this.context = context;
        this.dataUserArrayList = dataUserArrayList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.viewBind(dataUserArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataUserArrayList.size();
    }

