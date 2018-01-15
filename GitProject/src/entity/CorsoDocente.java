package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the corso_docente database table.
 * 
 */
@Entity
@Table(name="corso_docente")
@NamedQuery(name="CorsoDocente.findAll", query="SELECT c FROM CorsoDocente c")
public class CorsoDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int oreAncoraDaTenere;

	private int oreTenute;

	private int oreTotDaTenere;

	//bi-directional many-to-one association to Corso
	@ManyToOne
	@JoinColumn(name="IdCorso")
	private Corso corso;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="mail_docente")
	private Docente docente;

	public CorsoDocente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOreAncoraDaTenere() {
		return this.oreAncoraDaTenere;
	}

	public void setOreAncoraDaTenere(int oreAncoraDaTenere) {
		this.oreAncoraDaTenere = oreAncoraDaTenere;
	}

	public int getOreTenute() {
		return this.oreTenute;
	}

	public void setOreTenute(int oreTenute) {
		this.oreTenute = oreTenute;
	}

	public int getOreTotDaTenere() {
		return this.oreTotDaTenere;
	}

	public void setOreTotDaTenere(int oreTotDaTenere) {
		this.oreTotDaTenere = oreTotDaTenere;
	}

	public Corso getCorso() {
		return this.corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}