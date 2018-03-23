package com.dettofatto.logos.RetroInterfaces;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by itsadmin on 14/02/2018.
 */

public interface RetroLezione {

    @FormUrlEncoded
    @POST("logos/EliminaLezione")
    Call<Boolean> eliminalezione(@Field("lezione") String lezione, @Field("corso") String corso);

    @FormUrlEncoded
    @POST("logos/AggiungiLezioneServlet")
    Call<Boolean> aggiungilezione(@Field("lezione") String lezione, @Field("corso") String corso);

    @FormUrlEncoded
    @POST("logos/ModificaLezioneServlet")
    Call<Boolean> modificalezione(@Field("lezione") String lezione, @Field("corso") String corso);
}
