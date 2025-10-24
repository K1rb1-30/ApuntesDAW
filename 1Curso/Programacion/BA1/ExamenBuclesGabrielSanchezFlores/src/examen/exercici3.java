package examen;

import java.util.Scanner;

public class exercici3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String palabra = sc.nextLine();
		int contador = 0;
		char palabraant = palabra.charAt(0);
		int posicion = 0;
		
		boolean error = false;
		
		
		for(int i = 0; i < palabra.length(); i++) {
			
			char c = palabra.charAt(i);
			if(c == palabraant ) {
				contador ++;
				posicion = i-1;
			}else {
				palabraant = c;
			}
			
			if(contador == 3) {
				error = true;
			}
			
		}
		
		if(error) {
			System.out.println(contador + " repeticions de " + palabraant +" a posicio" + posicion);
		}else {
			System.out.println("NO HI HA REPETICIONS SOSPITOSES");
		}
	}

}
