package com.example.akshar.jsonparsing;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public abstract interface ApiInterface
{
  @GET("json?key=AIzaSyBnBodN9UNp7Gjv_GJtP4tISWyTcWtFXeE&location=21.170240,72.831062&radius=1000")
  Call<ResponseBody> getJsonData(@Query("API_KEY") String Key);
}