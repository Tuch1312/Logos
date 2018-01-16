package entity;

import javax.persistence.*;
import java.util.List;


@Entity
@DiscriminatorValue("S")
@Table(name="studente")
@NamedQuery(name="Studente.findAll", query="SELECT s FROM Studente s")
public class Studente extends Persona {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "studente", orphanRemoval = true)
	private List<Presenza> presenza;

	public Studente() {
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