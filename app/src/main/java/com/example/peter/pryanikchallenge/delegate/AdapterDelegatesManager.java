package com.example.peter.pryanikchallenge.delegate;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class AdapterDelegatesManager<T>  {

 private SparseArrayCompat<AdapterDelegate<T>> delegates = new SparseArrayCompat<>();

    public void addDelegate(@NonNull AdapterDelegate<T> delegate) {
        int viewType = delegate.getItemViewType();

        if (delegates.get(viewType) != null) {
            throw new IllegalArgumentException("Already registered AdapterDelegate is " + delegates.get(viewType));
        }

        delegates.put(viewType, delegate);
    }

    public int getItemViewType(@NonNull T items, int position) {
        if (items == null) {
            throw new NullPointerException("Items datasource is null!");
        }

        int delegatesCount = delegates.size();

        for (int i = 0; i < delegatesCount; i++) {
            AdapterDelegate<T> delegate = delegates.valueAt(i);
            if (delegate.isForViewType(items, position)) {
                return delegate.getItemViewType();
            }

        }

        throw new IllegalArgumentException(
                "No AdapterDelegate added that matches position=" + position + " in data source");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterDelegate<T> adapterDelegate = delegates.get(viewType);
        if (adapterDelegate == null) {
            throw new NullPointerException("No AdapterDelegate added for ViewType " + viewType);
        }
        return adapterDelegate.onCreateViewHolder(parent);
    }

    public void onBindViewHolder(@NonNull T items,
                                 @NonNull RecyclerView.ViewHolder viewHolder, int position) {
        AdapterDelegate<T> delegate = delegates.get(viewHolder.getItemViewType());

        if (delegate == null) {
            throw new NullPointerException(
                    "No AdapterDelegate added for ViewType " + viewHolder.getItemViewType());
        }
        delegate.onBindViewHolder(items, position, viewHolder);
    }

}
