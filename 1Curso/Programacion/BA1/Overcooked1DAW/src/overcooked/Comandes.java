package overcooked;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Comandes {
	
	private Queue<Plat>cua;
	
	 public Comandes() {
	       this.cua = new LinkedList<>();
	   }
	   public void afegir(Plat p) {
	       cua.offer(p);
	   }
	   public Plat servir() {
	       return cua.poll();
	   }
	   public boolean esBuida() {
	       return cua.isEmpty();
	   }
	   public int mida() {
	       return cua.size();
	   }
	   public Iterator<Plat> iterator(){
		   return cua.iterator();
	   }
}
