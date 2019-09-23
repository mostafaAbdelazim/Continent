package com.appsinnovate.myapplication.model.get_continent_byId;

import com.appsinnovate.myapplication.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class ContinentByIdResponseModel extends BaseResponse {
    @SerializedName("continent")
    private Continent continent;

    public Continent getContinent() {
        return continent;
    }
}