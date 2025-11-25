package introllistes;

import java.util.ArrayList;
import java.util.Scanner;

public class Unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int a = 0; a < casos; a++) {
			
			int capacidad = sc.nextInt();
			
			sc.nextLine();
			
			ArrayList<String> lista = new ArrayList<>();
			
			for(int e = 0; e < capacidad; e++) {
				
				String palabra = sc.nextLine();
				
				if(lista.contains(palabra)) {
					
				}else {
					lista.add(palabra);
				}
			}
			
			System.out.println(lista);
			
		}
	}

}
