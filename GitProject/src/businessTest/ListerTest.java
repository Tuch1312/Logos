package businessTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import business.Lister;
import entity.Corso;
import entity.Docente;
import entity.Lezione;
import entity.Studente;
import javafx.css.Style;

class ListerTest {

//	@Test
//	public void  testGetCorsiPerDocente() {
//		Docente d = new Docente();
//		d.setMail("docente@mail");
//		Lister gc = new Lister();
//		List<Corso> lc = gc.getCorsiPerDocente(d);
//		for (Corso c : lc) {
//			System.out.println(c.getIdCorso());
//		}
//	}
//	
//	@Test
//	public void  testGetCorsiPerStudente() {
//		Studente d = new Studente();
//		d.setMail("studente@mail");
//		Lister gc = new Lister();
//		List<Corso> lc = gc.getCorsiPerStudente(d);
//		for (Corso c : lc) {
//			System.out.println(c.getIdCorso());
//		}
//	}
//		
//		@Test 
//		public void getLeziozniPerCorso() {
//			Corso c = new Corso();
//			c.setIdCorso(1);
//			Lister gc = new Lister();
//			List<Lezione> ll = gc.getLezioniPerCorso(c);
//			for (Lezione l : ll) {
//				System.out.println(l.getIdLezione());
//			}
//		}
//	
	@Test 
	public void getLeziozniDiOggi() {
		Studente d = new Studente();
		d.setMail("studente@mail");
		Lister gc = new Lister();
		List<Lezione> ll = gc.getLezioniDiOggi(d);
		for (Lezione l : ll) {
			System.out.println(l.getIdLezione());
		}
	}
//	
//	@Test 
//	public void getLeziozniDiDomani() {
//		Lister gc = new Lister();
//		Docente d = new Docente();
//		d.setMail("docente@mail");
//		List<Lezione> ll = gc.getLezioniDiDomani(d);
//		for (Lezione l : ll) {
//			System.out.println(l.getIdLezione());
//		}
//	}
	
	
	
}
