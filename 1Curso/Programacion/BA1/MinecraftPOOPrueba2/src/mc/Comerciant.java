package mc;

public class Comerciant extends NoJugable implements Pocionable {
	
	public int quantitat;
	public int preuVenda;
	public Item objecte;

	public Comerciant(String nom) {
		super(nom);
		this.setMaxHp(1);
	}

	@Override
	public void mhasLLancatUnaPocio(Pocio p) {
		// TODO Auto-generated method stub
		if(p.tipus == Tipus.LLANCABLE) {
			this.setHp(-1); // con esto te aseguras que muere
		}
	}

}
