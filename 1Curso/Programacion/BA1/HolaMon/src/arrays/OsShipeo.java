package arrays;

import java.util.Scanner;

public class OsShipeo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			int nalumnes = sc.nextInt();
			
			int[] lista = new int[nalumnes];
			
			for(int e = 0; e < nalumnes; e++) {
				lista[e] = sc.nextInt();
			}
			
			// Bubble sort
			
			int canvi = 1;
			while (canvi != 0) {
				canvi = 0;
				for (int j = 0; j < lista.length; j++) {
					if (j != 0) {
						if (lista[j] < lista[j - 1] && lista[j]!=0) {
							int tmp = lista[j - 1];
							lista[j - 1] = lista[j];
							lista[j] = tmp;
							canvi++;
						}
					}
				}
			}
			
			int min = lista[0];
			int max = lista[nalumnes - 1];
			
			System.out.println(max - min);
			
			
		}

	}

}
