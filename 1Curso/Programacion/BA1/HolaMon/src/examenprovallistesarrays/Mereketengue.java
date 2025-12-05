package examenprovallistesarrays;

import java.util.Scanner;

public class Mereketengue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String frase = sc.nextLine();
		
		String[] lista = frase.split(" ");
		
		for(int i = 0; i < lista.length; i++) {
			String palabrarev = lista[i];
			boolean primero = true;
			
			for(int e = 0; e < lista.length; e++) {
		
				if(!primero) {
					if(lista[e].equals(palabrarev)) {
						lista[e] = " ";
					}
				}else {
					if(lista[e].equals(palabrarev)) {
						primero = false;
					}
				}
				
			}
			
		}
		
		boolean mere = false;
		boolean salsa = false;
		
		for (String paraula : lista) {
			if(paraula.equals("Mereketengue")) {
				mere = true;
			}else if(paraula.equals("Salsa")) {
				salsa = true;
			}
		}
		
		
		for (int r = 0; r < lista.length; r++) {
			
			if(lista[r].equals(" ")) {
				
			}else {
				System.out.print(lista[r] + " ");
			}
			
		}
		
		System.out.println();
		
		if(mere && salsa) {
			System.out.println("Mereketengue i Salsa");
		}else if(mere) {
			System.out.println("Mereketengue");
		}else if(salsa) {
			System.out.println("Salsa");
		}else {
			System.out.println("Cap");
		}
		
		
	}

}
