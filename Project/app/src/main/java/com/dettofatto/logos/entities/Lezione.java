package com.dettofatto.logos.entities;

import java.util.Date;
import java.util.List;

/**
 * Created by itsadmin on 09/02/2018.
 */

public class Lezione {
    private static final long serialVersionUID = 1L;


    private int idLezione;


    private String argomenti;


    private String assenti;


    private String aula;


    private long data;


    private int durata;

    private int numAssenti;

    private int numeroLezione;


    private String oraInizio;

    private float percentAssenti;


    private List<Presenza> presenza;

    private Corso corso;


    public Lezione() {
    }

    public int getNumeroLezione() {
        return numeroLezione;
    }

    public void setNumeroLezione(int numeroLezione) {
        this.numeroLezione = numeroLezione;
    }

    public int getIdLezione() {
        return this.idLezione;
    }

    public void setIdLezione(int idLezione) {
        this.idLezione = idLezione;
    }

    public String getArgomenti() {
        return this.argomenti;
    }

    public void setArgomenti(String argomenti) {
        this.argomenti = argomenti;
    }

    public String getAssenti() {
        return this.assenti;
    }

    public void setAssenti(String assenti) {
        this.assenti = assenti;
    }

    public String getAula() {
        return this.aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public long getData() {
        return this.data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getDurata() {
        return this.durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getNumAssenti() {
        return this.numAssenti;
    }

    public void setNumAssenti(int numAssenti) {
        this.numAssenti = numAssenti;
    }

    public String getOraInizio() {
        return this.oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public float getPercentAssenti() {
        return this.percentAssenti;
    }

    public void setPercentAssenti(float percentAssenti) {
        this.percentAssenti = percentAssenti;
    }

    public List<Presenza> getAssenzas() {
        return this.presenza;
    }

    public void setAssenzas(List<Presenza> assenzas) {
        this.presenza = assenzas;
    }

    public Presenza addAssenza(Presenza assenza) {
        getAssenzas().add(assenza);
        assenza.setLezione(this);

        return assenza;
    }

    public Presenza removeAssenza(Presenza assenza) {
        getAssenzas().remove(assenza);
        assenza.setLezione(null);

        return assenza;
    }

    public Corso getCorso() {
        return this.corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }
}
