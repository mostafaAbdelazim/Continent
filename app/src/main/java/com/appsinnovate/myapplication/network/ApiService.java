package com.appsinnovate.myapplication.network;

import com.appsinnovate.myapplication.model.get_continent_byId.ContinentByIdResponseModel;
import com.appsinnovate.myapplication.model.get_continents_ids.ContinentsIdsResponseModel;
import com.appsinnovate.myapplication.model.get_flag.FlagResponseModel;
import com.appsinnovate.myapplication.model.get_images.CountryImagesResponseModel;
import com.appsinnovate.myapplication.model.get_info.CountryInfoResponseModel;
import com.appsinnovate.myapplication.model.pack.Response;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("get_continents_ids")
    Single<ContinentsIdsResponseModel> getContinentsIds();

    @GET("get_continent_byId")
    Single<Response> getContinentsByIds(@Query("continent_id") int id);

    @GET("get_flag")
    Single<FlagResponseModel> getFlag(@Query("country_id") int id);

    @GET("get_info")
    Single<CountryInfoResponseModel> getInfo(@Query("country_id") int id);

    @GET("get_images")
    Single<CountryImagesResponseModel> getImages(@Query("country_id") int id);
}