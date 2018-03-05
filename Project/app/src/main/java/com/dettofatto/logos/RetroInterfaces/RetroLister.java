package com.dettofatto.logos.RetroInterfaces;

import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Iscrizione;
import com.dettofatto.logos.entities.Lezione;
import com.dettofatto.logos.entities.Studente;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface RetroLister {
    @FormUrlEncoded
    @POST("logos/GetLezioniPerCorsoServlet")
    Call<List<Lezione>> getLezioniPerCorso(@Field("corso") String Corso);

    @FormUrlEncoded
    @POST("logos/GetLezioniDiOggiServlet")
    Call<List<Lezione>> getLezioniDiOggi(@Field("docente") String docente);

    @FormUrlEncoded
    @POST("logos/GetLezioniDiDomaniServlet")
    Call<List<Lezione>> getLezioniDiDomani(@Field("docente") String docente);

    @FormUrlEncoded
    @POST("logos/GetLezioniDiOggiStudenteServlet")
    Call<List<Lezione>> getLezioniDiOggiStudente(@Field("studente") String studente);

    @GET("GetLezioniDiDomaniStudenteServlet")
    Call<List<RetroLezione>> getLezioniDiDomaniStudente();

    @FormUrlEncoded
    @POST("logos/GetCorsiPerDocenteServlet")
    Call<List<Corso>> getCorsiPerDocente(@Field("docente") String docente);

    @FormUrlEncoded
    @POST("logos/GetCorsiPerStudenteServlet")
    Call<List<Corso>> getCorsiPerStudente(@Field("studente") String studente);

    @GET("getStudentiPerCorsoServlet")
    Call<List<Studente>> getStudentiPerCorso();

    @GET("getIscrizioniperCorsoServlet")
    Call<List<Iscrizione>> getIscrizioniperCorso();
}
