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
		
		if (d!=null&&s!=null&&c!=null) {
				p.setOraArrivo(new Date().getTime());
				p.setStudente(s);
				p.setLezione(c.getLeziones().get(c.getLezioneCorrente()));
				p.setLezioneId(c.getLeziones().get(c.getLezioneCorrente()).getIdLezione());
				p.setCodiceStudente(s.getCodicePersona());
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
				if (s.getPresenze() == null) s.initPresenze();
				s.addPresenzaOggi(p,c);
				em.getTransaction().begin();
				em.merge(s);
				em.getTransaction().commit();
				
				return true;
		}
				
		else return false;
	}
	
	public boolean setOraUscita(Docente d, Studente s, Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Presenza p = em.find(Presenza.class, s.getPresenzaOggi(c));
		if (d!=null&&c!=null&&s!=null) {
	
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
		p = em.find(Presenza.class, s.getPresenzaOggi(c));
		} catch(Exception e) {
			e.printStackTrace();
	}
		if (p!=null) {
	
			if (p.getOraUscita() == null || p.getOraUscita() == 0) {
				return true;
			}
		} 
		return false;
		
	}

}
