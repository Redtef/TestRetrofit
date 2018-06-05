package com.hmz.hamza.testretrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //http://127.0.0.1/projects/userManager/user/
//    //tel reel
//    public static final String BASE_URL = "http://192.168.1.10/userManager/user/";
//    //avd
//    public static final String BASE_URL = "http://10.0.2.2/userManager/user/";
    ///genymotion
      public static final String BASE_URL = "http://10.0.3.2/userManager/user/";


    public static Retrofit getApiClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();

        return retrofit;
    }
}
