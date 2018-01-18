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
	
	
	public IscrizionePk getIscrizionePk() {
		return iscrizionePk;
	}

	public void setIscrizionePk(IscrizionePk iscrizionePk) {
		this.iscrizionePk = iscrizionePk;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Studente getStudenteIscritto() {
		return studenteIscritto;
	}

	public void setStudenteIscritto(Studente studenteIscritto) {
		this.studenteIscritto = studenteIscritto;
	}

	
}
