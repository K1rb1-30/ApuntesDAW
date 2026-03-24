package mc;

import java.util.ArrayList;

public class Jugable extends Personatge {
	
	public ArrayList<Item> equip;
	public int esmeraldes;
	
	public Jugable(String nom, int maxHp, int esmeraldes) {
		super(nom, maxHp);
		this.esmeraldes = esmeraldes;
		this.equip = new ArrayList<Item>();
		
	}
	
	public int vendre(int i, Comerciant c) {
		if(c.viu == true) {
			this.esmeraldes += this.equip.get(i).valor;
			this.equip.remove(i);
		}
		
		return this.esmeraldes;
	}
	
	public int comprar(Comerciant c) throws EtsPobreException {
		if(c.viu == true && this.esmeraldes >= c.preuVenda) {
			this.equip.add(c.objecte);
			c.quantitat--;
			this.esmeraldes -= c.preuVenda;
		}else if(!(this.esmeraldes >= c.preuVenda)) {
			throw new EtsPobreException("No tens prous esmeraldes per comprar " + c.objecte.nom + " al comerciant " + c.nom);
		}else {
			throw new EtsPobreException("El comerciant és mor, no li pots comprar res");
		}
		
		return this.esmeraldes;
	}
	
	public void utilizar(Pocio p) {
		if(p.tipus == Tipus.CONSUMIBLE) {
			this.setHp(p.poder);
		}
	}

	@Override
	public String toString() {
		return this.nom + " (" + this.getHp() + "/" + this.getMaxHp() + ") - "
	            + this.esmeraldes + " esmeraldes";

	}
	
	
	
	
	
	
	

}
