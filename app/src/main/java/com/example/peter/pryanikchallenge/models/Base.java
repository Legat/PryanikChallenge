package com.example.peter.pryanikchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Base {
    public Base(List<DataStruct> data, List<String> view) {
        this.data = data;
        this.view = view;
    }

    @SerializedName("data")
    @Expose
    private List<DataStruct> data = null;
    @SerializedName("view")
    @Expose
    private List<String> view = null;

    public List<DataStruct> getData() {
        return data;
    }

    public void setData(List<DataStruct> data) {
        this.data = data;
    }

    public List<String> getView() {
        return view;
    }

    public void setView(List<String> view) {
        this.view = view;
    }
}