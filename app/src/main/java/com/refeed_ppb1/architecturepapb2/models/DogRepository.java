package com.refeed_ppb1.architecturepapb2.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.refeed_ppb1.architecturepapb2.services.ApiClient;
import com.refeed_ppb1.architecturepapb2.services.DogService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogRepository {
    private DogService dogService;
    private MutableLiveData<DogRandomResponse> dogLiveData = new MutableLiveData<>();

    public DogRepository() {
        dogService = ApiClient.getRetrofitInstance()
                .create(DogService.class);
    }

    public MutableLiveData<DogRandomResponse> getDogLiveData() {
        return dogLiveData;
    }

    public LiveData<DogRandomResponse> getRandomDogData() {
        dogService.fetchRandomDog().enqueue(new Callback<DogRandomResponse>() {
            @Override
            public void onResponse(Call<DogRandomResponse> call, Response<DogRandomResponse> response) {
                dogLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DogRandomResponse> call, Throwable t) {
                dogLiveData.setValue(null);
            }
        });

        return dogLiveData;
    }
}
