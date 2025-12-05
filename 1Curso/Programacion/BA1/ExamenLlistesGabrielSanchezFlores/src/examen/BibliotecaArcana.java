package examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BibliotecaArcana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int nombre = sc.nextInt();
		
		sc.nextLine();
		
		ArrayList<String> criatures = new ArrayList<>();
		ArrayList<String> categoria = new ArrayList<>();
		
		for(int i = 0; i < nombre; i++) {
			criatures.add(sc.next());
			categoria.add(sc.next());
		}
		
		Collections.sort(categoria);
		
		String anterior = "";
		
		for(int e = 0; e < categoria.size(); e++) {
			String busca = categoria.get(e);
			int contador = 0;
			
			for(int j = 0; j < categoria.size(); j++) {
				
				if(categoria.get(j).contentEquals(busca)) {
					contador++;
				}
			}
			
			if(busca.equals(anterior)) {
				
			}else {
				System.out.println(busca + " " + contador);
			}
			anterior = busca;
		}
		
		for(String palabra : criatures) {
			System.out.print(palabra + " ");
		}

	}

}
