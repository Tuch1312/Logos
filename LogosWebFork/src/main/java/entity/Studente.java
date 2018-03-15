package entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


@Entity
@DiscriminatorValue("S")
@Table(name="studente")
@NamedQuery(name="Studente.findAll", query="SELECT s FROM Studente s")
public class Studente extends Persona {
	private static final long serialVersionUID = 1L;
	
	
	 @OneToMany(mappedBy="studenteIscritto")
	 private List<Iscrizione> iscrizioni;
	
	
	@OneToMany(mappedBy = "studente")

	private List<Presenza> presenza;
	
	private HashMap<Integer, Integer> presenzaOggi;
	
	//Getter and Setter
	
	public Studente() {
	}
	
	

	public Integer getPresenzaOggi(Corso c) {
		return presenzaOggi.get(c.getIdCorso());
	}



	public void addPresenzaOggi(Presenza presenzaOggi, Corso c) {
		this.presenzaOggi.put(c.getIdCorso(), presenzaOggi.getId());
	}
	
	public void initPresenze() {
		this.presenzaOggi = new HashMap<Integer, Integer>();
	}
	
	public HashMap<Integer, Integer> getPresenze() {
		return this.presenzaOggi;
	}



	public List<Presenza> getPresenza() {
		return this.presenza;
	}


	public void setPresenza(List<Presenza> presenza) {
		this.presenza = presenza;
	}

	public Presenza addPresenza(Presenza presenza) {
		getPresenza().add(presenza);
		presenza.setStudente(this);

		return presenza;
	}

	public Presenza removePresenza(Presenza presenza) {
		getPresenza().remove(presenza);
		presenza.setStudente(null);

		return presenza;
	}

}