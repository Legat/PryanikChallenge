package com.example.peter.pryanikchallenge.delegate.itemviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface Adapter<T> {



    @NonNull
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);


    void onBindViewHolder(@NonNull T items, @NonNull RecyclerView.ViewHolder holder, int position);
}
