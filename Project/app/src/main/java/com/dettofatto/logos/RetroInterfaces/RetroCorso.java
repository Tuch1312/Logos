package com.dettofatto.logos.RetroInterfaces;

import com.dettofatto.logos.entities.Docente;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface RetroCorso {
    @FormUrlEncoded
    @POST("logos/NuovoCorsoServlet")
    Call<Boolean> nuovoCorso(@Field("json") String docente, @Field("corso") String corso, @Field("automaticFill") String automaticFill);

    @FormUrlEncoded
    @POST("logos/EliminaCorsoServlet")
    Call<Boolean> eliminaCorso(@Field("docente") String docente, @Field("corso") String corso);

    @FormUrlEncoded
    @POST("logos/ModificaCorsoServlet")
    Call<Boolean> modificaCorso(@Field("docente") String docente, @Field("corso") String corso);

    @POST("IscriviStudenteServlet")
    Call<Boolean> iscriviStudente();

    @POST("IscrivitiServlet")
    Call<Boolean> iscriviti();

    @POST("CancellaStudenteServlet")
    Call<Boolean> cancellaStudente();
}
