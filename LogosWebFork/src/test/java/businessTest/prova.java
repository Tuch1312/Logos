package businessTest;



import javax.persistence.EntityManager;

import org.junit.Test;

import business.GestionePersona;
import business.JPAUtility;
import entity.Persona;

public class prova {

//	@Test
//	public void testLogin() {
//		GestionePersona gp = new GestionePersona();
//		
//		System.out.println(gp.login("a", "a"));
//		
//	}
	
	@Test
	public void test() {
		EntityManager em = JPAUtility.emf.createEntityManager();
		GestionePersona gp = new GestionePersona();
		String mail = gp.assegnaCodice("mail7");
		Persona p = em.find(Persona.class, mail);
		System.out.println("il nome è : " + p.getCognome() );
	}
	

}
