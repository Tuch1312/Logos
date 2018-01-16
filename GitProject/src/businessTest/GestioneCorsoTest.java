package businessTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import javax.persistence.EntityManagerFactory;

import org.junit.*;
import business.GestioneCorso;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;

public class GestioneCorsoTest {
	@Test
	public void nuovoCorsoTest() {
		GestioneCorso gc = new GestioneCorso();
		Docente d = new Docente();
		d.setNome("ciao");
		d.setCognome("ciao");
		d.setMail("ciaone");
		d.setPassword("ciao");
		String s = "ciaone";
		Date aaa= new Date();
		boolean esito = gc.nuovoCorso(d, s, s, 2, aaa, 2, 2, 2, s, s, s);
		assertTrue("funziona", esito == true);
		
		
	}
	
	@Test
	public void eliminaCorsoTest() {
		GestioneCorso gc = new GestioneCorso();
		Docente d = new Docente();
		d.setNome("ciao");
		d.setCognome("ciao");
		d.setMail("cia");
		d.setPassword("ciao");
		Corso c = new Corso();
		c.setIdCorso(3);
		boolean esito = gc.eliminaCorso(d, c);
		assertTrue("funziona", esito == false);
		
		
	}
}
