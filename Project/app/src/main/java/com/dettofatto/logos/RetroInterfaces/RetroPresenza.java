package com.dettofatto.logos.RetroInterfaces;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by itsadmin on 14/02/2018.
 */

public interface RetroPresenza {
    @POST("SetOraIngressoServlet")
    Call<Boolean> setOraIngresso();

    @POST("SetOraUscitaServlet")
    Call<Boolean> setOraUscita();

    @POST("IsPresenteServlet")
    Call<Boolean> isPresente();
}
