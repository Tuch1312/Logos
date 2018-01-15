package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the assenza database table.
 * 
 */


@Entity
@NamedQuery(name="Assenza.findAll", query="SELECT a FROM Assenza a")
public class Assenza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="ora_arrivo")
	private float oraArrivo;

	@Column(name="ora_uscita")
	private float oraUscita;

	//bi-directional many-to-one association to Lezione
	@ManyToOne
	@JoinColumn(name="id_lezione")
	private Lezione lezione;

	//bi-directional many-to-one association to Studente
	@ManyToOne
	@JoinColumn(name="mail_studente")
	private Studente studente;

	public Assenza() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getOraArrivo() {
		return this.oraArrivo;
	}

	public void setOraArrivo(float oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	public float getOraUscita() {
		return this.oraUscita;
	}

	public void setOraUscita(float oraUscita) {
		this.oraUscita = oraUscita;
	}

	public Lezione getLezione() {
		return this.lezione;
	}

	public void setLezione(Lezione lezione) {
		this.lezione = lezione;
	}

	public Studente getStudente() {
		return this.studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

}