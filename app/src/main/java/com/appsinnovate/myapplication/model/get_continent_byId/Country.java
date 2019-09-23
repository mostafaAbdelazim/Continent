package com.appsinnovate.myapplication.model.get_continent_byId;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("flag_img")
    private String flagImg;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    public Country(int id, String name, String flagImg) {
        this.id = id;
        this.name = name;
        this.flagImg = flagImg;
    }

    public String getFlagImg() {
        return flagImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}