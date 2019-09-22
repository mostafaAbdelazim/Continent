package com.appsinnovate.myapplication.model;

import com.appsinnovate.myapplication.model.get_continent_byId.ContinentByIdResponseModel;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    private int status;
    private String message;
    @SerializedName("continent")
    private ContinentByIdResponseModel continentByIdResponseModel;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
