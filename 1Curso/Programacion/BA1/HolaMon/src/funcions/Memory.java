package funcions;

import java.util.Scanner;

public class Memory {

	static Scanner sc = new Scanner(System.in);
	static int sizetableroR = 0;
	static int sizetableroC = 0;
	static String jugador1 = null;
	static String jugador2 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menuprincipal();
		
	}

	private static void Menuprincipal() {
		// TODO Auto-generated method stub
		
		boolean salir = false;
		
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
				if(sizetableroR == 0 || sizetableroC == 0) {
					System.out.println("No has seleccionado correctamente el tamaño del tablero.");
					System.out.println("Ves al menu de configuracion para configurarlo");
				}else {
					Juego();
				}
			}else if(eleccion == 2) {
				Configuracion();
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

	private static void Configuracion() {
		// TODO Auto-generated method stub
		
	}

}
