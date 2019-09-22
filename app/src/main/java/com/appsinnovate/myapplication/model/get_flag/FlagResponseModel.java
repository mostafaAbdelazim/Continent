package com.appsinnovate.myapplication.model.get_flag;

import com.appsinnovate.myapplication.model.BaseResponse;
import com.squareup.moshi.Json;

public class FlagResponseModel extends BaseResponse {
    @Json(name = "country_flag")
    private CountryFlag countryFlag;

    public CountryFlag getCountryFlag() {
        return countryFlag;
    }

    private class CountryFlag {
        @Json(name = "flag_img")
        String flagImage;

        public String getFlagImage() {
            return flagImage;
        }
    }
}