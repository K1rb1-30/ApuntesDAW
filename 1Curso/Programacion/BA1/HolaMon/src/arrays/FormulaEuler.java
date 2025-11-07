package arrays;

import java.util.Scanner;

public class FormulaEuler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			
			int opcions = sc.nextInt();
			
			int [] lista = new int[opcions];
			
			for(int e = 0; e < opcions; e++) {
				
				int vots = sc.nextInt();
				
				lista[e] = vots;
				
			}
			
			// BUBBLE SORT ALGORITMO
			
			boolean noswap = false;
			
			while(!noswap) {
				
				for(int a = 0; a < lista.length; a++) {
					if(a+1 < lista.length) {
						if(lista[a] > lista[a+1]) {
							int primero = lista[a];
							int segundo = lista[a+1];
							
							lista[a] = segundo;
							lista[a+1] = primero;
							noswap = false;
						}else {
							noswap = true;
						}
					}
					
				}
				
			}
			
			// Comparar minimo con max
			
			int max = lista.length - 1;
			
			for(int min = 0; min < lista.length/2; min++) {
				int resultat = lista[min] + lista[max];
				System.out.println(resultat);
				max--;
				
			}
			
			

		}
	}
}
