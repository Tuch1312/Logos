package entity;

import javax.persistence.*;
import java.util.List;


@Entity
@DiscriminatorValue("D")
@Table(name="docente")
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente extends Persona {
	private static final long serialVersionUID = 1L;

	private int oreDaTenere;

	private int oreTenute;
	
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "docente")
	 private List<Corso> corsi;

	public Docente() {
		
	}
	
	public int getOreDaTenere() {
		return this.oreDaTenere;
	}

	public void setOreDaTenere(int oreDaTenere) {
		this.oreDaTenere = oreDaTenere;
	}

	public int getOreTenute() {
		return this.oreTenute;
	}

	public void setOreTenute(int oreTenute) {
		this.oreTenute = oreTenute;
	}


}