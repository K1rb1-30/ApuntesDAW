package stardewValley;

import java.util.Objects;

public abstract class Objecte {
	public String nom;
	
	public abstract int vendre();

	
	public Objecte(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return  nom;
	}


	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objecte other = (Objecte) obj;
		return Objects.equals(nom, other.nom);
	}
	
	
	
	
	
	

	
	
	
	
}
