package com.dettofatto.logos.RetroInterfaces;


import retrofit2.Call;
import retrofit2.http.POST;

public interface Persona {

    @POST("LoginServlet")
    Call<Persona> login();

    @POST("RegistrazioneServlet")
    Call<Boolean> registrazione();

    @POST("CambiaPasswordServlet")
    Call<Boolean> cambiaPassword();


}
