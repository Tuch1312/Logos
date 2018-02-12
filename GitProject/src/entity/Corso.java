package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@NamedQuery(name="Corso.findAll", query="SELECT c FROM Corso c")
public class Corso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCorso;
	
	@OneToMany(mappedBy="corso")
	private List<Iscrizione> iscrizioni;

	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIME)
	private Date oraInizioLezioni;
	
	@Column(nullable = true)
	private String descrizione;
	
	@Column(nullable = true)
	private String immagine;
	
	@Column(nullable = true)
	private int lezioneCorrente;
	
	@Column(nullable = true)
	private int lezioneEffettuate;
	
	@Column(nullable=true)
	private int numeroGiorni;

	private int numeroLezioni;

	private int numeroStudentiIscritti;

	private int numMaxStudenti;
	
	@Column(nullable=true)
	private int durataLezione;

	private int oreTotali;

	private int oreTrascorse;

	private String sede;

	@Column(nullable=false)
	private String titolo;
	
	@Column(nullable=true)
	private Integer lezionePerGiorno;
	
	private int contatoreGiorniInterno;
	
	//Utilizzata per definire in quali gionri della settimana si svolge il corso, nella forma (1,2,3,4,5,6,7) dove 1 = lunedi e 7 = domenica..
	@Column(nullable=true)
	private String patternLezioni;

	@ManyToOne
	@JoinColumn(name="mail_docente")
	private Docente docente;

	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "corso", fetch = FetchType.EAGER )
	private List<Lezione> leziones;

	//Metodi
	
	public Corso() {
	}

	
	
	public String getPatternLezioni() {
		return patternLezioni;
	}



	public void setPatternLezioni(String patternLezioni) {
		this.patternLezioni = patternLezioni;
	}



	public int getContatoreGiorniInterno() {
		return contatoreGiorniInterno;
	}


	public void setContatoreGiorniInterno(int contatoreGiorniInterno) {
		this.contatoreGiorniInterno = contatoreGiorniInterno;
	}


	public Date getOraInizioLezioni() {
		return oraInizioLezioni;
	}


	public void setOraInizioLezioni(Date oraInizioLezioni) {
		this.oraInizioLezioni = oraInizioLezioni;
	}


	public int getDurataLezione() {
		return durataLezione;
	}


	public void setDurataLezione(int durataLezione) {
		this.durataLezione = durataLezione;
	}

	
	public int getIdCorso() {
		return this.idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getImmagine() {
		return this.immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public int getLezioneCorrente() {
		return this.lezioneCorrente;
	}

	public void setLezioneCorrente(int lezioneCorrente) {
		this.lezioneCorrente = lezioneCorrente;
	}

	public int getLezioneEffettuate() {
		return this.lezioneEffettuate;
	}

	public void setLezioneEffettuate(int lezioneEffettuate) {
		this.lezioneEffettuate = lezioneEffettuate;
	}

	public int getNumeroGiorni() {
		return this.numeroGiorni;
	}

	public void setNumeroGiorni(int numeroGiorni) {
		this.numeroGiorni = numeroGiorni;
	}

	public int getNumeroLezioni() {
		return this.numeroLezioni;
	}

	public void setNumeroLezioni(int numeroLezioni) {
		this.numeroLezioni = numeroLezioni;
	}

	public int getNumeroStudentiIscritti() {
		return this.numeroStudentiIscritti;
	}

	public void setNumeroStudentiIscritti(int numeroStudentiIscritti) {
		this.numeroStudentiIscritti = numeroStudentiIscritti;
	}

	public int getNumMaxStudenti() {
		return this.numMaxStudenti;
	}

	public void setNumMaxStudenti(int numMaxStudenti) {
		this.numMaxStudenti = numMaxStudenti;
	}

	public int getOreTotali() {
		return this.oreTotali;
	}

	public void setOreTotali(int oreTotali) {
		this.oreTotali = oreTotali;
	}

	public int getOreTrascorse() {
		return this.oreTrascorse;
	}

	public void setOreTrascorse(int oreTrascorse) {
		this.oreTrascorse = oreTrascorse;
	}

	public String getSede() {
		return this.sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Lezione> getLeziones() {
		return this.leziones;
	}

	public void setLeziones(List<Lezione> leziones) {
		this.leziones = leziones;
	}

	public Lezione addLezione(Lezione lezione) {
		getLeziones().add(lezione);
		lezione.setCorso(this);

		return lezione;
	}

	public Lezione removeLezione(Lezione lezione) {
		getLeziones().remove(lezione);
		lezione.setCorso(null);

		return lezione;
	}
	
	
	public Integer getLezionePerGiorno() {
		return lezionePerGiorno;
	}

	public void setLezionePerGiorno(Integer lezionePerGiorno) {
		this.lezionePerGiorno = lezionePerGiorno;
	}
	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}


}