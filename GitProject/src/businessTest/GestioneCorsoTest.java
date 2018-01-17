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
		Docente d = new Docente();
		d.setNome("ciao");
		d.setCognome("ciao");
		d.setMail("sonoUnoDocente");
		d.setPassword("ciao");
		String s = "1,2";
		Date aaa= new Date();
		boolean esito = gc.nuovoCorso(d, s, s, 2, aaa, 2, 2, 2, s, s, s, aaa, s);
		assertTrue("funziona", esito == true);
		
		
	}
	
	@Test
	public void eliminaCorsoTest() {
		GestioneCorso gc = new GestioneCorso();
		Docente d = new Docente();
		d.setNome("ciao");
		d.setCognome("ciao");
		//ho impostato una mail che non esiste nel database
		//in questo modo il metodo non effettua modifiche sul db
		//ma è funzionante
		d.setMail("cia");
		d.setPassword("ciao");
		Corso c = new Corso();
		c.setIdCorso(3);
		boolean esito = gc.eliminaCorso(d, c);
		assertTrue("funziona", esito == false);
		
		
	}
	
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
	
	@Test
	public void iscriviStudenteTest() {
		GestioneCorso gc = new GestioneCorso();
		Docente d = new Docente();
		d.setNome("ciao");
		d.setCognome("ciao");
		d.setMail("sonoUnoDocente");
		d.setPassword("ciao");
		Corso c = new Corso();
		c.setIdCorso(1);
		Studente s = new Studente();
		s.setMail("sonoUnoStudente");
		boolean esito = gc.iscriviStudente(d, s, c);
		assertTrue("funziona", esito == true);
		
		
	}
}
