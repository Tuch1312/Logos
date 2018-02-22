package com.dettofatto.logos.RetroInterfaces;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by itsadmin on 14/02/2018.
 */

public interface RetroLezione {

    @POST("EliminaLezioneServlet")
    Call<Boolean> eliminalezione();

    @POST("AggiungiLezioneServlet")
    Call<Boolean> aggiungilezione();

    @POST("ModificaLezioneServlet")
    Call<Boolean> modificalezione();
}
