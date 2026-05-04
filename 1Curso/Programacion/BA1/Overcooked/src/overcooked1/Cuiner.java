package overcooked1;

public class Cuiner {
	private String nom;
	private int sexe;
	
	
	public Cuiner(String nom, int sexe) {
		super();
		this.nom = nom;
		this.sexe = sexe;
	}


	@Override
	public String toString() {
		return "Cuiner [nom=" + nom + ", sexe=" + sexe + "]";
	}
	
	
	public void cuinar(Plat plat) {
		if(this.sexe == 0) {
			System.out.println("El cuiner "+this.nom+" està cuinant "+plat);
		}else if(this.sexe == 1) {
			System.out.println("La cuinera "+this.nom+" està cuinant "+plat);
		}
	}
	
}
