package com.refeed_ppb1.architecturepapb2.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.refeed_ppb1.architecturepapb2.models.DogRandomResponse;
import com.refeed_ppb1.architecturepapb2.models.DogRepository;

public class DogRandomViewModel extends AndroidViewModel {
    private DogRepository dogRepository = new DogRepository();
    private LiveData<DogRandomResponse> dogRandomLiveData = new MutableLiveData<>();

    public DogRandomViewModel(@NonNull Application application) {
        super(application);
        dogRandomLiveData = dogRepository.getDogLiveData();
    }

    public LiveData<DogRandomResponse> getDogRandomLiveData() {
        return dogRandomLiveData;
    }

    public void fetchDogData() {
        dogRandomLiveData = dogRepository.getRandomDogData();
    }
}
