package objectes;

import java.io.Serializable;

import mokepon6.MokeponCapturat;

public class Arma extends Objecte implements Equipament, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int atacExtra;

	public Arma(int atacExtra) {
		super("Arma");
		this.atacExtra = atacExtra;
		
	}

	
	public void utilitzar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		this.Equipar(mok);
	}

	public void Equipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.setObjecteEquipat(this);
		mok.setAtk(mok.getAtk() + atacExtra);
	}

	public void Desequipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.setObjecteEquipat(null);
		mok.setAtk(mok.getAtk() - atacExtra);
	}

}
