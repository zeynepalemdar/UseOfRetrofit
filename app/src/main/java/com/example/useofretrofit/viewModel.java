package com.example.useofretrofit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.useofretrofit.alldata.Example;

public class viewModel extends AndroidViewModel {

    private Repostory repostory;
    private LiveData<Example> userLiveData;

    public viewModel(@NonNull Application application) {
        super(application);
        repostory = new Repostory(application);
        this.userLiveData = repostory.dataResponse();
    }

    public LiveData<Example> getLiveData() {
        return userLiveData;
    }
}
