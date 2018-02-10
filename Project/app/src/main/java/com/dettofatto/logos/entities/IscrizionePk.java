package com.dettofatto.logos.entities;

/**
 * Created by itsadmin on 09/02/2018.
 */

public class IscrizionePk {


    private String mailStudente;

    private int idCorso;




    public String getMailStudente() {
        return mailStudente;
    }

    public void setMailStudente(String mailStudente) {
        this.mailStudente = mailStudente;
    }

    public int getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(int idCorso) {
        this.idCorso = idCorso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idCorso;
        result = prime * result + ((mailStudente == null) ? 0 : mailStudente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IscrizionePk other = (IscrizionePk) obj;
        if (idCorso != other.idCorso)
            return false;
        if (mailStudente == null) {
            if (other.mailStudente != null)
                return false;
        } else if (!mailStudente.equals(other.mailStudente))
            return false;
        return true;
    }





}
