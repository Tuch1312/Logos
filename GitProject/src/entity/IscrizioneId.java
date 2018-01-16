package entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.OneToMany;

public class IscrizioneId implements Serializable {


	private Corso corso;
	
	
	private Studente studente;
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
