package stardewValley;

import java.util.Objects;


public class Hortalissa extends Objecte implements Comparable<Hortalissa>{

	public Tipus tipus;
	public int preuVenda;
	
	public Hortalissa(String nom, Tipus tipus, int preuVenda) {
		super(nom);
		this.tipus = tipus;
		this.preuVenda = preuVenda;
	}

	@Override
	public int vendre() {
		// TODO Auto-generated method stub
		System.out.println("S’ha venut " + this.nom + " per " + this.preuVenda);
		return this.preuVenda;
	}

	@Override
	public String toString() {
		return nom + " (" + tipus + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nom, tipus);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
			
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Hortalissa other = (Hortalissa) obj;
		return nom == other.nom && tipus == other.tipus;
	}
	
	
	
	
	public int compareTo(Hortalissa other) {
		
		//Comparar per preu
		int res = this.preuVenda - other.preuVenda;
		if(res !=0) {
			return res;
		}
		
		// Comparar tipus
		return this.tipus.ordinal() - other.tipus.ordinal();
		
	}
	
	
	

}
