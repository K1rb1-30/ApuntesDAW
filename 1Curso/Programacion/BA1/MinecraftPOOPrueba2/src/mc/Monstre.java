package mc;

public class Monstre extends NoJugable implements Pocionable {
	
	public int atac;

	public Monstre(String nom, int maxHp, int atac) {
		super(nom, maxHp);
		this.atac = atac;
		// TODO Auto-generated constructor stub
	}
	
	public boolean atacar(Personatge p) {
		p.setHp(p.getHp() - this.atac);
		
		return p.viu;
	}

	@Override
	public void mhasLLancatUnaPocio(Pocio p) {
		// TODO Auto-generated method stub
		if(p.tipus == Tipus.LLANCABLE) {
			this.setHp(this.getHp() - p.poder);
		}
	}

}
