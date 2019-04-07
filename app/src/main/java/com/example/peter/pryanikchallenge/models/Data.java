package com.example.peter.pryanikchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    public Data(String text) {
        this.text = text;
    }

    public Data(int selectedId, List<Variant> variants) {
        this.selectedId = selectedId;
        this.variants = variants;
    }

    public Data(String text, String url) {
        this.text = text;
        this.url = url;
    }

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("selectedId")
    @Expose
    private int selectedId;
    @SerializedName("variants")
    @Expose
    private List<Variant> variants = null;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
}
