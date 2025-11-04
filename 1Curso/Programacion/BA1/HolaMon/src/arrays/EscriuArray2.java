package arrays;

import java.util.Scanner;

public class EscriuArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		sc.nextLine();
		
		String [] lista = new String[casos];
		
		for(int i = 0; i < casos; i++) {
				
				lista[i] = sc.nextLine();
				
			}
			
		int posicion = sc.nextInt();
		
		for(int b = 0; b < lista.length; b++) {
			System.out.println(lista[b]);
	
		}
		
		for(int h = 0; h < lista.length; h++) {
			if(h == posicion) {
				System.out.println(lista[h]);
			}
		}

}
}
