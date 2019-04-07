package com.example.peter.pryanikchallenge.delegate.itemviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.peter.pryanikchallenge.models.DataStruct;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {
    private List<DataStruct> listData;
    private SparseArrayCompat<Adapter> mCompat;
    private static final int TYPE_HZ = 0;
    private static final int TYPE_SPINNER = 1;
    private Context context;

    public MainAdapter(@Nullable List<DataStruct> listData, Context context) {
        this.listData = listData;
        this.context = context;
        mCompat = new SparseArrayCompat<>();
        mCompat.put(TYPE_HZ, new HzAdapter());
        mCompat.put(TYPE_SPINNER, new SelectorAdapter(context));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mCompat.get(viewType).onCreateViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Adapter adapter = mCompat.get(holder.getItemViewType());
        adapter.onBindViewHolder(listData, holder, position);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (listData.get(position).getName().equals("hz") ) {
            return TYPE_HZ;
        } else if (listData.get(position).getName().equals("selector")) {
            return TYPE_SPINNER;
        }
        return super.getItemViewType(position);
    }
}
