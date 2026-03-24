package stardewValley;

public class Granger extends Personatge implements Fuckable{
	
	public Personatge parella;
	public BossaCollita<Hortalissa> bossa;
	
	public Granger(String nom, Hortalissa preferida) {
		super(nom, preferida);
		this.casat = false;
		this.parella = null;
		this.bossa = new BossaCollita<Hortalissa>();
	}
	
	public int regalar(NoJugable altrePersonatge, Objecte regal) {
		
		if(regal instanceof Llavor) {
			altrePersonatge.setApreci(altrePersonatge.getApreci() - 1);
			
		}else if(regal instanceof Hortalissa) {
			if(regal.equals(altrePersonatge.preferida)) {
				altrePersonatge.setApreci(altrePersonatge.getApreci() + 2);
			}else {
				altrePersonatge.setApreci(altrePersonatge.getApreci() + 1);
			}
			
		}
		
		return altrePersonatge.getApreci();
		
	}
	
	public void plantar(Conreu c, Llavor l) {
		c.conreat = l;
	}
	
	public void regar(Conreu c) {
			if(c.conreat != null) {
				c.conreat.tornsRegada += 1;
			}
		}
	
	public Hortalissa collir(Conreu c) throws GrangerIncompetentException{
		if(c.conreat != null && c.conreat.tornsRegada >= c.conreat.tornsPerCreixer) {
			
			Hortalissa h = c.conreat.hortalissa;
			
			bossa.add(h);
			
			c.conreat = null;
			
			return h;
			
		}else if(c.conreat == null) {
			
			throw new GrangerIncompetentException("no s'ha regat prou");
			
		}else if(!(c.conreat.tornsRegada >= c.conreat.tornsPerCreixer)) {
			throw new GrangerIncompetentException("no té llavor (null)");
		}
		
		return null;
		
	}

	@Override
	public void casar(Fuckable parella) {
		this.casat = true;
		Personatge p = (Personatge) parella;
		p.casat = true;
	}
	
	
	
}
