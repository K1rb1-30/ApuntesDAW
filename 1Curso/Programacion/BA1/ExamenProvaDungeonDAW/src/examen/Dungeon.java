package examen;

public class Dungeon {
	
	static Dungeon instance;
	String nom;
	int nivellPerill;
	int tresor;
	
	static int CAPACITAT = 3;

	private Dungeon(String nom, int nivellPerill, int tresor) {
		super();
		this.nom = nom;
		this.nivellPerill = nivellPerill;
		this.tresor = tresor;
	}
	
	
	
	
}
