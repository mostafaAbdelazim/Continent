package com.appsinnovate.myapplication.model.get_continent_byId;

import com.appsinnovate.myapplication.model.BaseResponse;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;

import java.util.List;

public class ContinentByIdResponseModel extends BaseResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("continent_name")
    private String continentName;
    @SerializedName("countries")
    private List<Countries> countries;

    public int getId() {
        return id;
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Countries> getCountries() {
        return countries;
    }


}


