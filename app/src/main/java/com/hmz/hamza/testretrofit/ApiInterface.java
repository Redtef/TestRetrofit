package com.hmz.hamza.testretrofit;

import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("userControler.php?seConnecter")
    Call<Integer> loginUser(
            @Query("id") String id ,
            @Query("passeWord") String password);

//    @POST("userControler.php?seConnecter")
//    Call<Integer> loginUser(
//            @Query("id") String id,
//            @Query("passeWord") String passeWord
//    );


    @GET("userControler.php?findAll")
    Call<List<User>> findAll();

    @POST("userControler.php?find")
    Call<User> findByID(
            @Query("id") String id
    );

}
