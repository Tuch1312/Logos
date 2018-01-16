package business;

import java.util.Date;

import entity.*;

public class GestioneCorso {
	
	public boolean nuovoCorso(Docente d, String titolo, String descrizione, int numLezioni, Date dataInizio, int numLezioniXgiorno, int numMaxStudneti, String requistiMinimi, String sede, String immagine) {
		//TODO
		return true;
	}
	
	public boolean eliminaCorso(Docente d, Corso c) {
		//TODO
		return true;
	}
	
	public boolean modificaCorso(Docente d, Corso c, Corso nc) {
		//TODO
		return true;
	}
	
	public boolean iscriviStudente(Docente d, Studente s, Corso c) {
		//TODO
		return true;
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
		int k = 32439 * c.getIdCorso();
		String code = Integer.toHexString(k);
		return code;
	}

}
