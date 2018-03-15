package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import entity.*;

public class GestioneCorso {

	// Valore utilizzato per ottenere la chiave del corso partendo dal suo id
	static final int key = 11121;

	//Tested
	/*
	 * Creazione nuovo corso con settaggio degli attributi necessari Restituisce
	 * true, se la creazione è andata a buon fine Restituisce false, se la creazione
	 * è fallita
	 * 
	 * Docente d : Il docente che crea il corso String titolo : Titolo del corso
	 * String Descrizione : Descrizione del corso int : Numero giorni di corso
	 * totali (Tutti i giorni in cui ce almeno una lezione) Date dataInizio : Primo
	 * giorno di corso (Il primo giorno in cui ce almeno una lezione) int
	 * durataLezione : Durata di una singola lezione espressa in ore int
	 * numLezioniXgiorno : Numero di lezioni che si svolgono in una singola giornata
	 * int numMaxStudenti : Numero massimo di studenti che un corso puo accogliere
	 * String sede: Sede di svolgimento del corso (Puo essere un indirizzo) String
	 * immagine: URL dell'immagine associata al corso e salvata (!DA DECIDERE! sul
	 * cloud server o su un object storage) Date oraInzioLezioni : Ora di inizio
	 * delle lezioni (la prima lezione del giorno, le altre (del giorno) verngono
	 * accodate a partire da quest'ora) String patternLezioni : Stringa che indica
	 * in quali giorni della settimana si svolge il corso nel formato
	 * (1,2,3,4,5,6,7) dove (1 = lunedi e 7 = domenica)
	 */
	public boolean nuovoCorso(Docente d, String titolo, String descrizione, int numeroGiorni, Date dataInizio,
			int durataLezione, int numLezioniXgiorno, int numMaxStudenti, String sede, String immagine,
			Date oraInizioLezioni, String patternLezioni, boolean automaticFill) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		try {
			docente = em.find(Docente.class, d.getCodicePersona());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (docente != null && automaticFill == true) {
			Corso corso = new Corso();
			corso.setTitolo(titolo);
			corso.setDescrizione(descrizione);
			corso.setNumeroGiorni(numeroGiorni);
			corso.setDataInizio(dataInizio);
			corso.setNumMaxStudenti(numMaxStudenti);
			corso.setSede(sede);
			corso.setImmagine(immagine);
			corso.setDocente(d);
			corso.setLezionePerGiorno(numLezioniXgiorno);
			corso.setOraInizioLezioni(oraInizioLezioni);
			corso.setPatternLezioni(patternLezioni);
			corso.setDurataLezione(durataLezione);
			em.getTransaction().begin();
			em.persist(corso);
			em.getTransaction().commit();
			corso = em.createQuery("select c from Corso c where c.descrizione like ?1 and c.dataInizio = ?2 and c.immagine like ?3 and c.docente = ?4 "
					+ "and c.oraInizioLezioni = ?5 and c.idCorso = (select max(y.idCorso) from Corso y where y.docente = ?6 )", Corso.class)
			.setParameter(1, descrizione)
			.setParameter(2, dataInizio)
			.setParameter(3, immagine)
			.setParameter(4, d)
			.setParameter(5, oraInizioLezioni)
			.setParameter(6, d)
			.getSingleResult();
			GestioneLezioni gl = new GestioneLezioni();
			gl.creaLezioni(corso);
			return true;
			

		}	
		return false;
	}
	
	public boolean nuovoCorso(Docente d, String titolo, String descrizione,int numMaxStudenti, String sede, String immagine,
			boolean automaticFill) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		try {
			docente = em.find(Docente.class, d.getMail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (docente != null && automaticFill == false) {
			Corso corso = new Corso();
			corso.setTitolo(titolo);
			corso.setDescrizione(descrizione);
			corso.setNumeroGiorni(0);
			corso.setDataInizio(null);
			corso.setNumMaxStudenti(numMaxStudenti);
			corso.setSede(sede);
			corso.setImmagine(immagine);
			corso.setDocente(d);
			corso.setLezionePerGiorno(0);
			corso.setOraInizioLezioni(null);
			corso.setPatternLezioni(null);
			corso.setDurataLezione(0);
			em.getTransaction().begin();
			em.persist(corso);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
		


	//Tested
	/*
	 * Eliminazione sicura di un corso Restituisce true, se l'eliminazione è andata
	 * a buon fine Restituisce true, se l'eliminazione è fallita
	 * 
	 * Corso c : Il corso da eliminare Docente d : Il doecente che chiama ìl metodo,
	 * che deve essere il creatore del corso
	 */
	public boolean eliminaCorso(Docente d, Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		try {
			docente = em.find(Docente.class, d.getMail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (docente != null) {
			if (docente.getMail().equals((em.find(Corso.class, c.getIdCorso()).getDocente().getMail()))) {
				Corso corso = em.find(Corso.class, c.getIdCorso());
				Lister li = new Lister();
				List<Iscrizione> iscrizioniList = li.getIscrizioniperCorso(corso);
				em.getTransaction().begin();
				for (Iscrizione i : iscrizioniList) {
					Iscrizione isc = em.find(Iscrizione.class, i.getIscrizionePk());
					em.remove(isc);
				}
				em.remove(corso);
				em.getTransaction().commit();
				return true;
			}

		}

		return false;
	}

	//Tested
	/*
	 * Modica sicura un corso Il corso che viene passato come argomento deve già
	 * esistere sul databse e deve già essere stato modificato è compito del motodo
	 * che chiama ottenere una copia fresca del corso, modificarla e passarla a
	 * questo motodo per salvare le modifche
	 * 
	 * Corso c : Corso gia modficato da salvare Docente d : Docente che vuole
	 * modificare il corso, deve essere il docente che ha creato il corso
	 */
	public boolean modificaCorso(Corso c, Docente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		try {
			docente = em.find(Docente.class, d.getCodicePersona());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (docente != null) {
			if (docente.getCodicePersona().equals((em.find(Corso.class, c.getIdCorso()).getDocente().getCodicePersona()))) {
				c.setDocente(docente);
				em.getTransaction().begin();
				em.merge(c);
				em.getTransaction().commit();
				return true;
			}
		}
		return false;
	}

	//Tested
	/*
	 * Iscrive uno studente ad un corso (Lato docente) 
	 * Serve ad un docente che vuole
	 * forzatamente iscivere uno studente ad un corso Il docente deve conoscere la
	 * mail dello studnete da iscrivere
	 * 
	 * Docente d : Docente che vuole iscrivere lo studente, deve essere il docente
	 * che ha creato il corso Corso c : Corso a cui iscrivere lo studente String
	 * mailStudente : Mail dello studnete da iscrivere al corso
	 */
	public boolean iscriviStudente(Docente d, Corso c, String mailStudente) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		Studente studente = null;
		Corso corso = null;
		try {
			docente = em.find(Docente.class, d.getCodicePersona());
			studente = em.find(Studente.class, getCodiceDaMail(mailStudente));
			corso = em.find(Corso.class, c.getIdCorso());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (docente != null && studente != null && corso != null) {
			IscrizionePk ipk = new IscrizionePk();
			ipk.setIdCorso(corso.getIdCorso());
			ipk.setMailStudente(studente.getMail());
			Iscrizione iscrizione = new Iscrizione();
			iscrizione.setCorso(corso);
			iscrizione.setStudenteIscritto(studente);
			iscrizione.setIscrizionePk(ipk);
			em.getTransaction().begin();
			em.persist(iscrizione);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public String getCodiceDaMail(String mail) {
		  EntityManager em = JPAUtility.emf.createEntityManager();
	        String codice = em
	                .createQuery("select p.codicePersona from Persona p where p.mail like :mail",
	                        String.class)
	                .setParameter("mail", mail).getSingleResult();
		
		return codice;
		
	}

	//Tested
	/*
	 * Cancella uno studente da un corso (Lato docente) Serve ad un docente che vuole
	 * forzatamente eliminare uno studente da un corso 
	 * 
	 * Docente d : Docente che vuole iscrivere lo studente, deve essere il docente
	 * che ha creato il corso Corso c : Corso a cui iscrivere lo studente String
	 * Studente : Studnete da elimanre dal corso
	 */
	public boolean cancellaStudente(Docente d, Corso c, Studente s) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente docente = null;
		Studente studente = null;
		Corso corso = null;
		try {
			docente = em.find(Docente.class, d.getMail());
			studente = em.find(Studente.class, s.getMail());
			corso = em.find(Corso.class, c.getIdCorso());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (docente != null && studente != null && corso != null) {
			IscrizionePk iscrizionePk = new IscrizionePk();
			iscrizionePk.setIdCorso(corso.getIdCorso());
			iscrizionePk.setMailStudente(studente.getMail());
			Iscrizione iscrizione = em.find(Iscrizione.class, iscrizionePk);
			em.getTransaction().begin();
			em.remove(iscrizione);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	//Tested
	/*
	 * Permette ad uno studente di iscriversi autonumamente ad un corso avendo
	 * il codice identificativo del corso che puo chiedere al suo inseggannte 
	 * 
	 * Studente s : Lo studente che si vuole iscrivere al corso
	 * String codiceCorso : Il codice identificativo del corso al quale lo studente si vuole iscrivere
	 */
	public boolean iscriviti(Studente s, String codiceCorso) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		StringBuilder sb = new StringBuilder(codiceCorso);
		sb.deleteCharAt(0);
		sb.deleteCharAt(0);
		String code = sb.toString();
		int id_generato = Integer.parseInt(code, 16)/11121;
		Corso c = em.find(Corso.class, id_generato);
		if (c == null) return false;
		IscrizionePk ipk = new IscrizionePk();
		ipk.setIdCorso(c.getIdCorso());
		ipk.setMailStudente(s.getMail());
		try {
			Iscrizione iProva = em.find(Iscrizione.class, ipk);
		} catch (Exception e) {
			System.out.println("dentro al cath");
			return false;	
		}
		System.out.println("ho passoto il cath, quindi tapposto");
		Iscrizione iscrizione = new Iscrizione();
		iscrizione.setCorso(c);
		iscrizione.setStudenteIscritto(s);
		iscrizione.setIscrizionePk(ipk);
		em.getTransaction().begin();
		em.persist(iscrizione);
		em.getTransaction().commit();
	
		return true;
	}

	// !!ATTENZIONE!! questo codice identificativo permette di generare solo 193101 corsi prima di andare in eccezzioe
	/*
	 * Calcola il codice univoco di riecrca ad un corso a partire da un Corso Il
	 * codice di riecrca è ottenuto moltiplicando una costante Key (3728439) per
	 * l'id del corso e poi trasformato in base esadecimale per aggiungere le
	 * lettere al codice (solo questione di forma)
	 * 
	 * Corso c : Corso da cui calcolare il codice di ricerca
	 */
	public String calcolaCodice(Corso c) {
		int k = key * c.getIdCorso();
		String code = "Cn" + Integer.toHexString(k);
		return code;
	}
	
	
	// !!ATTENZIONE!! questo codice identificativo permette di generare solo 193101 corsi prima di andare in eccezzioe
	/*
	 * Calcola il codice univoco di riecrca ad un corso a partire da un Id (Piu
	 * lento! Contiene qery!) Il codice di riecrca è ottenuto moltiplicando una
	 * costante Key (3728439) per l'id del corso e poi trasformato in base
	 * esadecimale per aggiungere le lettere al codice (solo questione di forma)
	 * 
	 * int id : Id di un corso da cui calcolare il codice
	 */
	public static String calcolaCodice(int id) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Corso c = em.find(Corso.class, id);
		if (c!=null) {
		int k = key * c.getIdCorso();
		String code = "Cn" + Integer.toHexString(k);
		return code;
		} 
		else return "Corso inesistente";
	}
	
	
	}
