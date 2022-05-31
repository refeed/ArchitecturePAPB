package com.refeed_ppb1.architecturepapb2.services;

import com.refeed_ppb1.architecturepapb2.models.DogRandomResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogService {
    @GET("breeds/image/random")
    Call<DogRandomResponse> fetchRandomDog();


}
