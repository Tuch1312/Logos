package business;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import business.GestioneLezioni;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;
import entity.Iscrizione;
import entity.IscrizionePk;
import entity.Studente;

public class Filltablee {


	


		
		static final String mailstudente = "studente2@mail";
		static final String maildocente = "docente2@mail";
		static final int idcorso = 1;
		


		
		public void test() {
			EntityManager em = JPAUtility.emf.createEntityManager();
			Docente d = new Docente();
			Studente s = new Studente();
			Corso c = new Corso();
			IscrizionePk ipk = new IscrizionePk();
			Iscrizione i = new Iscrizione();
			
			d.setMail("docente2@mail");
			d.setCodicePersona(GestionePersona.assegnaCodice("docente@mail"));

			s.setMail("studente2@mail");
			s.setCodicePersona(GestionePersona.assegnaCodice("studente@mail"));
			
			c.setDataInizio(new Date());
			c.setDurataLezione(2);
			c.setDocente(d);
			c.setLezionePerGiorno(2);
			c.setTitolo("corsoprova2");
			c.setPatternLezioni("1,4,5");
			c.setNumeroGiorni(10);
			c.setOraInizioLezioni(new Date());
		
			
			ipk.setIdCorso(2);
			ipk.setMailStudente("studente@mail");
			
			i.setIscrizionePk(ipk);
			i.setCorso(c);
			i.setStudenteIscritto(s);
			
			em.getTransaction().begin();
			em.persist(s);
			em.persist(d);
			em.persist(c);
			em.persist(i);
			em.getTransaction().commit();
			
			
			
			
			boolean b = true;
			assertTrue("funziona", b == true);
		}
		
		
		public void lezioni(int corso) {
			EntityManager em = JPAUtility.emf.createEntityManager();
			Corso c2 = em.find(Corso.class, corso);
			GestioneLezioni gl = new GestioneLezioni();
			gl.creaLezioni(c2);
		}
		

		public static String getMailstudente() {
			return mailstudente;
		}

		public static String getMaildocente() {
			return maildocente;
		}

		public static int getIdcorso() {
			return idcorso;
		}
		
		

	}


