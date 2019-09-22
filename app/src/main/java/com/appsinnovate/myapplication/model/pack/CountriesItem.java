package com.appsinnovate.myapplication.model.pack;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CountriesItem {

    @SerializedName("flag_img")
    private String flagImg;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    public CountriesItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setFlagImg(String flagImg) {
        this.flagImg = flagImg;
    }

    public String getFlagImg() {
        return flagImg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "CountriesItem{" +
                        "flag_img = '" + flagImg + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CountriesItem) {
            return this == obj;
        } else {
            return false;
        }

    }
}