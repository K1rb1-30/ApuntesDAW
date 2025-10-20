package examenpruevabucles;

import java.util.Scanner;

public class Exercici3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean sortir = false;
		String palabra = "";
		
		while(sortir == false) {
			
			System.out.println("1. Introduir una frase o paraula en MAJÚSCULES.");
			System.out.println("2. Modificar la frase introduïda tot afegint més paraules.");
			System.out.println("3. Eliminarem la frase introduïda.");
			System.out.println("4. Nombre de canvis en xifrar.");
			System.out.println("5. Sortir");
			
			int decision = sc.nextInt();
			sc.nextLine();
			
			if(decision == 1) {
				palabra = sc.nextLine();
			}else if(decision == 2) {
				palabra += sc.nextLine();
			}else if(decision == 3) {
				palabra = "";
			}else if(decision == 4) {
				if(palabra.equals("")){
					System.out.println("BUIDA");
				}else {
					
				}
			}else if(decision == 5) {
				sortir = true;
			}
			
			System.out.println(palabra);
			
		}

	}

}
