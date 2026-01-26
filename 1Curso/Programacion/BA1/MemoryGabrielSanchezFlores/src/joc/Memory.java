package joc;

import java.util.Scanner;

public class Memory {

	static Scanner sc = new Scanner(System.in);
	static int sizetableroY = 0;
	static int sizetableroX = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menuprincipal();
		
	}

	private static void Menuprincipal() {
		// TODO Auto-generated method stub
		
		boolean salir = false;
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador();
		
		while(!salir) {
			System.out.println("---------------------------------");
			System.out.println("---Benvingut al Joc del Memory---");
			System.out.println("---------------------------------");
			System.out.println("---------Escull una opció--------");
			System.out.println();
			System.out.println(" 1. Jugar");
			System.out.println(" 2. Configuració");
			System.out.println(" 3. Victories");
			System.out.println(" 4. Salir");
			System.out.println();
			System.out.println("---------------------------------");
			
			int eleccion = sc.nextInt();
			
			if(eleccion == 1) {
				if(sizetableroY == 0 || sizetableroX == 0) {
					System.out.println("No has seleccionado correctamente el tamaño del tablero.");
					System.out.println("Ves al menu de configuracion para configurarlo");
				}else {
					Juego();
				}
			}else if(eleccion == 2) {
				Configuracion(j1, j2, sizetableroX, sizetableroY);
				
			}else if(eleccion == 3) {
				Victorias();
			}else if(eleccion == 4) {
				System.out.println("SACANDO CARTUCHO ESPERA...");
				System.out.println("La serie de partidas a finalizado.");
				salir = true;
				
			}
			
			
		}
		
		
	}

	private static void Victorias() {
		// TODO Auto-generated method stub
		
	}

	private static void Juego() {
		// TODO Auto-generated method stub
		
	}

	private static void Configuracion(Jugador j1, Jugador j2, int tableroX, int tableroY) {
		// TODO Auto-generated method stub
		
		System.out.println("---------------------------------");
		System.out.println("----------Configuració-----------");
		System.out.println("---------------------------------");
		System.out.println("---------Escull una opció--------");
		System.out.println();
		System.out.println(" 1. Jugar");
		System.out.println(" 2. Configuració");
		System.out.println(" 3. Victories");
		System.out.println(" 4. Salir");
		System.out.println();
		System.out.println("---------------------------------");
		
		
		
		
	}

}


