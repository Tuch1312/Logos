package com.dettofatto.logos.RetroInterfaces;

import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Iscrizione;
import com.dettofatto.logos.entities.Studente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;



public interface RetroLister {

    @GET("GetLezioniPerCorsoServlet")
    Call<List<RetroLezione>> getLezioniPerCorso();

    @GET("GetLezioniDiOggiServlet")
    Call<List<RetroLezione>> getLezioniDiOggi();

    @GET("GetLezioniDiDomaniServlet")
    Call<List<RetroLezione>> getLezioniDiDomani();

    @GET("GetLezioniDiOggiStudenteServlet")
    Call<List<RetroLezione>> getLezioniDiOggiStudente();

    @GET("GetLezioniDiDomaniStudenteServlet")
    Call<List<RetroLezione>> getLezioniDiDomaniStudente();

    @GET("getCorsiPerDocenteServlet")
    Call<List<Corso>> getCorsiPerDocente();

    @GET("GetgetCorsiPerStudenteServlet")
    Call<List<RetroCorso>> getCorsiPerStudente();

    @GET("getStudentiPerCorsoServlet")
    Call<List<Studente>> getStudentiPerCorso();

    @GET("getIscrizioniperCorsoServlet")
    Call<List<Iscrizione>> getIscrizioniperCorso();
}
