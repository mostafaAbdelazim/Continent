package com.appsinnovate.myapplication.model.get_images;

import com.appsinnovate.myapplication.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryImagesResponseModel extends BaseResponse {

    @SerializedName("country_images")
    private CountryImages countryImages;

    public CountryImages getCountryImages() {
        return countryImages;
    }

    public class CountryImages {
        @SerializedName("images")
        private List<String> imagesList;

        public List<String> getImagesList() {
            return imagesList;
        }
    }
}
