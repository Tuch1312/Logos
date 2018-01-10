import java.io.File;

public class Persona {
	private String nome;
	private String cognome;
	private String indirizzo;
	private String mail;
	private String password;
	private File immagine;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public File getImmagine() {
		return immagine;
	}
	public void setImmagine(File immagine) {
		this.immagine = immagine;
	}
}
