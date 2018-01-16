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

	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	
	@Column(nullable = true)
	private String descrizione;
	
	@Column(nullable = true)
	private String immagine;
	
	@Column(nullable = true)
	private String lezioneCorrente;
	
	@Column(nullable = true)
	private String lezioneEffettuate;
	
	
	private int numeroGiorni;

	private int numeroLezioni;

	private int numeroStudentiIscritti;

	private int numMaxStudenti;

	private int orePerGiorno;

	private int oreTotali;

	private int oreTrascorse;

	private String requisitiMin;

	private String sede;

	private String titolo;
	
	@Column(nullable=false)
	private Integer lezionePerGiorno;

	@ManyToOne
	@JoinColumn(name="mail_docente")
	private Docente docente;

	//bi-directional many-to-one association to Lezione
	@OneToMany(mappedBy="corso")
	private List<Lezione> leziones;

	public Corso() {
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

	public String getLezioneCorrente() {
		return this.lezioneCorrente;
	}

	public void setLezioneCorrente(String lezioneCorrente) {
		this.lezioneCorrente = lezioneCorrente;
	}

	public String getLezioneEffettuate() {
		return this.lezioneEffettuate;
	}

	public void setLezioneEffettuate(String lezioneEffettuate) {
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

	public int getOrePerGiorno() {
		return this.orePerGiorno;
	}

	public void setOrePerGiorno(int orePerGiorno) {
		this.orePerGiorno = orePerGiorno;
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

	public String getRequisitiMin() {
		return this.requisitiMin;
	}

	public void setRequisitiMin(String requisitiMin) {
		this.requisitiMin = requisitiMin;
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


}