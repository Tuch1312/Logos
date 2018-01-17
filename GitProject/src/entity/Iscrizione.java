package entity;

import javax.persistence.*;

@Entity
public class Iscrizione {
	@EmbeddedId
	private IscrizionePk iscrizionePk;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="corso_id")
	private Corso corso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="studente_mail")
	private Studente studenteIscritto;
}
