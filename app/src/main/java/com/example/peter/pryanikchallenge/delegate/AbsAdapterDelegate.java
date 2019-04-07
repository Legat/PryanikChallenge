package com.example.peter.pryanikchallenge.delegate;

public abstract class AbsAdapterDelegate<T> implements AdapterDelegate<T> {
    public int viewType;

    public AbsAdapterDelegate(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public int getItemViewType() {
        return viewType;
    }
}
