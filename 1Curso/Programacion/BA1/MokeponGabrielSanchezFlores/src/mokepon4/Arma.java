package mokepon4;

public class Arma extends Objecte implements Equipament {
	
	int atacExtra;

	public Arma(String nom, int atacExtra) {
		super(nom);
		this.atacExtra = atacExtra;
		
	}

	
	public void utilitzar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		this.Equipar(mok);
	}

	public void Equipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.objecteEquipat = this;
		mok.setAtk(mok.getAtk() + atacExtra);
	}

	public void Desequipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.objecteEquipat = null;
		mok.setAtk(mok.getAtk() - atacExtra);
	}

}
