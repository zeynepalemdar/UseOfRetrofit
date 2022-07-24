package com.example.useofretrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataClient {

   private static Retrofit retrofit;

   private static final String BASE_URL = "https://reqres.in";

   public static Retrofit getRetrofitInstance(){
      if(retrofit == null){
         retrofit = new Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
      }
       return retrofit;
   }





}
