package examen;

public class ItemBotiga {
	String nom;
	int preu;
	String tipus;
	int quantitat;
	boolean disponible;
	
	

	public ItemBotiga() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemBotiga(String nom, int preu, String tipus, int quantitat, boolean disponible) {
		super();
		this.nom = nom;
		this.preu = preu;
		this.tipus = tipus;
		this.quantitat = quantitat;
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "ItemBotiga [nom=" + nom + ", preu=" + preu + ", tipus=" + tipus + ", quantitat=" + quantitat
				+ ", disponible=" + disponible + "]";
	}
	
}
