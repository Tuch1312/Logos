package business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import entity.*;

public class GestioneLezioni {
	
	public boolean creaLezioni(Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		for(int i = 0;i<calcNumLezioni(c);i++) {
			Lezione lez = new Lezione();
			lez.setCorso(c);
			lez.setNumeroLezione(i);
			c.addLezione(lez);
		}
		em.getTransaction().begin();
		em.persist(dataLezioni(c));
		em.getTransaction().commit();
		Corso check = em.find(Corso.class, c.getIdCorso());
		if (check.getLeziones().size() == calcNumLezioni(c)) {
			return true;
		} else return false;
		
		
	}
	
	public int calcOrePerGiorno(Corso c) {
		return c.getDurataLezione() * c.getLezionePerGiorno();
	}
	
	public int calcOreTotali(Corso c) {
		return c.getNumeroLezioni() * c.getDurataLezione();
	}
	
	public int calcNumLezioni(Corso c) {
		return c.getNumeroGiorni() * c.getLezionePerGiorno();
	}
	
	public Corso dataLezioni(Corso c) {
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

	
	public static Date addGiorno(Date d, Corso c) {
		
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

}
