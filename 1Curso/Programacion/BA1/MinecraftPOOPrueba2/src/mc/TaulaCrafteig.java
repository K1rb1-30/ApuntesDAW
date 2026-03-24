package mc;

public class TaulaCrafteig {
	private Item comp1;
	private Item comp2;
	private Item resultat;
	
	
	
	public TaulaCrafteig() {
		this.comp1 = null;
		this.comp2 = null;
		this.resultat = null;
	}

	public Item craftejar() {
		if(this.comp1 != null && this.comp2 != null && this.resultat != null) {
			return this.resultat;
		}else {
			return null;
		}
	}
	
	public boolean afegirComponents(Item c1, Item c2, Item resultat) {
		if(c1 instanceof Component && c2 instanceof Component && resultat instanceof Pocio) {
			this.comp1 = c1;
			this.comp2 = c2;
			this.resultat = resultat;
			
			return true;
		}else {
			return false;
		}
	}

	
	public Item getComp1() {
		return comp1;
	}

	public Item getComp2() {
		return comp2;
	}

	public Item getResultat() {
		return resultat;
	}
	
	
}
