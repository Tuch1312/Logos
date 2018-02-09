package com.dettofatto.logos.entities;

/**
 * Created by itsadmin on 09/02/2018.
 */

public class Iscrizione {


    private IscrizionePk iscrizionePk;


    private Corso corso;


    private Studente studenteIscritto;


    public IscrizionePk getIscrizionePk() {
        return iscrizionePk;
    }

    public void setIscrizionePk(IscrizionePk iscrizionePk) {
        this.iscrizionePk = iscrizionePk;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public Studente getStudenteIscritto() {
        return studenteIscritto;
    }

    public void setStudenteIscritto(Studente studenteIscritto) {
        this.studenteIscritto = studenteIscritto;
    }


}
