package com.appsinnovate.myapplication.model.get_continent_byId;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Continent {
    @SerializedName("continent_name")
    private String continentName;

    @SerializedName("id")
    private int id;

    @SerializedName("countries")
    private List<Country> countries;

    public String getContinentName() {
        return continentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Country> getCountries() {
        return countries;
    }
}