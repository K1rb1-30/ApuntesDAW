package mokepon4;

public class Reviure extends Objecte{

	public Reviure() {
		super("Reviure");
		// TODO Auto-generated constructor stub
	}


	public void utilitzar(MokeponCapturat mok) {
		if(this.getQuantitat() > 0) {
			if(mok.debilitat == true) {
				mok.debilitat = false;
				mok.setHp_actual(1);
				System.out.println(mok.getNom() + " ha revivit");
			}
			
			this.quantitat--;
		}
	}

}
