package com.dettofatto.logos.RetroInterfaces;

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

    @FormUrlEncoded
    @POST("logos/IscriviStudenteServlet")
    Call<Boolean> iscriviStudente(@Field("corso") String corso,@Field("docente") String docente,@Field("mail") String mailStudente);

    @FormUrlEncoded
    @POST("logos/IscrivitiServlet")
    Call<Boolean> iscriviti(@Field("studente") String studente, @Field("codiceCorso") String codiceCorso);

    @FormUrlEncoded
    @POST("logos/CancellaStudenteServlet")
    Call<Boolean> cancellaStudente(@Field("studente") String studente, @Field("corso") String corso, @Field("docente")String docente);
}
