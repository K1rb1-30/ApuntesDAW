package exercicis;


import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TasquesAmbPrioritat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			int tasques = sc.nextInt();
			
			int lloc = sc.nextInt();
			
			sc.nextLine();
			
			PriorityQueue<String> pq = new PriorityQueue<>(new MeuComparador());
			
			for (int j = 0; j < tasques; j++) {
				String nom = sc.nextLine();
				pq.add(nom);
			}
			
			for (int e = 0; e < lloc - 1; e++) {
				pq.poll();
			}
			
			String[] ls = pq.poll().split(" ");
			
			String sitio = "";
			for (int j = 1; j < ls.length; j++) {
				sitio += ls[j] +" ";
			}
			
			System.out.println(sitio);
		}
		
	}
	

}

class MeuComparador implements Comparator<String> {

	// recordem que torna un nombre negatiu si el 1r nombre és més petit que el 2n
	// torna 0 si són iguals
	// torna un nombre positiu si el 1r és més gran que el 2n

//	public int compare(Integer o1, Integer o2) {
//
//		return o2 - o1; // canviem l'ordre de la resta del return (en comptes de o1 - o2)
//	}

	@Override
	public int compare(String o1, String o2) {
		String[] lista1 = o1.split(" ");
		String[] lista2 = o2.split(" ");
		// TODO Auto-generated method stub
		return Integer.parseInt(lista1[0]) - Integer.parseInt(lista2[0]);
	}
}
