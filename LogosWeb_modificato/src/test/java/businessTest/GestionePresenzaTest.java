//package businessTest;
//
//import static org.junit.Assert.assertTrue;
//
//import javax.persistence.EntityManager;
//
//import org.junit.Test;
//
//import business.GestionePresenze;
//import business.JPAUtility;
//import entity.Corso;
//import entity.Docente;
//import entity.Studente;
//
//class GestionePresenzaTest {
//
//	@Test
//	void setoraIngressotest() {
//		EntityManager em = JPAUtility.emf.createEntityManager();
//		Docente d = em.find(Docente.class, "docente@provalezione");
//		Corso c = em.find(Corso.class, 1);
//		Studente s = new Studente();
//		s.setMail("Mail@studnete");
//		s.setNome("nomestudnete");
//		s.setPassword("password");
//		GestionePresenze gp = new GestionePresenze();
//		em.getTransaction().begin();
//		em.persist(s);
//		em.getTransaction().commit();
//		
//		boolean esito = gp.setOraIngresso(d, s, c);
//		assertTrue("funziona", esito == true);
//		
//	}
//	
//
//}
