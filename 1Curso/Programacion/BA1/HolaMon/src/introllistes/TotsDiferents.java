package introllistes;

import java.util.ArrayList;
import java.util.Scanner;

public class TotsDiferents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int a = 0; a < casos; a++) {
			
			int capacidad = sc.nextInt();
			
			ArrayList<Integer> primeralista = new ArrayList<>();
			ArrayList<Integer> segundalista = new ArrayList<>();
			
			for(int e = 0; e < capacidad; e++) {
				primeralista.add(sc.nextInt());
			}
			
			for(int i = 0; i < capacidad; i++) {
				segundalista.add(sc.nextInt());
			}
			
			boolean repepe = false;
			
			for(int primero = 0; primero < primeralista.size(); primero++) {
				if(segundalista.get(primero) == primeralista.get(primero)) {
					
					repepe = true;
					
				}
			}
			
			if(repepe) {
				System.out.println("NO");
			}else {
				System.out.println("SI");
			}
			
		}
		
	}

}
