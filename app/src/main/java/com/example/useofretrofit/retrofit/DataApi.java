package com.example.useofretrofit.retrofit;

import com.example.useofretrofit.alldata.Example;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataApi {
  @GET("/api/users/2")
  Call<Example> getAllData();
}
