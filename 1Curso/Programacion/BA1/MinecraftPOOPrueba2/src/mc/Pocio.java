package mc;

public class Pocio extends Item{

	public int poder;
	public Tipus tipus;
	
	
	public Pocio(String nom, int valor, int poder, Tipus tipus) {
		super(nom, valor);
		this.poder = poder;
		this.tipus = tipus;
		// TODO Auto-generated constructor stub
	}
	
	public void avaluar() {
		System.out.print(this.nom + " " + this.tipus);
		if(this.valor > 50) {
			System.out.println(" MOLT VALUOSA");
		}
	}

}
