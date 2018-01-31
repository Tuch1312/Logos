package com.dettofatto.logos;

import java.util.Date;

/**
 * Created by itsadmin on 30/01/2018.
 */

public class presenzarow {
    public String nome, cognome;
    public Date ingresso, uscita;
    public boolean presass;

    public presenzarow(String n, String c, Date i, Date u) {
        nome = n;
        cognome = c;
        ingresso = i;
        uscita = u;
        presass = false;
    }
}
