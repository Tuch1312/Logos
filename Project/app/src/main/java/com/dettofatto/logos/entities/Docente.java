package com.dettofatto.logos.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by itsadmin on 21/02/2018.
 */

public class Docente extends Persona implements Serializable {

    private int oreDaTenere;

    private int oreTenute;

    private List<Corso> corsi;


    public int getOreDaTenere() {
        return this.oreDaTenere;
    }

    public void setOreDaTenere(int oreDaTenere) {
        this.oreDaTenere = oreDaTenere;
    }

    public int getOreTenute() {
        return this.oreTenute;
    }

    public void setOreTenute(int oreTenute) {
        this.oreTenute = oreTenute;
    }


}
