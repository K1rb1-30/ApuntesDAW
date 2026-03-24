package stardewValley;

public abstract class Personatge {
	public String nom;
	public Hortalissa preferida;
	public boolean casat;
	
	public Personatge(String nom, Hortalissa preferida) {
		this.nom = nom;
		this.preferida = preferida;
	}


	@Override
	public String toString() {
		return nom;
	}
	
	
	
	
	
	
}
