package objectes;
import mokepon6.MokeponCapturat;

public class Pocio extends Objecte {
	
	int hp_curada;
	
	Pocio(int hp_curada) {
		super("Pocio");

		this.hp_curada = hp_curada;
	}

	public void utilitzar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		if(this.getQuantitat() > 0) {
			if(mok.isDebilitat() == false) {
				if(mok.getHp_actual() + this.hp_curada < mok.getHp_max()) {
					mok.setHp_actual(hp_curada);
					System.out.println(mok.getNom() + "ha recuperat salut!");
				}else if(mok.getHp_actual() + this.hp_curada >= mok.getHp_max()) {
					mok.curar();
				}
			}
			
			this.quantitat--;
		}
		
	}

}
