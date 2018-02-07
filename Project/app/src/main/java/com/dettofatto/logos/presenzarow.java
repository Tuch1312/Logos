package com.dettofatto.logos;

import java.util.Date;

/**
 * Created by itsadmin on 30/01/2018.
 */

public class Presenzarow {
    private String nome, cognome;
    private Date ingresso, uscita;
    private boolean presass;

    public Presenzarow(String n, String c, Date i, Date u) {
        nome = n;
        cognome = c;
        ingresso = i;
        uscita = u;
        presass = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getIngresso() {
        return ingresso;
    }

    public void setIngresso(Date ingresso) {
        this.ingresso = ingresso;
    }

    public Date getUscita() {
        return uscita;
    }

    public void setUscita(Date uscita) {
        this.uscita = uscita;
    }

    public boolean isPresass() {
        return presass;
    }

    public void setPresass(boolean presass) {
        this.presass = presass;
    }
}
