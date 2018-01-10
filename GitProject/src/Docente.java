
public class Docente extends Persona {
	
	private Corso corsoTenuto;
	private int oreTenute;
	private int oreDaTenere;
	
	public Corso getCorsoTenuto() {
		return corsoTenuto;
	}
	public void setCorsoTenuto(Corso corsoTenuto) {
		this.corsoTenuto = corsoTenuto;
	}
	public int getOreTenute() {
		return oreTenute;
	}
	public void setOreTenute(int oreTenute) {
		this.oreTenute = oreTenute;
	}
	public int getOreDaTenere() {
		return oreDaTenere;
	}
	public void setOreDaTenere(int oreDaTenere) {
		this.oreDaTenere = oreDaTenere;
	}

}
