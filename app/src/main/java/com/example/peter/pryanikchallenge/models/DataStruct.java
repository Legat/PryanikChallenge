package com.example.peter.pryanikchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataStruct{
    public DataStruct(String name, Data data) {
        this.name = name;
        this.data = data;
    }

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}