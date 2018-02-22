package com.dettofatto.logos.RetroInterfaces;

import retrofit2.Call;
import retrofit2.http.POST;


public interface RetroCorso {
    @POST("NuovoCorsoServlet")
    Call<Boolean> nuovoCorso();

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
