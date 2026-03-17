package minecraft;

public class Comerciant extends NoJugable{
	
	public int quantitat;
	public int preuVenda;
	public Item objecte;
	
	public Comerciant(String nom, int maxHp) {
		super(nom, maxHp);
		// TODO Auto-generated constructor stub
	}

	public Comerciant(String nom, int quantitat, int preuVenda, Item objecte) {
		super(nom, 1);
		this.quantitat = quantitat;
		this.preuVenda = preuVenda;
		this.objecte = objecte;
	}
	
	
	
}
