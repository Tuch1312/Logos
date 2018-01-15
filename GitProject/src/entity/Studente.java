package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the studente database table.
 * 
 */
@Entity
@NamedQuery(name="Studente.findAll", query="SELECT s FROM Studente s")
public class Studente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mail_studente")
	private String mailstudente;

	//bi-directional many-to-one association to Assenza
	@OneToMany(mappedBy="studente")
	private List<Assenza> assenzas;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="mail_studente")
	private Persona persona;

	public Studente() {
	}

	public String getMailstudente() {
		return this.mailstudente;
	}

	public void setMailstudente(String mailstudente) {
		this.mailstudente = mailstudente;
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

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}