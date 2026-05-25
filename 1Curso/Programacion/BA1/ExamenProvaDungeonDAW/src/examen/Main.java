package examen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import overcooked.Plat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heroi heroi1 = new Heroi("Arthas", "Guerrer", 120, 25, "Aliats", Nivell.NOVELL);
		Heroi heroi2 = new Heroi("Sylvanas", "Arquera", 90, 35, "Horda", Nivell.VETERA);
		Heroi heroi3 = new Heroi("Merlin", "Mag", 80, 50, "Aliats", Nivell.LLEGENDARI);
		Heroi heroi4 = new Heroi("Thrall", "Xaman", 110, 30, "Horda", Nivell.VETERA);
		Heroi heroi5 = new Heroi("Luna", "Assassina", 70, 45, "Neutral", Nivell.LLEGENDARI);
		
		ArrayList<Heroi> llistaH = new ArrayList<Heroi>();
		
		llistaH.add(heroi1);
		llistaH.add(heroi2);
		llistaH.add(heroi3);
		llistaH.add(heroi4);
		llistaH.add(heroi5);
		
		NetejaConsecutius(llistaH);
		
	}
	
	public static void NetejaConsecutius(List<Heroi> herois) {
		ListIterator<Heroi> iterator = herois.listIterator();
		
		while (iterator.hasNext()) {
			
		String tipus1 = iterator.next().tipus;
		
		
			if(iterator.next().tipus.equals(iterator)) {
				
			}
		}
	}

}
