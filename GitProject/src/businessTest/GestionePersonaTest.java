package businessTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.*;

import business.GestioneCorso;
import business.GestionePersona;
import business.Lister;
import entity.Corso;
import entity.Studente;

public class GestionePersonaTest {
//	@Test
//	public void testLogin() {
//		GestionePersona gp = new GestionePersona();
//		
//		boolean esito = gp.login("ciaone", "0000");
//		assertTrue("non funziona", esito == false);
//	}
	
	
	@Test
	public void testRegistrazione() {
		GestionePersona gp = new GestionePersona();
		boolean esito = gp.registrazione("ciaone", "ciaone", "sonoUnoStudente", "ciao", "ciaone", "ciaone", false);
		assertTrue("funziona", esito == true);
	}
	



}
