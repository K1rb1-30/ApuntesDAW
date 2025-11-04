package arrays;

import java.util.Scanner;

public class ComptarArrays {

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
			
			int posicion = sc.nextInt();
			int contador = 0;
			
			for(int b = 0; b < lista.length; b++) {
				
				if(lista[b] == posicion) {
					contador++;
				}
		
			}
			
			System.out.println(contador);
			
			
		}

	}

}
