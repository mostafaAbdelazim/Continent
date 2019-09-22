package com.appsinnovate.myapplication.model.get_continent_byId;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Countries {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("flag_img")
    private String image;

    public Countries(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Countries) {
            return this == obj;
        } else {
            return false;
        }

    }
}

