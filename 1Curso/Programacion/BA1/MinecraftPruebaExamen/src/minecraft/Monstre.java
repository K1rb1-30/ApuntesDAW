package minecraft;

public class Monstre extends NoJugable{
	
	public int atac;

	public Monstre(String nom, int maxHp, int atac) {
		super(nom, maxHp);
		this.atac = atac;
	}
	
	public boolean atacar(Personatge p) {
		p.setHp(getHp() - this.atac);
		if(p.viu == true) {
			return true;
		}else {
			return false;
		}
		
	}

}
