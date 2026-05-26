package examen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heroi heroi1 = new Heroi("Arthas", "Guerrer", 120, 35, "Aliats", Nivell.NOVELL);
		Heroi heroi2 = new Heroi("Sylvanas", "Guerrer", 90, 55, "Horda", Nivell.VETERA);
		Heroi heroi3 = new Heroi("Merlin", "Mag", 80, 50, "Aliats", Nivell.LLEGENDARI);
		Heroi heroi4 = new Heroi("Thrall", "Mag", 110, 30, "Horda", Nivell.VETERA);
		Heroi heroi5 = new Heroi("Luna1", "Assassina", 70, 45, "Neutral", Nivell.LLEGENDARI);
		Heroi heroi6 = new Heroi("Luna2", "Assassina", 70, 45, "Neutral", Nivell.LLEGENDARI);
		
		ArrayList<Heroi> llistaH = new ArrayList<Heroi>();
		
		llistaH.add(heroi1);
		llistaH.add(heroi2);
		llistaH.add(heroi3);
		llistaH.add(heroi4);
		llistaH.add(heroi5);
		llistaH.add(heroi6);
		
		NetejaConsecutius(llistaH);
		
		System.out.println(llistaH);
		
	}
	
	public static void NetejaConsecutius(List<Heroi> herois) {
		ListIterator<Heroi> iterator = herois.listIterator();
		
		Heroi anterior = iterator.next();
		
		while (iterator.hasNext()) {
			
			Heroi actual = iterator.next();
			
			if(actual.tipus.equals(anterior.tipus)) {
				if(actual.atac < anterior.atac) {
					iterator.remove();
					System.out.println("Se ha eliminado el actual");
				}else if(actual.atac > anterior.atac) {
					iterator.previous();
					iterator.previous();
					iterator.remove(); //preguntar si esta bien
					System.out.println("Se ha eliminado el anterior");
					iterator.next();
				}else if(actual.atac == anterior.atac) {
					iterator.remove();
					System.out.println("Se ha eliminado el segundo porque eran iguales");
				}
			}
			
			anterior = actual;
		}
		
		System.out.println("Se a acabado de limpiar");
	}

}
