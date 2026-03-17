package minecraft;

import java.util.ArrayList;

public class Jugable extends Personatge{
	
	public ArrayList<Item> equip;
	public int esmeraldes;
	
	
	
	public Jugable(String nom, int maxHp, int esmeraldes) {
		super(nom, maxHp);
		this.equip = new ArrayList<Item>();
		this.esmeraldes = esmeraldes;
	}

	public int vendre(int index, Comerciant c) {
		if(c.viu == true) {
			this.esmeraldes += this.equip.get(index).valor;
			this.equip.remove(index);
		}
		
		return this.esmeraldes;
	}
	
	public int comprar(Comerciant c) {
		if(c.viu = true && this.esmeraldes >= c.preuVenda) {
			this.equip.add(c.objecte);
			c.quantitat--;
			this.esmeraldes -= c.preuVenda;
		}
		return this.esmeraldes;
		
	}
	
	public void utilizar(Pocio p) {
		if(p.tipus == Tipus.CONSUMIBLE) {
			this.setHp(p.poder);
		}
	}
}
