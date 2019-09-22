package com.appsinnovate.myapplication.model.get_info;

import com.appsinnovate.myapplication.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class CountryInfoResponseModel extends BaseResponse {
    @SerializedName("country_info")
    private CountryInfo countryInfo;

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public class CountryInfo {
        @SerializedName("info")
        private String info;

        public String getInfo() {
            return info;
        }
    }
}
