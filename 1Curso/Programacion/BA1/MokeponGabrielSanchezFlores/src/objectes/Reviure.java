package objectes;
import java.io.Serializable;

import mokepon6.MokeponCapturat;

public class Reviure extends Objecte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Reviure() {
		super("Reviure");
		// TODO Auto-generated constructor stub
	}


	public void utilitzar(MokeponCapturat mok) {
		if(this.getQuantitat() > 0) {
			if(mok.isDebilitat() == true) {
				mok.setDebilitat(false);
				mok.setHp_actual(1);
				System.out.println(mok.getNom() + " ha revivit");
			}
			
			this.quantitat--;
		}
	}

}
