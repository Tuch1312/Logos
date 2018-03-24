package businessTest;

import static org.junit.Assert.*;

import org.junit.Test;

import business.GestionePersona;

public class prova {

	@Test
	public void testLogin() {
		GestionePersona gp = new GestionePersona();
		
		System.out.println(gp.login("a", "a"));
		
	}

}
