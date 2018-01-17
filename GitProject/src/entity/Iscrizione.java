package entity;

import javax.persistence.*;

@Entity
public class Iscrizione {
	@EmbeddedId
	private IscrizionePk iscrizionePk;
	
	@ManyToOne
	@JoinColumn(name="corso_id")
	private Corso corso;
	
	@ManyToOne
	@JoinColumn(name="studente_mail")
	private Studente studenteIscritto;
}
