import java.io.File;
import java.util.Date;

public class Corso {
	private String idCorso;
	private String titolo;
	private Lezione[] lezioni;
	private Date dataInizio;
	private int numLezioni;
	private float oreTotali;
	private int numGiorni;
	private float orePerGiorno;
	private int numMaxStudenti;
	private String requisitiMinimi;
	private Docente docente;
	private String descrizione;
	private int numLezioniPerGiorno;
	private String sede;
	private float oreTrascorse;
	private File immagineCorso;
	private Lezione lezioneCorrente;
	
	
	public String getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(String idCorso) {
		this.idCorso = idCorso;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Lezione[] getLezioni() {
		return lezioni;
	}
	public void setLezioni(Lezione[] lezioni) {
		this.lezioni = lezioni;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public int getNumLezioni() {
		return numLezioni;
	}
	public void setNumLezioni(int numLezioni) {
		this.numLezioni = numLezioni;
	}
	public float getOreTotali() {
		return oreTotali;
	}
	public void setOreTotali(float oreTotali) {
		this.oreTotali = oreTotali;
	}
	public int getNumGiorni() {
		return numGiorni;
	}
	public void setNumGiorni(int numGiorni) {
		this.numGiorni = numGiorni;
	}
	public float getOrePerGiorno() {
		return orePerGiorno;
	}
	public void setOrePerGiorno(float orePerGiorno) {
		this.orePerGiorno = orePerGiorno;
	}
	public int getNumMaxStudenti() {
		return numMaxStudenti;
	}
	public void setNumMaxStudenti(int numMaxStudenti) {
		this.numMaxStudenti = numMaxStudenti;
	}
	public String getRequisitiMinimi() {
		return requisitiMinimi;
	}
	public void setRequisitiMinimi(String requisitiMinimi) {
		this.requisitiMinimi = requisitiMinimi;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getNumLezioniPerGiorno() {
		return numLezioniPerGiorno;
	}
	public void setNumLezioniPerGiorno(int numLezioniPerGiorno) {
		this.numLezioniPerGiorno = numLezioniPerGiorno;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public float getOreTrascorse() {
		return oreTrascorse;
	}
	public void setOreTrascorse(float oreTrascorso) {
		this.oreTrascorse = oreTrascorso;
	}
	public File getImmagineCorso() {
		return immagineCorso;
	}
	public void setImmagineCorso(File immagineCorso) {
		this.immagineCorso = immagineCorso;
	}
	public Lezione getLezioneCorrente() {
		return lezioneCorrente;
	}
	public void setLezioneCorrente(Lezione lezioneCorrente) {
		this.lezioneCorrente = lezioneCorrente;
	}
	
	
	
}
