
public class Studente extends Persona{
	
	private Corso corsoFrequentato;
	private int orePresenza;
	private boolean Presenza;
	private int percentAssenza;
	
	public Corso getCorsoFrequentato() {
		return corsoFrequentato;
	}
	public void setCorsoFrequentato(Corso corsoFrequentato) {
		this.corsoFrequentato = corsoFrequentato;
	}
	public int getOrePresenza() {
		return orePresenza;
	}
	public void setOrePresenza(int orePresenza) {
		this.orePresenza = orePresenza;
	}
	public boolean isPresenza() {
		return Presenza;
	}
	public void setPresenza(boolean presenza) {
		Presenza = presenza;
	}
	public int getPercentAssenza() {
		return percentAssenza;
	}
	public void setPercentAssenza(int percentAssenza) {
		this.percentAssenza = percentAssenza;
	}
	
}
