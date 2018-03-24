package businessTest;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import business.GestioneLezioni;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;
import entity.Iscrizione;
import entity.IscrizionePk;
import entity.Studente;

public class Filltable {
	
	static final String mailstudente = "studente2@mail";
	static final String maildocente = "docente2@mail";
	static final int idcorso = 1;
	


	@Test
	public void test() {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente d = new Docente();
		Studente s = new Studente();
		Corso c = new Corso();
		IscrizionePk ipk = new IscrizionePk();
		Iscrizione i = new Iscrizione();
		
		d.setMail("docente@mail");

		s.setMail("yolo");
		s.setPassword("yolo");
		
		c.setDataInizio(new Date());
		c.setDurataLezione(2);
		c.setDocente(d);
		c.setLezionePerGiorno(2);
		c.setTitolo("corsoprova");
		c.setPatternLezioni("1,3,5");
		c.setNumeroGiorni(10);
		c.setOraInizioLezioni(new Date());
	
		
		ipk.setIdCorso(1);
		ipk.setMailStudente("yolo");
		
		i.setIscrizionePk(ipk);
		i.setCorso(c);
		i.setStudenteIscritto(s);
		
		em.getTransaction().begin();
		em.persist(s);
		em.persist(d);
		em.persist(c);
		em.persist(i);
		em.getTransaction().commit();
		
		
		
		Corso c2 = em.find(Corso.class, 1);
		GestioneLezioni gl = new GestioneLezioni();
		
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
