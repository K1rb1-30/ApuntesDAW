package stardewValley;

public abstract class NoJugable extends Personatge{
	
	private int apreci;
	private int apreciMaxim;
	
	public NoJugable(String nom, Hortalissa preferida, boolean casat) {
		super(nom, preferida);
		this.casat = casat;
		this.apreci = 0;
		this.apreciMaxim = 10;
		// TODO Auto-generated constructor stub
	}
	
	public abstract boolean propostaParella(Granger g);

	
	public int getApreci() {
		return apreci;
	}

	public void setApreci(int apreci) {
		if(apreci < 0) {
			this.apreci = 0;
		}else if(apreci > this.apreciMaxim) {
			this.apreci = this.apreciMaxim;
		}else {
			this.apreci = apreci;
		}
	}

	public int getApreciMaxim() {
		return apreciMaxim;
	}

	public void setApreciMaxim(int apreciMaxim) {
		this.apreciMaxim = apreciMaxim;
	}
	
	
}
