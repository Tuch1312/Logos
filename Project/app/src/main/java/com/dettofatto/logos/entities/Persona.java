package com.dettofatto.logos.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by itsadmin on 09/02/2018.
 */

public class Persona {

    @SerializedName("mail")
    private String mail;
    @SerializedName("nome")
    private String nome;
    @SerializedName("cognome")
    private String cognome;
    @SerializedName("immagine")
    private String immagine;
    @SerializedName("indirizzo")
    private String indirizzo;
    @SerializedName("password")
    private String password;



    public Persona() {
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getImmagine() {
        return this.immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}