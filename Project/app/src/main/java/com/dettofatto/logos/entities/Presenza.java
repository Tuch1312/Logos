package com.dettofatto.logos.entities;

/**
 * Created by itsadmin on 09/02/2018.
 */

public class Presenza {



    private int id;



    private Long oraArrivo;


    private Long oraUscita;


    private Lezione lezione;


    private Studente studente;

    private boolean isPresass;

    public boolean isPresass() {
        return isPresass;
    }

    public void setPresass(boolean presass) {
        isPresass = presass;
    }

    public Presenza() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getOraArrivo() {
        return this.oraArrivo;
    }

    public void setOraArrivo(Long oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public Long getOraUscita() {
        return this.oraUscita;
    }

    public void setOraUscita(Long oraUscita) {
        this.oraUscita = oraUscita;
    }

    public Lezione getLezione() {
        return this.lezione;
    }

    public void setLezione(Lezione lezione) {
        this.lezione = lezione;
    }

    public Studente getStudente() {
        return this.studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

}