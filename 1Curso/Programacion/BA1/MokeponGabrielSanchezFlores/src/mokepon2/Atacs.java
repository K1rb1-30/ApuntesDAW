package mokepon2;

public class Atacs {

	String nom;
	double poder;
	Tipus tipus;
	int moviments_maxims;
	int moviments_actuals;

	public Atacs(String nom, double poder, Tipus tipus, int moviments_maxims) {
		this.nom = nom;
		this.poder = poder;
		this.tipus = tipus;
		this.moviments_maxims = moviments_maxims;
		this.moviments_actuals = this.moviments_maxims;
		
		if(this.poder < 10) {
			this.poder = 10;
		}else if(this.poder > 100) {
			this.poder = 100;
		}
	}
	
	public Atacs(String nom, Tipus tipus){
		this.nom = nom;
		this.tipus = tipus;
		this.poder = 10;
		this.moviments_maxims = 10;
		this.moviments_actuals = this.moviments_maxims;
	}

	@Override
	public String toString() {
		return "Atacs [nom=" + nom + ", poder=" + poder + ", tipus=" + tipus + ", moviments_maxims=" + moviments_maxims
				+ ", moviments_actuals=" + moviments_actuals + "]";
	}
	
}
