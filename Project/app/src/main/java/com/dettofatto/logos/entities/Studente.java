package com.dettofatto.logos.entities;

import java.util.List;

/**
 * Created by itsadmin on 09/02/2018.
 */

public class Studente extends Persona {

    private List<Iscrizione> iscrizioni;



    private List<Presenza> presenza;

    private int presenzaOggi;



    public Studente() {
    }



    public int getPresenzaOggi() {
        return presenzaOggi;
    }



    public void setPresenzaOggi(int presenzaOggi) {
        this.presenzaOggi = presenzaOggi;
    }



    public List<Presenza> getPresenza() {
        return this.presenza;
    }


    public void setPresenza(List<Presenza> presenza) {
        this.presenza = presenza;
    }

    public Presenza addPresenza(Presenza presenza) {
        getPresenza().add(presenza);
        presenza.setStudente(this);

        return presenza;
    }

    public Presenza removePresenza(Presenza presenza) {
        getPresenza().remove(presenza);
        presenza.setStudente(null);

        return presenza;
    }

    public String getNome() {
       return super.getNome();
    }

}