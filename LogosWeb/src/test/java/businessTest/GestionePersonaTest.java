package businessTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import business.GestionePersona;

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