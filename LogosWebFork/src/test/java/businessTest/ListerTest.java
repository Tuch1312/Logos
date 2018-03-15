//package businessTest;
//
//import java.util.List;
//
//import org.junit.Test;
//
//import business.Lister;
//import entity.Corso;
//import entity.Iscrizione;
//
//class ListerTest {
//
////	@Test
////	public void  testGetCorsiPerDocente() {
////		Docente d = new Docente();
////		d.setMail("docente@mail");
////		Lister gc = new Lister();
////		List<Corso> lc = gc.getCorsiPerDocente(d);
////		for (Corso c : lc) {
////			System.out.println(c.getIdCorso());
////		}
////	}
////	
////	@Test
////	public void  testGetCorsiPerStudente() {
////		Studente d = new Studente();
////		d.setMail("studente@mail");
////		Lister gc = new Lister();
////		List<Corso> lc = gc.getCorsiPerStudente(d);
////		for (Corso c : lc) {
////			System.out.println(c.getIdCorso());
////		}
////	}
////		
////		@Test 
////		public void getLeziozniPerCorso() {
////			Corso c = new Corso();
////			c.setIdCorso(1);
////			Lister gc = new Lister();
////			List<Lezione> ll = gc.getLezioniPerCorso(c);
////			for (Lezione l : ll) {
////				System.out.println(l.getIdLezione());
////			}
////		}
////	
////	@Test 
////	public void getLeziozniDiOggi() {
////		Studente d = new Studente();
////		d.setMail("studente@mail");
////		Lister gc = new Lister();
////		List<Lezione> ll = gc.getLezioniDiOggi(d);
////		for (Lezione l : ll) {
////			System.out.println(l.getIdLezione());
////			System.out.println(l.getNumeroLezione());
////			System.out.println(l.getOraInizio());
////		
////		}
////	}
////	
////	
////	
////	@Test 
////	public void getLeziozniDiDomani() {
////		Lister gc = new Lister();
////		Studente d = new Studente();
////		d.setMail("studente@mail");
////		List<Lezione> ll = gc.getLezioniDiDomani(d);
////		for (Lezione l : ll) {
////			System.out.println(l.getIdLezione());
////			System.out.println(l.getNumeroLezione());
////			System.out.println(l.getArgomenti());
////			System.out.println(l.getAssenti());
////			System.out.println(l.getDurata());
////			System.out.println(l.getAula());
////			System.out.println(l.getPercentAssenti());
////			System.out.println(l.getOraInizio());
////			System.out.println(l.getNumAssenti());
////			System.out.println(l.getNumeroLezione());
////			System.out.println(l.getCorso().toString());
////			System.out.println(l.getData());
////		}
////	}
//	
//	@Test 
//	public void getIscrizioniPerCorso() {
//		Corso c = new Corso();
//		c.setIdCorso(1);
//		Lister gc = new Lister();
//		List<Iscrizione> ll = gc.getIscrizioniperCorso(c);
//		for (Iscrizione l : ll) {
//			System.out.println(l.getStudenteIscritto());
//		}
//	}
//	
//	
//	
//}
