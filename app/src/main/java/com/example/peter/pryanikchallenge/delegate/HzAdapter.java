package com.example.peter.pryanikchallenge.delegate;

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

public class HzAdapter extends AbsAdapterDelegate<List<DataStruct>> {
    private static final String NAME_HZ = "hz";
    private static final String NAME_SELECTION = "selector";
    private static final String NAME_PICTURE = "picture";

    public HzAdapter(int viewType) {
        super(viewType);
    }

    @Override
    public boolean isForViewType(@NonNull List<DataStruct> items, int position) {
        return items.get(position).getName().equals(NAME_HZ);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hz_tem, parent, false);
        return new HzViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull List<DataStruct> items, int position, @NonNull RecyclerView.ViewHolder holder) {
         Data data = (Data)items.get(position).getData();
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
