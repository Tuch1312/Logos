package business;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.*;

public class GestionePresenze {
	
	public boolean setOraIngresso(Docente d, Studente s, Corso co) {
		Presenza p = new Presenza();
		EntityManager em = JPAUtility.emf.createEntityManager();
		Corso prova = null;
		Corso c = em.find(Corso.class, co.getIdCorso());
		// !NON SI SA A COSA SERVA QUESTA QUERY! 
		//String sq = "SELECT a.id_lezione FROM PRESENZA a WHERE a.id_lezione = " + c.getLeziones().get(c.getLezioneCorrente()).getIdLezione() + " and a.mail = '" + s.getMail() + "'";
		//Query q = em.createNativeQuery(sq);
		Docente docente = null;
		try {
			docente = em.find(Docente.class, JPAUtility.cod(d.getMail()));
		} catch(Exception e) {
				e.printStackTrace();
		}
		if (docente!=null) {
				p.setOraArrivo(new Date().getTime());
				p.setStudente(s);
				p.setLezione(c.getLeziones().get(c.getLezioneCorrente()));
				s.setPresenzaOggi(p);
				em.getTransaction().begin();
				em.persist(p);
				em.merge(p);
				em.getTransaction().commit();
				//s.setPresenzaOggi(((Presenza)q.getSingleResult()).getId());
				//Object o = q.getSingleResult(); 
				
				
				//provare il sistem out
				return true;
		}
				
		else return false;
	}
	
	public boolean setOraUscita(Docente d, Studente s, Corso cor) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Presenza p = em.find(Presenza.class, s.getPresenzaOggi());
		Docente docente = null;
		Corso c = em.find(Corso.class, cor.getIdCorso());
		try {
			docente = em.find(Docente.class, JPAUtility.cod(d.getMail()));
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
	
	public List<Integer> getAssenze(Studente s, Corso c) {
		int oreAssenza = 0;
		int percentAssenza = 0;
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Presenza> presenze = em.createQuery("select p from Presenza p where p.studente = ?1 and p.lezioneId <= ?2", Presenza.class)
				.setParameter(1, s)
				.setParameter(2, c.getLezioneCorrente())
				.getResultList();
		int diff = c.getLezioneCorrente() - presenze.size();
		if (diff != 0) {
			oreAssenza = diff*c.getDurataLezione();
		}
		for (Presenza p : presenze) {
			Lezione l = em.find(Lezione.class, p.getLezione().getIdLezione());
			if (p.getOraUscita() < (l.getOraInizio().getTime() + (((c.getDurataLezione() * 60) * 60 )* 1000))) {
				long ass = p.getOraUscita() - (l.getOraInizio().getTime() + (((c.getDurataLezione() * 60) * 60 )* 1000));
				int assInt = (int) (ass / 3600000);
				oreAssenza += assInt;
			}		
		}
		percentAssenza = (oreAssenza * (c.getNumeroLezioni() * c.getDurataLezione())) / 100;
		List<Integer> result = new ArrayList<Integer>();
		result.add(oreAssenza);
		result.add(percentAssenza);
		return result;
	}

}
