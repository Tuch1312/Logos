package business;

import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.*;

public class GestionePresenze {
	
	public boolean setOraIngresso(Docente d, Studente s, Corso c) {
		Presenza p = new Presenza();
		EntityManager em = JPAUtility.emf.createEntityManager();
		String sq = "SELECT a.id_lezione FROM PRESENZA a WHERE a.id_lezione = " + c.getLeziones().get(c.getLezioneCorrente()).getIdLezione() + " and a.mail = '" + s.getMail() + "'";
		Query q = em.createNativeQuery(sq);
		Docente docente = null;
		try {
			docente = em.find(Docente.class, d.getMail());
		} catch(Exception e) {
				e.printStackTrace();
		}
		if (docente!=null) {
				p.setOraArrivo(new Date().getTime());
				p.setStudente(s);
				p.setLezione(c.getLeziones().get(c.getLezioneCorrente()));
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
				//s.setPresenzaOggi(((Presenza)q.getSingleResult()).getId());
				Object o = q.getSingleResult(); 
				System.out.print(o.toString());
				
				//provare il sistem out
				return true;
		}
				
		else return false;
	}
	
	public boolean setOraUscita(Docente d, Studente s, Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Presenza p = em.find(Presenza.class, s.getPresenzaOggi());
		Docente docente = null;
		try {
			docente = em.find(Docente.class, d.getMail());
		} catch(Exception e) {
				e.printStackTrace();
		}
		if (docente!=null) {
				p.setOraUscita(new Date().getTime());
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
				return true;
			} 
		else return false;
	}
	
	//Controlla se lo studente è presente o assente per la data di oggi
	public boolean isPresente(Studente s, Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Presenza p = null;
		try {
		p = em.find(Presenza.class, s.getPresenzaOggi());
		} catch(Exception e) {
			e.printStackTrace();
	}
		if (p!=null) {
			//if (new Date(p.getOraArrivo()).getDate())
				//se il giorno riportato dalla data della presenza equivale ad oggi allora è presente
		} //else
		return false;
		
	}

}
