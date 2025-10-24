package examen;

import java.util.Scanner;

public class exercici1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int laura = 6;
		int david = 5;
		int jurado = 0;
		
		boolean acabado = false;
		boolean jordi = false;
		
		while(acabado == false) {
			
			String punto = sc.nextLine();
			
			if(punto.equals("LAURA")) {
				laura++;
				jurado++;
			}else if(punto.equals("DAVID")) {
				david++;
				jurado++;
			}else if(punto.equals("JORDI")) {
				jordi = true;
				jurado++;
			}
			
			if( laura >= 10 || david >= 10 || jurado == 5) {
				acabado = true;
			}
			
			
		}
		
		if(jordi == false) {
			if (laura > david) {
				System.out.println("GUANYA LAURA AMB " + laura + " PUNTS I HAN VALORAT " + jurado + " JUTGES");
			}else if(laura < david) {
				System.out.println("GUANYA DAVID AMB " + david + " PUNTS I HAN VALORAT " + jurado + " JUTGES");
			}else if(laura == david) {
				System.out.println("EMPAT");
			}
		}else {
			System.out.println("GUANYA JORDI PERQUÈ ÉS EL MILLOR MASTERCHEF");
		}
		
		
	}

}
