package com.dettofatto.logos.RetroInterfaces;


import com.dettofatto.logos.entities.Persona;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetroPersona {
    @FormUrlEncoded
    @POST("logos/LoginServlet")
    Call<ResponseBody> login(@Field("mail")String mail, @Field("password")String password);

    @FormUrlEncoded
    @POST("logos/RegistrazioneServlet")
    Call<Boolean> registrazione(@Field("mail")String mail, @Field("password")String password,@Field("nome")String nome, @Field("cognome")String cognome,@Field("isDocente")boolean isDocente);

    @POST("CambiaPasswordServlet")
    Call<Boolean> cambiaPassword();


}
