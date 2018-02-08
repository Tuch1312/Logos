package businessTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.*;
import business.GestioneCorso;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;
import entity.Studente;

public class GestioneCorsoTest {
	@Test
	public void nuovoCorsoTest() {
		GestioneCorso gc = new GestioneCorso();
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente d = em.find(Docente.class, Filltable.maildocente);
		String s = "1,2";
		Date aaa= new Date();
		//boolean esito = gc.nuovoCorso(d, s, s, 2, aaa, 2, 2, 2, s, s, aaa, s, true);
		boolean esito = gc.nuovoCorso(d, s, s, 2, s, s, false);
		assertTrue("non funziona crea corso", esito == true);
		
		
	}
	
//	@Test
//	public void eliminaCorsoTest() {
//		GestioneCorso gc = new GestioneCorso();
//		Docente d = new Docente();
//		d.setNome("ciao");
//		d.setCognome("ciao");
//		//ho impostato una mail che non esiste nel database
//		//in questo modo il metodo non effettua modifiche sul db
//		//ma � funzionante
//		d.setMail("cia");
//		d.setPassword("ciao");
//		Corso c = new Corso();
//		c.setIdCorso(3);
//		boolean esito = gc.eliminaCorso(d, c);
//		assertTrue("funziona", esito == false);
//	}
	
//	@Test
//	public void modificaCorsoTest() {
//		EntityManager em = JPAUtility.emf.createEntityManager();
//		GestioneCorso gc = new GestioneCorso();
//		Docente d = new Docente();
//		d.setNome("ciao");
//		d.setCognome("ciao");
//		d.setMail("ciaone");
//		d.setPassword("ciao");
//		Corso c = new Corso();
//		c.setIdCorso(6);
//		c = em.find(Corso.class, c.getIdCorso());
//		Corso nc = em.find(Corso.class, c.getIdCorso());
//		nc.setTitolo("buttana"); 
//		boolean esito = gc.modificaCorso(d, c, nc);
//		assertTrue("funziona", esito == true);
//		
//		
//	}
	
//	@Test
//	public void iscriviStudenteTest() {
//		EntityManager em = JPAUtility.emf.createEntityManager();
//		GestioneCorso gc = new GestioneCorso();
//		Docente d = em.find(Docente.class, Filltable.maildocente);
//		Corso c = em.find(Corso.class, 1);
//		boolean esito = gc.iscriviStudente(d, c, Filltable.mailstudente);
//		assertTrue("non funziona iscirvi studente", esito == true);
//		
//		
//	}
	
//	@Test
//	public void cancellaStudenteTest() {
//		EntityManager em = JPAUtility.emf.createEntityManager();
//		GestioneCorso gc = new GestioneCorso();
//		Docente d = em.find(Docente.class, Filltable.maildocente);
//		Corso c = em.find(Corso.class, 1);
//		Studente s = em.find(Studente.class, Filltable.mailstudente);
//		boolean esito = gc.cancellaStudente(d, c, s);
//		assertTrue("non funziona iscirvi studente", esito == true);
//		
//		
//	}
	
//	@Test
//	public void testIscriviti() {
//		EntityManager em = JPAUtility.emf.createEntityManager();
//		GestioneCorso gc = new GestioneCorso();
//		Studente s = em.find(Studente.class, Filltable.mailstudente);
//		String codiceCorso = "Cn104a6";
//		boolean esito = gc.iscriviti(s, codiceCorso);
//		assertTrue("non funziona iscirviti", esito == true);
//
//		
//	}
}
