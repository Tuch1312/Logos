package businessTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import business.GestioneLezioni;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;
import entity.Iscrizione;
import entity.IscrizionePk;
import entity.Studente;

class Filltable {
	
	static final String mailstudente = "studente@mail";
	static final String maildocente = "docente@mail";
	static final int idcorso = 1;

	@Test
	void test() {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente d = new Docente();
		Studente s = new Studente();
		Corso c = new Corso();
		IscrizionePk ipk = new IscrizionePk();
		Iscrizione i = new Iscrizione();
		
		d.setMail("docente@mail");

		s.setMail("studente@mail");
		
		c.setDataInizio(new Date());
		c.setDurataLezione(2);
		c.setDocente(d);
		c.setLezionePerGiorno(2);
		c.setTitolo("corsoprova");
		c.setPatternLezioni("1,3,5");
		c.setNumeroGiorni(10);
		c.setOraInizioLezioni(new Date());
		
		ipk.setIdCorso(1);
		ipk.setMailStudente("studente@mail");
		
		i.setIscrizionePk(ipk);
		i.setCorso(c);
		i.setStudenteIscritto(s);
		
		em.getTransaction().begin();
		em.persist(s);
		em.persist(d);
		em.persist(c);
		em.persist(i);
		em.getTransaction().commit();
		
		c = em.find(Corso.class, 1);
		GestioneLezioni gl = new GestioneLezioni();
		gl.creaLezioni(c);
		boolean b = true;
		assertTrue("funziona", b == true);
	}

	public static String getMailstudente() {
		return mailstudente;
	}

	public static String getMaildocente() {
		return maildocente;
	}

	public static int getIdcorso() {
		return idcorso;
	}
	
	

}
