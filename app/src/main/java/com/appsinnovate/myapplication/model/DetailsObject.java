package com.appsinnovate.myapplication.model;

import com.appsinnovate.myapplication.model.get_flag.FlagResponseModel;
import com.appsinnovate.myapplication.model.get_images.CountryImagesResponseModel;
import com.appsinnovate.myapplication.model.get_info.CountryInfoResponseModel;
import com.google.gson.annotations.SerializedName;

public class DetailsObject {
    @SerializedName("country_info")
    private CountryInfoResponseModel infoResponseModel;
    @SerializedName("country_images")
    private CountryImagesResponseModel countryImagesResponseModel;
    @SerializedName("country_flag")
    private FlagResponseModel flagResponseModel;

    public DetailsObject(CountryInfoResponseModel infoResponseModel, CountryImagesResponseModel countryImagesResponseModel, FlagResponseModel flagResponseModel) {
        this.infoResponseModel = infoResponseModel;
        this.countryImagesResponseModel = countryImagesResponseModel;
        this.flagResponseModel = flagResponseModel;
    }

    public CountryInfoResponseModel getInfoResponseModel() {
        return infoResponseModel;
    }

    public CountryImagesResponseModel getCountryImagesResponseModel() {
        return countryImagesResponseModel;
    }

    public FlagResponseModel getFlagResponseModel() {
        return flagResponseModel;
    }
}