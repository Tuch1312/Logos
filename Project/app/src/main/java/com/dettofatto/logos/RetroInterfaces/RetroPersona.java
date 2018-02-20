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

    @POST("RegistrazioneServlet")
    Call<Boolean> registrazione();

    @POST("CambiaPasswordServlet")
    Call<Boolean> cambiaPassword();


}
