package com.dettofatto.logos.RetroInterfaces;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by itsadmin on 14/02/2018.
 */

public interface RetroLezione {

    @POST("EliminaLezioneServlet")
    Call<Boolean> eliminalezione();

    @FormUrlEncoded
    @POST("AggiungiLezioneServlet")
    Call<Boolean> aggiungilezione(@Field("lezione") String lezione, @Field("corso") String corso);

    @POST("ModificaLezioneServlet")
    Call<Boolean> modificalezione();
}
