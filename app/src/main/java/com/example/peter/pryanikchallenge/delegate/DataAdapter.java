package com.example.peter.pryanikchallenge.delegate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


import com.example.peter.pryanikchallenge.models.DataStruct;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter {

    private List<DataStruct> listData;
    private AdapterDelegatesManager<List<DataStruct>> mDelegatesManager = new AdapterDelegatesManager<>();

    public DataAdapter(List<DataStruct> listData, Context context) {
        this.listData = listData;
        mDelegatesManager.addDelegate(new HzAdapter(0));
        mDelegatesManager.addDelegate(new SelectorAdapter(1,context));
    }

    @Override
    public int getItemViewType(int position) {
        return mDelegatesManager.getItemViewType(listData, position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return mDelegatesManager.onCreateViewHolder(parent, position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        mDelegatesManager.onBindViewHolder(listData, holder, position);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
