package com.dettofatto.logos.RetroInterfaces;


import com.dettofatto.logos.entities.Persona;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RetroPersona {

    @POST("LoginServlet")
    Call<Persona> login();

    @POST("RegistrazioneServlet")
    Call<Boolean> registrazione();

    @POST("CambiaPasswordServlet")
    Call<Boolean> cambiaPassword();


}
