package com.appsinnovate.myapplication.model.get_flag;

import com.appsinnovate.myapplication.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class FlagResponseModel extends BaseResponse {
    @SerializedName("country_flag")
    private CountryFlag countryFlag;

    public CountryFlag getCountryFlag() {
        return countryFlag;
    }

    public class CountryFlag {
        @SerializedName("flag_img")
        private String flagImage;

        public String getFlagImage() {
            return flagImage;
        }
    }
}