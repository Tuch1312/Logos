package com.dettofatto.logos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by itsadmin on 22/02/2018.
 */

public class RetrofitSingleton{

    Gson gson = new GsonBuilder().create();

    private static RetrofitSingleton instance;
    public static Retrofit r;

    private RetrofitSingleton(){
        String BASE_URL = "http://18.194.218.75:8080/";
         r =  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static RetrofitSingleton getInstance(){
        if(instance == null){
            instance = new RetrofitSingleton();
        }
        return instance;
    }






}
