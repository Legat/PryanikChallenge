package com.example.peter.pryanikchallenge.delegate.itemviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.example.peter.pryanikchallenge.R;
import com.example.peter.pryanikchallenge.models.Data;
import com.example.peter.pryanikchallenge.models.DataStruct;
import com.example.peter.pryanikchallenge.models.Variant;

import java.util.ArrayList;
import java.util.List;

public class SelectorAdapter implements Adapter<List<DataStruct>> {
    private Context context;

    public SelectorAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_item, parent, false);
        return new SelectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull List<DataStruct> items, @NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = (Data)items.get(position).getData();
        List<Variant> variants = data.getVariants();
        final List<String> selectList = new ArrayList<>();

        for(Variant var : variants){
            selectList.add(var.getText());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, selectList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ((SelectorViewHolder) holder).spinner.setAdapter(adapter);
    }


    static class SelectorViewHolder extends RecyclerView.ViewHolder {
        Spinner spinner;

        public SelectorViewHolder(View itemView) {
            super(itemView);
            spinner = itemView.findViewById(R.id.spinner);
        }
    }
}
