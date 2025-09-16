package joel;

import java.util.Scanner;

public class PedraPaperTisora {

	public static void main(String[] args) {
		
		int jugador1;
		int jugador2;
		
		Scanner sc = new Scanner(System.in);
		
		jugador1 = sc.nextInt(); // declarem i donem valor a la variable frase llegint un string amb el nextLine des de teclat
		
		sc.nextLine();
	
		jugador2 = sc.nextInt(); // declarem i donem valor a la variable frase llegint un string amb el nextLine des de teclat
		
		
		if(jugador1 <1 || jugador1 >3 || jugador2 <1 || jugador2 >3) {
			System.out.println("ERROR");
		} else {
			if(jugador1 == 1 && jugador2 == 3 ) {
				System.out.println("Jugador1");
			}
			else if(jugador1 == 2 && jugador2 == 1 ) {
				System.out.println("Jugador1");
			}
			else if(jugador1 == 3 && jugador2 == 2 ) {
				System.out.println("Jugador1");
			}
			else if(jugador2 == 1 && jugador1 == 3 ) {
				System.out.println("Jugador2");
			}
			else if(jugador2 == 2 && jugador1 == 1 ) {
				System.out.println("Jugador2");
			}
			else if(jugador2 == 3 && jugador1 == 2 ) {
				System.out.println("Jugador2");
			}
			else if(jugador2 == jugador1 ) {
				System.out.println("EMPAT");
			}
		}
		
		sc.close();
	}

}
