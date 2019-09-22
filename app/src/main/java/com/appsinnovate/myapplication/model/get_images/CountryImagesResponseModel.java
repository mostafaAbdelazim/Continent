package com.appsinnovate.myapplication.model.get_images;

import com.appsinnovate.myapplication.model.BaseResponse;
import com.squareup.moshi.Json;

import java.util.List;

public class CountryImagesResponseModel extends BaseResponse {

    @Json(name = "country_images")
    private CountryImages countryImages;

    public CountryImages getCountryImages() {
        return countryImages;
    }

    private class CountryImages {
        @Json(name = "images")
        private List<String> imagesList;

        public List<String> getImagesList() {
            return imagesList;
        }
    }
}
