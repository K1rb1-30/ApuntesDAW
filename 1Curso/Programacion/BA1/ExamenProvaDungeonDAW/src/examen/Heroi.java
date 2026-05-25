package examen;

public class Heroi {
	String nom;
	String tipus;
	int hp;
	int atac;
	String faccio;
	Nivell nivell;
	
	
	public Heroi(String nom, String tipus, int hp, int atac, String faccio, Nivell nivell) {
		super();
		this.nom = nom;
		this.tipus = tipus;
		this.hp = hp;
		this.atac = atac;
		this.faccio = faccio;
		this.nivell = nivell;
	}


	@Override
	public String toString() {
		return "Heroi [nom=" + nom + ", hp=" + hp + ", atac=" + atac + ", faccio=" + faccio + "]";
	}
	
	
}
