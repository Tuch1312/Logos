package business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entity.*;

public class GestioneLezioni {
	
	public boolean creaLezioni(Corso c) {
		//TODO
		return true;
	}
	
	public int calcOreXLezione(Corso c) {
		return c.getOrePerGiorno() / c.getLezionePerGiorno();
	}
	
	public int calcOreTotali(Corso c) {
		return c.getNumeroLezioni() * calcOreXLezione(c);
	}
	
	public int calcNumLezioni(Corso c) {
		return c.getNumeroGiorni() * c.getLezionePerGiorno();
	}
	
	public List<Lezione> dataLezioni(Corso c, List<Lezione> listaLezione) {
		Calendar cal = Calendar.getInstance();
		Date xOra = c.getOraInizioLezioni();
		Date xData = c.getDataInizio();
		int x = 0;
		for(int i = 0; i < calcNumLezioni(c); i++) {
			for(int y = 0; y < c.getLezionePerGiorno(); y++) {
				Lezione lez = listaLezione.get(x);
				lez.setData(xData);
				lez.setOraInizio(xOra);
				x++;
				cal.setTime(xOra);
				cal.add(Calendar.HOUR_OF_DAY, c.getDurataLezione());
				xOra = cal.getTime();
			}
			addGiornoScolastico(xData);
		}
		return listaLezione;
	}
	
	private Date addGiornoScolastico(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, 1);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			cal.add(Calendar.DATE, 2);
		}
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.add(Calendar.DATE, 1);
		}
		return cal.getTime();
	}
	
	private Date addGiornoSettimanale() {
		return new Date();
	}

}
