package mokepon4;

public class Arma extends Objecte implements Equipament {
	
	int atacExtra;

	public Arma(String nom, int atacExtra) {
		super(nom);
		this.atacExtra = atacExtra;
		
	}

	
	public void utilitzar(Mokepon mok) {
		// TODO Auto-generated method stub
		
	}

	public void Equipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.objecteEquipat = this;
		mok.setAtk(atacExtra + mok.getAtk());
	}

	public void Desequipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		
	}

}
