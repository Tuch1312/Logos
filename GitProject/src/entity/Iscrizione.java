package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
@Entity 
@IdClass(IscrizioneId.class)
public class Iscrizione {
	
	@Id private Corso corso;
	
	@Id private Studente studente;

}
