package arrays;

import java.util.Scanner;

public class EleccionsPatates {

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
			
			int maximo = lista[0];
			
			for(int j = 0; j < lista.length; j++) {
				
				if(lista[j] > maximo) {
					maximo = lista[j];
				}
			}
			
			for(int b = 0; b < lista.length; b++) {
				if (lista[b] == maximo) {
					System.out.println(b + 1);
				}
			}
			
			
		}
		

	}

}
