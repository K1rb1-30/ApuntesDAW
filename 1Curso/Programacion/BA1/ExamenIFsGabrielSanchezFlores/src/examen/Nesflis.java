package examen;

import java.util.Random;

public class Nesflis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random aleatori = new Random();
				
		int numAleatori = aleatori.nextInt(0,20);
		
		System.out.println(numAleatori);
		
		if(numAleatori != 0) {
			if(numAleatori < 14) {
				if(numAleatori < 9) {
					if(numAleatori < 6) {
						if(numAleatori < 1) {
							
						}else {
							System.out.println("ESTANDARD AMB ANUNCIS");
						}
					}else {
						System.out.println("BASIC");
					}
				}else {
					System.out.println("ESTANDARD");
				}
			}
			else{
				System.out.println("PREMIUM");
			}
		}else {
			System.out.println("NOTHING");
		}
		

	}

}
