package entity;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Lezione {

		@Id
		@Column(name="id_lezione")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idLezione;
		@Column(name="lezione_id_corso")
		private int lezioneIdCorso;
		@Temporal(TemporalType.DATE)
		private Date data;
		private int durata;
		private String[] argomenti;
		@Column(name="tenuta_da")
		private Docente tenutada;
		@Column(name="ora_inizio")
		@Temporal(TemporalType.TIME)
		private Date orainizio;
		private String aula;
		private Studente[] assenti;
		@Column(name="num_assenti")
		private int numAssenti;
		@Column(name="percent_assenti")
		private float percentAssenti;
		
		//Getter and Setter
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}
		public int getDurata() {
			return durata;
		}
		public void setDurata(int durata) {
			this.durata = durata;
		}
		public String[] getArgomenti() {
			return argomenti;
		}
		public void setArgomenti(String[] argomenti) {
			this.argomenti = argomenti;
		}
		public Docente getTenutada() {
			return tenutada;
		}
		public void setTenutada(Docente tenutada) {
			this.tenutada = tenutada;
		}
		public Date getOrainizio() {
			return orainizio;
		}
		public void setOrainizio(Date orainizio) {
			this.orainizio = orainizio;
		}
		public String getAula() {
			return aula;
		}
		public void setAula(String aula) {
			this.aula = aula;
		}
		public Studente[] getAssenti() {
			return assenti;
		}
		public void setAssenti(Studente[] assenti) {
			this.assenti = assenti;
		}
		public int getNumAssenti() {
			return numAssenti;
		}
		public void setNumAssenti(int numAssenti) {
			this.numAssenti = numAssenti;
		}
		public int getPercentAssenti() {
			return percentAssenti;
		}
		public void setPercentAssenti(int percentAssenti) {
			this.percentAssenti = percentAssenti;
		}
		
		
		
	

}
