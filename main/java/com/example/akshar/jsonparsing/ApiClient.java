package com.example.akshar.jsonparsing;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class ApiClient
{
  public static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/search/";
  private static Retrofit retrofit = null;
  
  public static Retrofit getClient()
  {
    HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor();
    localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient localOkHttpClient = new OkHttpClient.Builder().readTimeout(1500, TimeUnit.SECONDS).connectTimeout(1500, TimeUnit.SECONDS).addInterceptor(localHttpLoggingInterceptor).build();
    if (retrofit == null) {
      retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(localOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
    }
    return retrofit;
  }
}
