package business;

import java.util.Date;

import javax.persistence.EntityManager;

import entity.*;

public class GestioneCorso {
	
	//Valore utilizzato per ottenere la chiave del corso partendo dal suo id 
	static final int key = 3728439;
	
	/*
	 * Creazione nuovo corso con settaggio degli attributi necessari
	 * Restituisce true, se la creazione è andata a buon fine
	 * Restituisce false, se la creazione è fallita
	 * 
	 * Docente d : Il docente che crea il corso
	 * String titolo : Titolo del corso
	 * String Descrizione : Descrizione del corso
	 * int : Numero giorni di corso totali (Tutti i giorni in cui ce almeno una lezione)
	 * Date dataInizio : Primo giorno di corso (Il primo giorno in cui ce almeno una lezione)
	 * int durataLezione : Durata di una singola lezione espressa in ore
	 * int numLezioniXgiorno : Numero di lezioni che si svolgono in una singola giornata
	 * int numMaxStudenti : Numero massimo di studenti che un corso puo accogliere
	 * String sede: Sede di svolgimento del corso (Puo essere un indirizzo)
	 * String immagine: URL dell'immagine associata al corso e salvata (!DA DECIDERE! sul cloud server o su un object storage)
	 * Date oraInzioLezioni : Ora di inizio delle lezioni (la prima lezione del giorno, le altre (del giorno) 
	 * 						 verngono accodate a partire da quest'ora)
	 * String patternLezioni : Stringa che indica in quali giorni della settimana si svolge il corso  
	 * 						  nel formato (1,2,3,4,5,6,7) dove (1 = lunedi e 7 = domenica)
	 */
	public boolean nuovoCorso(Docente d, String titolo, String descrizione
			, int numeroGiorni, Date dataInizio,int durataLezione, int numLezioniXgiorno
			, int numMaxStudenti, String sede, String immagine, Date oraInizioLezioni, 
			String patternLezioni) {
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

	/*
	 * Eliminazione sicura di un corso
	 * Restituisce true, se l'eliminazione è andata a buon fine
	 * Restituisce true, se l'eliminazione è fallita
	 * 
	 * Corso c : Il corso da eliminare
	 * Docente d : Il doecente che chiama ìl metodo, che deve essere il creatore del corso
	 */
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
	
	/*
	 * Modica sicura un corso
	 * Il corso che viene passato come argomento deve già esistere sul databse e deve già essere stato modificato
	 * è compito del motodo che chiama ottenere una copia fresca del corso, modificarla e passarla a questo motodo per salvare le modifche 
	 * 
	 * Corso c : Corso gia modficato da salvare
	 * Docente d : Docente che vuole modificare il corso, deve essere il docente che ha creato il corso
	 */
	public boolean modificaCorso(Corso c, Docente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		try {
		docente = em.find(Docente.class, d.getMail());
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (docente!=null) {
			if (docente.getMail().equals((em.find(Corso.class, c.getIdCorso()).getDocente().getMail()))) {
				em.getTransaction().begin();
				em.merge(c);
				em.getTransaction().commit();
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Iscrive uno studente ad un corso (Lato docente)
	 * Serve ad un docente che vuole forzatamente iscivere uno studente ad un corso 
	 * Il docente deve conoscere la mail dello studnete da iscrivere
	 * 
	 * Docente d : Docente che vuole iscrivere lo studente, deve essere il docente che ha creato il corso
	 * Corso c : Corso a cui iscrivere lo studente
	 * String mailStudente : Mail dello studnete da iscrivere al corso
	 */
	public boolean iscriviStudente(Docente d, Corso c, String mailStudente) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		Studente studente = null;
		Corso corso = null;
		try {
		docente = em.find(Docente.class, d.getMail());
		studente = em.find(Studente.class, mailStudente);
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
	
	/*
	 * Calcola il codice univoco di riecrca ad un corso a partire da un Corso
	 * Il codice di riecrca è ottenuto moltiplicando una costante Key (3728439) per l'id del corso 
	 * e poi trasformato in base esadecimale per aggiungere le lettere al codice (solo questione di forma)
	 * 
	 * Corso c : Corso da cui calcolare il codice di ricerca
	 */
	public String calcolaCodice(Corso c) {
		int k = key * c.getIdCorso();
		String code = Integer.toHexString(k);
		return code;
	}

	/*
	 * Calcola il codice univoco di riecrca ad un corso a partire da un Id (Piu lento! Contiene qery!)
	 * Il codice di riecrca è ottenuto moltiplicando una costante Key (3728439) per l'id del corso 
	 * e poi trasformato in base esadecimale per aggiungere le lettere al codice (solo questione di forma)
	 * 
	 * int id : Id di un corso da cui calcolare il codice
	 */
	public String calcolaCodice(int id) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Corso c = em.find(Corso.class, id);
		int k = key * c.getIdCorso();
		String code = Integer.toHexString(k);
		return code;
	}
}
