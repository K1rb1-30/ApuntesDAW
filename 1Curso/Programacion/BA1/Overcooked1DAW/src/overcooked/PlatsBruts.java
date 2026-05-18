package overcooked;

import java.util.Stack;

public class PlatsBruts {
	 private Stack<Plat> pila;
	   public PlatsBruts() {
	       this.pila = new Stack<>();
	   }
	   public void afegir(Plat p) {
	       pila.push(p);
	   }
	   public Plat rentar() {
	       return pila.pop();
	   }
	   public boolean esBuida() {
	       return pila.isEmpty();
	   }
	   public int mida() {
	       return pila.size();
	   }
}
