package com.dettofatto.logos.entities;

import android.widget.TextView;

import com.dettofatto.logos.R;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by itsadmin on 09/02/2018.
 */


public class Corso implements Serializable {
    private static final long serialVersionUID = 1L;


    private int idCorso;


    private List<Iscrizione> iscrizioni;


    private long dataInizio;


    private long oraInizioLezioni;


    private String descrizione;


    private String immagine;


    private int lezioneCorrente;


    private int lezioneEffettuate;


    private int numeroGiorni;

    private int numeroLezioni;

    private int numeroStudentiIscritti;

    private int numMaxStudenti;


    private int durataLezione;

    private int oreTotali;

    private int oreTrascorse;

    private String sede;


    private String titolo;


    private Integer lezionePerGiorno;

    private int contatoreGiorniInterno;


    private String patternLezioni;


    private Docente docente;


    private List<Lezione> leziones;


    //Metodi

    public Corso() {
    }


    public String getPatternLezioni() {
        return patternLezioni;
    }


    public void setPatternLezioni(String patternLezioni) {
        this.patternLezioni = patternLezioni;
    }


    public int getContatoreGiorniInterno() {
        return contatoreGiorniInterno;
    }


    public void setContatoreGiorniInterno(int contatoreGiorniInterno) {
        this.contatoreGiorniInterno = contatoreGiorniInterno;
    }


    public long getOraInizioLezioni() {
        return oraInizioLezioni;
    }


    public void setOraInizioLezioni(long oraInizioLezioni) {
        this.oraInizioLezioni = oraInizioLezioni;
    }


    public int getDurataLezione() {
        return durataLezione;
    }


    public void setDurataLezione(int durataLezione) {
        this.durataLezione = durataLezione;
    }


    public int getIdCorso() {
        return this.idCorso;
    }

    public void setIdCorso(int idCorso) {
        this.idCorso = idCorso;
    }

    public long getDataInizio() {
        return this.dataInizio;
    }

    public void setDataInizio(long dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return this.immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getLezioneCorrente() {
        return this.lezioneCorrente;
    }

    public void setLezioneCorrente(int lezioneCorrente) {
        this.lezioneCorrente = lezioneCorrente;
    }

    public int getLezioneEffettuate() {
        return this.lezioneEffettuate;
    }

    public void setLezioneEffettuate(int lezioneEffettuate) {
        this.lezioneEffettuate = lezioneEffettuate;
    }

    public int getNumeroGiorni() {
        return this.numeroGiorni;
    }

    public void setNumeroGiorni(int numeroGiorni) {
        this.numeroGiorni = numeroGiorni;
    }

    public int getNumeroLezioni() {
        return this.numeroLezioni;
    }

    public void setNumeroLezioni(int numeroLezioni) {
        this.numeroLezioni = numeroLezioni;
    }

    public int getNumeroStudentiIscritti() {
        return this.numeroStudentiIscritti;
    }

    public void setNumeroStudentiIscritti(int numeroStudentiIscritti) {
        this.numeroStudentiIscritti = numeroStudentiIscritti;
    }

    public int getNumMaxStudenti() {
        return this.numMaxStudenti;
    }

    public void setNumMaxStudenti(int numMaxStudenti) {
        this.numMaxStudenti = numMaxStudenti;
    }

    public int getOreTotali() {
        return this.oreTotali;
    }

    public void setOreTotali(int oreTotali) {
        this.oreTotali = oreTotali;
    }

    public int getOreTrascorse() {
        return this.oreTrascorse;
    }

    public void setOreTrascorse(int oreTrascorse) {
        this.oreTrascorse = oreTrascorse;
    }

    public String getSede() {
        return this.sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Lezione> getLeziones() {
        return this.leziones;
    }

    public void setLeziones(List<Lezione> leziones) {
        this.leziones = leziones;
    }

    public void addLezione(Lezione lezione) {
        getLeziones().add(lezione);
        lezione.setCorso(this);


    }

    public Lezione removeLezione(Lezione lezione) {
        getLeziones().remove(lezione);
        lezione.setCorso(null);

        return lezione;
    }


    public Integer getLezionePerGiorno() {
        return lezionePerGiorno;
    }

    public void setLezionePerGiorno(Integer lezionePerGiorno) {
        this.lezionePerGiorno = lezionePerGiorno;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}