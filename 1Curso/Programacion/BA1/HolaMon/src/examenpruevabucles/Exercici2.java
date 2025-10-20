package examenpruevabucles;

import java.util.Scanner;


public class Exercici2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int puntosalcaraz = 7;
		int puntosdjokovic = 6;
		
		boolean acabado = false;
		
		while(acabado == false) {
			
			String punto = sc.nextLine();
			
			if(punto.equals("ALCARAZ")) {
				puntosalcaraz++;
			}else if(punto.equals("DJOKOVIC")) {
				puntosdjokovic++;
			}
			
			if( puntosalcaraz >= 10 && puntosalcaraz - puntosdjokovic >= 2 
				|| puntosdjokovic >= 10 && puntosdjokovic - puntosalcaraz >= 2 ) {
				acabado = true;
			}
			
			
		}
		if (puntosalcaraz > puntosdjokovic) {
			System.out.println("GUANYA ALCARAZ");
		}else if(puntosalcaraz < puntosdjokovic) {
			System.out.println("GUANYA DJOKOVIC");
		}

	}

}
