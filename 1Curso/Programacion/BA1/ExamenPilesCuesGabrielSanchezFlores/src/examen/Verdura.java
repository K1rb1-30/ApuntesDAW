package examen;

public class Verdura extends Cultiu {
	
	
	public Verdura(String nom, int diesMadurar, int preu, String estacio, Qualitat qualitat) {
		super(nom, diesMadurar, preu, estacio, qualitat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Verdura [" + super.toString() + "]";
	}
}
