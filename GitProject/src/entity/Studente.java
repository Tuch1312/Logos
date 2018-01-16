package entity;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the studente database table.
 * 
 */
@Entity
@DiscriminatorValue("S")
@Table(name="studente")
@NamedQuery(name="Studente.findAll", query="SELECT s FROM Studente s")
public class Studente extends Persona {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="studente")
	private List<Assenza> assenzas;

	public Studente() {
	}

	public List<Assenza> getAssenzas() {
		return this.assenzas;
	}

	public void setAssenzas(List<Assenza> assenzas) {
		this.assenzas = assenzas;
	}

	public Assenza addAssenza(Assenza assenza) {
		getAssenzas().add(assenza);
		assenza.setStudente(this);

		return assenza;
	}

	public Assenza removeAssenza(Assenza assenza) {
		getAssenzas().remove(assenza);
		assenza.setStudente(null);

		return assenza;
	}

}