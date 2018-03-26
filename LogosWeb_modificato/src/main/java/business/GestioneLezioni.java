package business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import entity.*;

public class GestioneLezioni {
	
	//Tested
	/*
	 * Crea tutte le lezioni necessarie ad un corso
	 * chiama il metodo calcNumLezioni() per sapere quante lezioni creare
	 * chiama il metodo datlezioni() per assegnare una data 
	 */
	public boolean creaLezioni(Corso c) {
		
		EntityManager em = JPAUtility.emf.createEntityManager();
		for(int i = 0;i<calcNumLezioni(c);i++) {
			Lezione lez = new Lezione();
			lez.setCorso(c);
			lez.setNumeroLezione(i + 1);
			c.addLezione(lez);
		}
		em.getTransaction().begin();
		em.merge(dataLezioni(c));
		em.getTransaction().commit();
		Corso check = em.find(Corso.class, c.getIdCorso());
		if (check.getLeziones().size() == calcNumLezioni(c)) {
			return true;
		} else return false;
		
		
	}
	
	/*
	 * Calcola le ore per giorno di un corso 
	 */
	public int calcOrePerGiorno(Corso c) {
		return c.getDurataLezione() * c.getLezionePerGiorno();
	}
	
	/*
	 * Calcola le ore totali di un corso 
	 */
	public int calcOreTotali(Corso c) {
		return c.getNumeroLezioni() * c.getDurataLezione();
	}
	
	/*
	 * Calcola il numero totale di lezioni di un corso 
	 */
	public int calcNumLezioni(Corso c) {
		return c.getNumeroGiorni() * c.getLezionePerGiorno();
	}
	
	/*
	 * Assegna una data ad ogni lezione di un corso
	 * Chiama il metodo addgiorno per stabile quanti giorni 
	 *aggiungere dall'ultima data memorizzata
	 */
	private Corso dataLezioni(Corso c) {
		Calendar cal = Calendar.getInstance();
		Date xOra = c.getOraInizioLezioni();
		Date xData = c.getDataInizio();
		List<Lezione> listaLezione = c.getLeziones();
		int x = 0;
		for(int i = 0; i < calcNumLezioni(c); i++) {
			for(int y = 0; y < c.getLezionePerGiorno(); y++) {
				if(x<calcNumLezioni(c)) {
				Lezione lez = listaLezione.get(x);
				lez.setData(xData);
				lez.setOraInizio(xOra);
				x++;
				cal.setTime(xOra);
				cal.add(Calendar.HOUR_OF_DAY, c.getDurataLezione());
				xOra = cal.getTime();
				}
				
			}
			xData = addGiorno(xData, c);
			xOra = c.getOraInizioLezioni();
		}
		c.setLeziones(listaLezione);
		return c;
	}

	/*
	 * AGgiunge tot giorni alla passata per distribuire le lezioni nella settimana
	 * utilizza il pattern contenuto nell'attributo Corso.patternLezioni
	 */
	private static Date addGiorno(Date d, Corso c) {
		
		String[] giorni = c.getPatternLezioni().split(",");
		if(c.getContatoreGiorniInterno() == giorni.length) {
			c.setContatoreGiorniInterno(0);
		}
		int prossimogiorno = Integer.parseInt(giorni[c.getContatoreGiorniInterno()]);
		c.setContatoreGiorniInterno(c.getContatoreGiorniInterno() +1);;
		switch(prossimogiorno) {
		case 1: prossimogiorno = 2;
			break;
		case 2: prossimogiorno = 3;
			break;
		case 3: prossimogiorno = 4;
			break;
		case 4: prossimogiorno = 5;
			break;
		case 5: prossimogiorno = 6;
			break;
		case 6: prossimogiorno = 7;
			break;
		case 7: prossimogiorno = 1;
			break;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
	while(cal.get(Calendar.DAY_OF_WEEK) != prossimogiorno) {
		cal.add(Calendar.DATE, 1);
	}
	return cal.getTime();

	}
	
	
	public boolean eliminaLezione(Corso c, Lezione l){
		EntityManager em = JPAUtility.emf.createEntityManager();
		Corso corso = null;
		Lezione lezione = null;
		try {
			corso = em.find(Corso.class, c.getIdCorso());
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			lezione = em.find(Lezione.class, l.getIdLezione());
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (corso!=null && lezione!=null) {
			em.getTransaction().begin();
			em.remove(lezione);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean aggiungiLezione(Corso c, Lezione l){
		EntityManager em = JPAUtility.emf.createEntityManager();
		Corso corso = null;
		Lezione lezione = null;
		try {
			corso = em.find(Corso.class, c.getIdCorso());
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			lezione = em.find(Lezione.class, l.getIdLezione());
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (corso!=null && lezione==null) {
			l.setCorso(corso);
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean modificaLezione(Corso c, Lezione l){
		EntityManager em = JPAUtility.emf.createEntityManager();
		Corso corso = null;
		Lezione lezione = null;
		try {
			corso = em.find(Corso.class, c.getIdCorso());
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			lezione = em.find(Lezione.class, l.getIdLezione());
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (corso!=null && lezione!=null) {
			l.setCorso(corso);
			em.getTransaction().begin();
			em.merge(l);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
	

 }
