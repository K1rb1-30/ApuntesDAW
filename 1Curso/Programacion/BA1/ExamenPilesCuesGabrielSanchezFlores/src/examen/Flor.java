package examen;

public class Flor extends Cultiu {

	public Flor(String nom, int diesMadurar, int preu, String estacio, Qualitat qualitat) {
		super(nom, diesMadurar, preu, estacio, qualitat);
	}

	@Override
	public String toString() {
		return "Flor [" + super.toString() + "]";
	}
	
	

}
