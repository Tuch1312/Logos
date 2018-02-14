package com.dettofatto.logos;

import java.net.URL;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by itsadmin on 14/02/2018.
 */

public class Retrofit {

    public static final String BASE_URL = "http://logoscloud.ddns.net";
    retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    /*Si noti anche si ha bisogno di specificare una factory per la deserializzazione della risposta utilizzando la libreria
    GSON
    Ses vogliamo pasare a un parser personalizzato GSON per esempio è possibile specificare anche:
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
            */

}