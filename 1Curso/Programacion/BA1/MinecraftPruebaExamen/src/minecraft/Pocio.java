package minecraft;

public class Pocio extends Item {
	
	public int poder;
	public Tipus tipus;
	
	public Pocio(String nom, int valor, int poder, Tipus tipus) {
		super(nom, valor);
		this.poder = poder;
		this.tipus = tipus;
	}
	
	public void avaluar() {
		
	}

	
	
}
