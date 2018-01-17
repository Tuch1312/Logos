package businessTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import business.GestioneCorso;
import business.GestioneLezioni;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;

class GestioneLezioneTest {

	@Test
	public void creaLezioneTest() {
		EntityManager em = JPAUtility.emf.createEntityManager();
		GestioneCorso gc = new GestioneCorso();
		Docente d = new Docente();
		d.setNome("DocenteProvaLezione");
		d.setCognome("ciao");
		d.setMail("docente@provalezione");
		d.setPassword("ciao");
		String s = "prova";
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		Date inizio= new Date();
		Date ora = new Date(1516176000000L);
		String pattern = "1,2,3"; 
		//Lunedi, mercoledi, venerdi | 2 lezioni al giorno | 2 ore a lezione | a partire da oggi
		gc.nuovoCorso(d, "corsoprovalezione", s, 30, inizio, 2, 4, 20, s, s, s, ora, pattern);
		Corso c = em.find(Corso.class, 1);
		GestioneLezioni gl = new GestioneLezioni();
		boolean esito = gl.creaLezioni(c);
		assertTrue("funziona", esito == true);
		
	}
	
	
}
