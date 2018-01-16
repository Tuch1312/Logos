package business;

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
	
	public int calcGiorniDiCorso(Corso c) {
		return c.getNumeroLezioni() * c.getLezionePerGiorno();
	}
	
	public List<Lezione> dataLezioni(Corso c, List<Lezione> listaLezione) {
		
		return listaLezione;
	}

}
