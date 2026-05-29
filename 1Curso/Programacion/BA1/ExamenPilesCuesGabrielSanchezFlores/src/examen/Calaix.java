package examen;

import java.util.ArrayDeque;

public class Calaix extends ArrayDeque<Cultiu>{
	private static final int MAX = 4;
	
	public void dipositar(Cultiu cultiu) {
		if(this.size() == MAX) {
			this.pop();
		}
		this.add(cultiu);
	}
	
	public void vendre() {
		if(this.isEmpty()) {
			return;
		}
		
		if(this.peek().qualitat.equals(Qualitat.OR)) {
			System.out.println("Vens " + this.peek().nom + " per un bon preu!");
		}else{
			System.out.println("Vens " + this.peek().nom + " ");
			this.pop();
		}
	}
}
