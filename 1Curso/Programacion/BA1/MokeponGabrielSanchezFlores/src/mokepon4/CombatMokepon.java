package mokepon4;

public class CombatMokepon {
	Mokepon mokepon1;
	Mokepon mokepon2;
	boolean fi = false;
	
	public CombatMokepon(Mokepon mok1, Mokepon mok2) {
		this.mokepon1 = mok1;
		this.mokepon2 = mok2;
	}
	
	int torn = MokeponMesRapid(mokepon1, mokepon2);
	
	
	
	public int MokeponMesRapid(Mokepon mok1, Mokepon mok2) {
		// TODO Auto-generated method stub
		if(mok1.getVel() > mok2.getVel()) {
			return 1;
		}else {
			return 2;
		}
	}

}
