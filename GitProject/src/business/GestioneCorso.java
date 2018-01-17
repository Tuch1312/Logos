package business;

import java.util.Date;

import javax.persistence.EntityManager;

import entity.*;

public class GestioneCorso {
	
	public boolean nuovoCorso(Docente d, String titolo, String descrizione
			, int numeroGiorni, Date dataInizio,int durataLezione, int numLezioniXgiorno
			, int numMaxStudenti, String requistiMinimi, String sede
			, String immagine, Date oraInizioLezioni, String patternLezioni) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		try {
		docente = em.find(Docente.class, d.getMail());
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (docente!=null) {
			Corso corso = new Corso();
			corso.setTitolo(titolo);
			corso.setDescrizione(descrizione);
			corso.setNumeroGiorni(numeroGiorni);
			corso.setDataInizio(dataInizio);
			corso.setLezionePerGiorno(numLezioniXgiorno);
			corso.setNumMaxStudenti(numMaxStudenti);
			corso.setRequisitiMin(requistiMinimi);
			corso.setSede(sede);
			corso.setImmagine(immagine);
			corso.setDocente(d);
			corso.setOraInizioLezioni(oraInizioLezioni);
			corso.setPatternLezioni(patternLezioni);
			corso.setDurataLezione(durataLezione);
			
			
			em.getTransaction().begin();
			em.persist(corso);
			em.getTransaction().commit();
			return true;
			
		}
		return false;
	}
	
	public boolean eliminaCorso(Docente d, Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		try {
		docente = em.find(Docente.class, d.getMail());
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(docente!=null) {
			if (docente.getMail().equals((em.find(Corso.class, c.getIdCorso()).getDocente().getMail()))) {
			Corso corso = em.find(Corso.class, c.getIdCorso());
			em.getTransaction().begin();
			em.remove(corso);
			em.getTransaction().commit();
			return true;
			}
		
		}
		
		return false;
	}
//	
//	public boolean modificaCorso(Docente d, Corso c, Corso nc) {
//		Corso nuovoCorso = nc;
//		EntityManager em = JPAUtility.emf.createEntityManager();
//		Docente docente = null;
//		try {
//		docente = em.find(Docente.class, d.getMail());
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		if (docente!=null) {
//			if (docente.getMail().equals((em.find(Corso.class, c.getIdCorso()).getDocente().getMail()))) {
//				Corso corso = em.find(Corso.class, c.getIdCorso());
//				nuovoCorso.setIdCorso(corso.getIdCorso());
//				em.getTransaction().begin();
//				corso = nuovoCorso;
//				em.getTransaction().commit();
//				return true;
//				
//			}
//		
//		}
//		return false;
//	}
	
	public boolean iscriviStudente(Docente d, Studente s, Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		Studente studente = null;
		Corso corso = null;
		try {
		docente = em.find(Docente.class, d.getMail());
		studente = em.find(Studente.class, s.getMail());
		corso = em.find(Corso.class, c.getIdCorso());
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(docente!=null && studente!=null && corso!=null) {
			IscrizionePk iscrizione = new IscrizionePk();
			iscrizione.setIdCorso(corso.getIdCorso());
			iscrizione.setMailStudente(studente.getMail());
			em.getTransaction().begin();
			em.persist(iscrizione);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean cancellaStudente(Docente d, Studente s, Corso c) {
		//TODO
		return true;
	}
	
	public boolean iscriviti(Studente s, String idcorso) {
		//TODO
		return true;
	}
	
	public String assegnaCodice(Corso c) {
		int k = 3728439 * c.getIdCorso();
		String code = Integer.toHexString(k);
		return code;
	}
	
}
