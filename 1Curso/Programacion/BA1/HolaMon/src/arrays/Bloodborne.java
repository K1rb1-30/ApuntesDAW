package arrays;

import java.util.Scanner;

public class Bloodborne {

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
			
			int repe = 0;
			boolean seguio = false;
			
			for(int a = 0; a < lista.length; a++) {
				if(lista[a] == repe) {
					seguio = true;
				}else {
					repe = lista[a];
				}
			}
			
			if(seguio) {
				System.out.println("SI");
			}else {
				System.out.println("NO");
			}
			
			
		}

	}

}
