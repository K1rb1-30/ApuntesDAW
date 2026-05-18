package overcooked;

public class Cuiner {
	String nom;
	int sexe;
	
	public Cuiner(String nom, int sexe) {
		super();
		this.nom = nom;
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Cuiner [nom=" + nom + ", sexe=" + sexe + "]";
	}
	
	public void cuinar(String nomRestaurant) {
		Plat plat = Restaurant.getInstance(nomRestaurant).servirComanda();
		
		if(plat == null) {
			System.out.println(nom + ": no hi ha comandes pendents.");
			return;
		}
		
		
		if(this.sexe == 0) {
			System.out.println("El cuiner"+ nom + " esta cuinant " + plat);
		}else if(this.sexe == 1) {
			System.out.println("La cuinera"+ nom + " esta cuinant " + plat);
		}
		
		Restaurant.getInstance(nomRestaurant).afegirPlatBrut(plat);
	}
	
}
