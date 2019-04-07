package com.example.peter.pryanikchallenge.delegate.itemviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.peter.pryanikchallenge.R;
import com.example.peter.pryanikchallenge.models.Data;
import com.example.peter.pryanikchallenge.models.DataStruct;

import java.util.List;

public class HzAdapter implements Adapter<List<DataStruct>> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hz_tem, parent, false);
        return new HzViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull List<DataStruct> items, @NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = items.get(position).getData();
        ((HzViewHolder) holder).mName.setText(data.getText());
    }



    static class HzViewHolder extends RecyclerView.ViewHolder {
        TextView mName;

        public HzViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.text_hz);
        }
    }
}
