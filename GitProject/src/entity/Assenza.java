package entity;
import javax.persistence.*;

@Entity
public class Assenza {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private Studente studente;
	private Corso corso;
	@Column(name = "ore_assenza")
	private int oreAssenza;
	@Column(name = "percent_assenza")
	private float percentAssenza;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Studente getStudente() {
		return studente;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public Corso getCorso() {
		return corso;
	}
	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	public int getOreAssenza() {
		return oreAssenza;
	}
	public void setOreAssenza(int oreAssenza) {
		this.oreAssenza = oreAssenza;
	}
	public float getPercentAssenza() {
		return percentAssenza;
	}
	public void setPercentAssenza(float percentAssenza) {
		this.percentAssenza = percentAssenza;
	}
	
	

}
