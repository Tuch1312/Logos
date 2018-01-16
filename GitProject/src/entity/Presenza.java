package entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name="Presenza.findAll", query="SELECT a FROM Presenza a")
public class Presenza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//assumiamo il fatto che uno studente con ora_arrivo e ora_uscita
	//entrambi null sia assente
	@Column(name="ora_arrivo", nullable = true)
	private Float oraArrivo;

	@Column(name="ora_uscita", nullable = true)
	private Float oraUscita;

	//bi-directional many-to-one association to Lezione
	@ManyToOne
	@JoinColumn(name="id_lezione")
	private Lezione lezione;

	//bi-directional many-to-one association to Studente
	@ManyToOne
	@JoinColumn(name="mail")
	private Studente studente;

	public Presenza() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getOraArrivo() {
		return this.oraArrivo;
	}

	public void setOraArrivo(Float oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	public Float getOraUscita() {
		return this.oraUscita;
	}

	public void setOraUscita(Float oraUscita) {
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