package arrays;

import java.util.Scanner;

public class AnimalsJordina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			int nlineas = sc.nextInt();
			
			sc.nextLine();
			
			String[] lista = new String[nlineas-1];
			
			for(int e = 0; e < lista.length; e++) {
				lista[e] = sc.nextLine();
			}
			
			String buscar = sc.nextLine();
			boolean encontrado = false;
			for(int j = 0; j < lista.length; j++) {
				if(lista[j].equals(buscar)) {
					encontrado = true;
				}
			}
			
			if(encontrado) {
				System.out.println("SI");
			}else {
				System.out.println("NO");
			}
			
			
		}
			

	}

}
