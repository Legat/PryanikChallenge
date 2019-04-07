package com.example.peter.pryanikchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant {
    public Variant(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("text")
    @Expose
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
