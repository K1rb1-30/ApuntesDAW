package stardewValley;

public class PersonatgeCasable extends NoJugable implements Fuckable{

	public PersonatgeCasable(String nom, Hortalissa preferida, boolean casat) {
		super(nom, preferida, casat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean propostaParella(Granger g) {
		// TODO Auto-generated method stub
		if(this.getApreci() == this.getApreciMaxim()) {
			g.parella = this;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void casar(Fuckable parella) {
		// TODO Auto-generated method stub
		this.casat = true;
		Personatge p = (Personatge) parella;
		p.casat = true;
	}
	
	
	
}
