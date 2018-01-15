package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the lezione database table.
 * 
 */
@Entity
@NamedQuery(name="Lezione.findAll", query="SELECT l FROM Lezione l")
public class Lezione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLezione;

	private String argomenti;

	private String assenti;

	private String aula;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int durata;

	private int numAssenti;

	@Temporal(TemporalType.TIMESTAMP)
	private Date oraInizio;

	private float percentAssenti;

	private String studente_mailStudente;

	//bi-directional many-to-one association to Assenza
	@OneToMany(mappedBy="lezione")
	private List<Assenza> assenzas;

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

	public String getStudente_mailStudente() {
		return this.studente_mailStudente;
	}

	public void setStudente_mailStudente(String studente_mailStudente) {
		this.studente_mailStudente = studente_mailStudente;
	}

	public List<Assenza> getAssenzas() {
		return this.assenzas;
	}

	public void setAssenzas(List<Assenza> assenzas) {
		this.assenzas = assenzas;
	}

	public Assenza addAssenza(Assenza assenza) {
		getAssenzas().add(assenza);
		assenza.setLezione(this);

		return assenza;
	}

	public Assenza removeAssenza(Assenza assenza) {
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