package com.dettofatto.logos.RetroInterfaces;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface RetroCorso {
    @FormUrlEncoded
    @POST("logos/NuovoCorsoServlet")
    Call<Boolean> nuovoCorso(@Field("json") String docente, @Field("corso") String corso, @Field("automaticFill") String automaticFill);

    @POST("EliminaCorsoServlet")
    Call<Boolean> eliminaCorso();

    @POST("ModificaCorsoServlet")
    Call<Boolean> modificaCorso();

    @POST("IscriviStudenteServlet")
    Call<Boolean> iscriviStudente();

    @POST("IscrivitiServlet")
    Call<Boolean> iscriviti();

    @POST("CancellaStudenteServlet")
    Call<Boolean> cancellaStudente();


}
