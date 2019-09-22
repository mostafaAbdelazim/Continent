package com.appsinnovate.myapplication.model.get_info;

import com.appsinnovate.myapplication.model.BaseResponse;
import com.squareup.moshi.Json;

public class CountryInfoResponseModel extends BaseResponse {
    @Json(name = "country_info")
    private CountryInfo countryInfo;

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    private class CountryInfo {
        private String info;

        public String getInfo() {
            return info;
        }
    }
}
