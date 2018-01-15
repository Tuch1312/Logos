package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mail;

	private String cognome;

	private int corsoTenuto;

	private String immagine;

	private String indirizzo;

	private String nome;

	private int oreDaTenere;

	private int oreTenute;

	private String password;

	//bi-directional many-to-one association to CorsoDocente
	@OneToMany(mappedBy="docente")
	private List<CorsoDocente> corsoDocentes;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="mail")
	private Persona persona;

	public Docente() {
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getCorsoTenuto() {
		return this.corsoTenuto;
	}

	public void setCorsoTenuto(int corsoTenuto) {
		this.corsoTenuto = corsoTenuto;
	}

	public String getImmagine() {
		return this.immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CorsoDocente> getCorsoDocentes() {
		return this.corsoDocentes;
	}

	public void setCorsoDocentes(List<CorsoDocente> corsoDocentes) {
		this.corsoDocentes = corsoDocentes;
	}

	public CorsoDocente addCorsoDocente(CorsoDocente corsoDocente) {
		getCorsoDocentes().add(corsoDocente);
		corsoDocente.setDocente(this);

		return corsoDocente;
	}

	public CorsoDocente removeCorsoDocente(CorsoDocente corsoDocente) {
		getCorsoDocentes().remove(corsoDocente);
		corsoDocente.setDocente(null);

		return corsoDocente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}