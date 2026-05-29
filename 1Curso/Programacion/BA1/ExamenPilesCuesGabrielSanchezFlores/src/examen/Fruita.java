package examen;

public class Fruita extends Cultiu{

	public Fruita(String nom, int diesMadurar, int preu, String estacio, Qualitat qualitat) {
		super(nom, diesMadurar, preu, estacio, qualitat);
	}
	
	@Override
	public String toString() {
		return "Fruita [" + super.toString() + "]";
	}
	
}
