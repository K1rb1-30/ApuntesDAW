package mc;

public abstract class Item {
	public String nom;
	public int valor;
	
	public Item(String nom, int valor) {
		this.nom = nom;
		this.valor = valor;
	}
	
	public abstract void avaluar();
	
	
}
