package business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import entity.Corso;
import entity.Docente;
import entity.Lezione;
import entity.Studente;

public class Lister {

	public Lister() {
	}

	// Tested
	/*
	 * Ritorna tutte le lezioni di un corso
	 */
	public List<Lezione> getLezioniPerCorso(Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Lezione> lezioni = em.createQuery("select l from Lezione l where l.corso = :corso", Lezione.class)
				.setParameter("corso", c)
				.getResultList();
		return lezioni;
	}

	// Tested
	/*
	 * Ritorna tutti i corsi inseganti da un detreminato docente, passato come
	 * argomento
	 */
	public List<Corso> getCorsiPerDocente(Docente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Corso> corsi = em.createQuery("select c from Corso c where c.docente = :docente", Corso.class)
				.setParameter("docente", d)
				.getResultList();
		return corsi;

	}

	// Tested
	// TODO query da trasformare in jpql da sql
	/*
	 * Ritorna tutti i corsi a cui uno studente è isccritto
	 */
	public List<Corso> getCorsiPerStudente(Studente s) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Corso> corsi = em.createQuery(
				"select c from Iscrizione i join i.corso c where i.studenteIscritto = :studente",
				Corso.class).setParameter("studente", s)
			.getResultList();
		return corsi;

	}

	// Tested
	/*
	 * Ritorna tutti gli studenti iscritti ad un detrminato corso
	 */
	public List<Studente> getStudentiPerCorso(Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Studente> studenti = em.createQuery(
				"select s from Iscrizione i join i.studenteIscritto s where i.corso = :corso",
				Studente.class).setParameter("corso", c)
				.getResultList();
		return studenti;

	}

	// Tested
	/*
	 * Ritorna tutte le lezioni di oggi per un determinato docente
	 */

	public List<Lezione> getLezioniDiOggi(Docente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Lezione> lezioni = em.createQuery("select l from Lezione l where l.data = :data and l.corso = (select c from Corso c where c.docente = :docente)" , Lezione.class)
				.setParameter("data", new Date())
				.setParameter("docente", d)
				.getResultList();
		return lezioni;
	}
	
	
	// Tested
		/*
		 * Ritorna tutte le lezioni di domani per un determinato docente
		 */
	public List<Lezione> getLezioniDiDomani(Docente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		List<Lezione> lezioni = em.createQuery("select l from Lezione l where l.data = :data and l.corso = (select c from Corso c where c.docente = :docente)", Lezione.class)
				.setParameter("data", cal.getTime())
				.setParameter("docente", d)
				.getResultList();
		return lezioni;
	}
	
	//TODO non funziona
	// Not Tested
	/*
	 * Ritorna tutte le lezioni di oggi per un determinato docente
	 */

	public List<Lezione> getLezioniDiOggi(Studente s) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Lezione> lezioni = em.createQuery("select l from Lezione l where l.data = :data and l.corso = (select c from Iscrizione i join i.corso c where i.studenteIscritto = :studente)" , Lezione.class)
				.setParameter("data", new Date())
				.setParameter("studente", s)
				.getResultList();
		return lezioni;
	}
	
	//TODO non funzoina
	//Not  Tested
		/*
		 * Ritorna tutte le lezioni di domani per un determinato docente
		 */
	public List<Lezione> getLezioniDiDomani(Studente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		List<Lezione> lezioni = em.createQuery("select l from Lezione l where l.data = :data and l.corso = (select c from Corso c where c.docente = :docente)", Lezione.class)
				.setParameter("data", cal.getTime())
				.setParameter("docente", d)
				.getResultList();
		return lezioni;
	}

}
