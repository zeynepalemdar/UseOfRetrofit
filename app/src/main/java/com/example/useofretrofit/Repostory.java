package com.example.useofretrofit;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.useofretrofit.alldata.Example;
import com.example.useofretrofit.retrofit.DataApi;
import com.example.useofretrofit.retrofit.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repostory {

    private final DataApi apiRequest;

    public Repostory(Application aplication) {
        apiRequest = DataClient.getRetrofitInstance().create(DataApi.class);
    }


    public LiveData<Example> dataResponse() {
        MutableLiveData<Example> Example = new MutableLiveData<>();
        apiRequest.getAllData().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.body() != null) {
                    Example.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Example.setValue(null);
            }
        });
        return Example;
    }
}
