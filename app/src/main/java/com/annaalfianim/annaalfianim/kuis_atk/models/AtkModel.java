package com.annaalfianim.annaalfianim.kuis_atk.models;

import com.google.gson.annotations.SerializedName;

public class AtkModel {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("code")
    private  String code;
    @SerializedName("category")
    private String category;


    public AtkModel() {
    }

    public AtkModel(int id, String title, String code, String category) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
