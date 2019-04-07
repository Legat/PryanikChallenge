package com.example.peter.pryanikchallenge.delegate;

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

public class SelectorAdapter extends AbsAdapterDelegate<List<DataStruct>> {
    private static final String NAME_HZ = "hz";
    private static final String NAME_SELECTION = "selector";
    private static final String NAME_PICTURE = "picture";

    private Context context;

    public SelectorAdapter(int viewType, Context context) {
        super(viewType);
        this.context = context;
    }

    @Override
    public boolean isForViewType(@NonNull List<DataStruct> items, int position) {
        return items.get(position).getName().equals(NAME_SELECTION);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_item, parent, false);
        return new SelectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull List<DataStruct> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        Data data = (Data)items.get(position).getData();
        List<Variant> variants = data.getVariants();
        final List<String> selectList = new ArrayList<>();

        for(Variant var : variants){
            selectList.add(var.getText());
        }

        Context context2 = ((SelectorViewHolder)holder).spinner.getRootView().getContext();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context2,
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
