package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@NamedQuery(name="Lezione.findAll", query="SELECT l FROM Lezione l")
public class Lezione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLezione;
	
	@Column(nullable = true)
	private String argomenti;
	
	@Column(nullable = true)
	private String assenti;

	
	private String aula;

	@Temporal(TemporalType.DATE)
	private Date data;
	
	
	private int durata;
	
	private int numAssenti;

	@Temporal(TemporalType.TIMESTAMP)
	private Date oraInizio;
	
	private float percentAssenti;
	

	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "lezione")
	private List<Presenza> presenza;

	//bi-directional many-to-one association to Corso
	@ManyToOne
	private Corso corso;

	public Lezione() {
	}

	public int getIdLezione() {
		return this.idLezione;
	}

	public void setIdLezione(int idLezione) {
		this.idLezione = idLezione;
	}

	public String getArgomenti() {
		return this.argomenti;
	}

	public void setArgomenti(String argomenti) {
		this.argomenti = argomenti;
	}

	public String getAssenti() {
		return this.assenti;
	}

	public void setAssenti(String assenti) {
		this.assenti = assenti;
	}

	public String getAula() {
		return this.aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getDurata() {
		return this.durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getNumAssenti() {
		return this.numAssenti;
	}

	public void setNumAssenti(int numAssenti) {
		this.numAssenti = numAssenti;
	}

	public Date getOraInizio() {
		return this.oraInizio;
	}

	public void setOraInizio(Date oraInizio) {
		this.oraInizio = oraInizio;
	}

	public float getPercentAssenti() {
		return this.percentAssenti;
	}

	public void setPercentAssenti(float percentAssenti) {
		this.percentAssenti = percentAssenti;
	}

	public List<Presenza> getAssenzas() {
		return this.presenza;
	}

	public void setAssenzas(List<Presenza> assenzas) {
		this.presenza = assenzas;
	}

	public Presenza addAssenza(Presenza assenza) {
		getAssenzas().add(assenza);
		assenza.setLezione(this);

		return assenza;
	}

	public Presenza removeAssenza(Presenza assenza) {
		getAssenzas().remove(assenza);
		assenza.setLezione(null);

		return assenza;
	}

	public Corso getCorso() {
		return this.corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

}