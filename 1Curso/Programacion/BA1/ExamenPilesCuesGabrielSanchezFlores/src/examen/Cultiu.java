package examen;

public abstract class Cultiu {
	String nom;
	int diesMadurar;
	int preu;
	String estacio;
	Qualitat qualitat;
	
	
	
	public Cultiu(String nom, int diesMadurar, int preu, String estacio, Qualitat qualitat) {
		super();
		this.nom = nom;
		this.diesMadurar = diesMadurar;
		this.preu = preu;
		this.estacio = estacio;
		this.qualitat = qualitat;
	}


	@Override
	public String toString() {
		return "nom=" + nom + ", dies=" + diesMadurar + ", preu=" + preu + ", estacio=" + estacio
				+ ", qualitat=" + qualitat + "";
	}
	
	
	
	
	
	
}
