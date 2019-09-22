package com.appsinnovate.myapplication.model.get_continents_ids;

import com.appsinnovate.myapplication.model.BaseResponse;

import java.util.List;

public class ContinentsIdsResponseModel extends BaseResponse {
    private List<Integer> continents_ids;

    public List<Integer> getContinents_ids() {
        return continents_ids;
    }
}