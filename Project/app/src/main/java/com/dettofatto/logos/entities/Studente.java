package com.dettofatto.logos.entities;

import java.util.List;

/**
 * Created by itsadmin on 09/02/2018.
 */

public class Studente extends Persona {

    private List<Iscrizione> iscrizioni;
    private List<Presenza> presenza;
    private int presenzaOggi;

//Costruttore

    public Studente() {
    }

    //getter and setter



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

    public String getNome() {return super.getNome();}

    public void setNome(String nome) {super.setNome(nome);}

    public String getCognome() {
        return super.getCognome();
    }

    public void setCognome(String cognome) {super.setCognome(cognome);}

    public String getMail() {return super.getMail();}

    public void setMail(String mail)  {super.setMail(mail);}

    public String getIndirizzo() {return super.getIndirizzo();}

    public void setIndirizzo(String indirizzo){super.setIndirizzo(indirizzo);}

    public String getImmagine(){return super.getImmagine();}

    public void setImmagine(String immagine){super.setImmagine(immagine);}

}