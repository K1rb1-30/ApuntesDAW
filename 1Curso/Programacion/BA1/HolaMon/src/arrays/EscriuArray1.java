package arrays;

import java.util.Scanner;

public class EscriuArray1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		int [] lista = new int[casos];
		
		for(int i = 0; i < casos; i++) {
			lista[i] = sc.nextInt();
		}
		
		int posicion = sc.nextInt();
		
		for (int e = 0; e < lista.length; e++) {
			System.out.print(lista[e] + " ");
			
		}
		System.out.println();
		
		System.out.println(lista[posicion]);
			
		
		

	}

}
