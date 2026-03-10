package mokepon4;

//Una classe abstracta no pot instanciàrse (és a dir, no pots fer un new). 
//Només les classes abstractes poden tenir mètodes abstractes

public abstract class Objecte {
	
	private String nom;
	public int quantitat;
	
	
	public Objecte(String nom) {
		this.nom = nom;
		this.quantitat = 1;
	}
	
	public void obtenir(int numObjectes) {
		this.quantitat = numObjectes;
	}
	
	public void donar(MokeponCapturat mok) {
		mok.objecte = this;
	}
	
	//Un mètode abstracte significa que és un mètode que no existeix però els seus fills estan obligats a implementar-lo. 
	//Fixa’t que es tanca amb punt i coma sense obrir i definir el mètode
	
	public abstract void utilitzar(Mokepon mok);
	
	
	public String getNom() {
		return nom;
	}
	public int getQuantitat() {
		return quantitat;
	}
	
	
}
