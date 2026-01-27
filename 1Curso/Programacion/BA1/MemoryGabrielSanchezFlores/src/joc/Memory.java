package joc;

import java.util.ArrayList;
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
					Juego(j1, j2);
				}
			}else if(eleccion == 2) {
				Configuracion(j1, j2);
				
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

	private static void Juego(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		String[][] tableroMuestra = inicializarTablero();
		String[][] tableroReal = inicializarTableroReal();
		
		
		
	}

	private static String[][] inicializarTableroReal() {
		// TODO Auto-generated method stub
		int numParelles = (sizetableroX + sizetableroY)/2;
		
		ArrayList<String> fitxesA = new ArrayList<String>();
		ArrayList<String> fitxesB = new ArrayList<String>();
		
		
		
		return null;
	}

	private static String[][] inicializarTablero() {
		// TODO Auto-generated method stub
		String[][] tablero = new String[sizetableroX][sizetableroY];
		omplirTablero(tablero, "X");
		printarTablero(tablero);
		
		return tablero;
	}
	
	
	
	private static void printarTablero(String[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	private static void omplirTablero(String[][] mat, String dibujo) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = dibujo;
			}
		}

	}

	private static void Configuracion(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		
		boolean salir = false;
				
		while(!salir) {
			System.out.println("---------------------------------");
			System.out.println("----------Configuración----------");
			System.out.println("---------------------------------");
			System.out.println("---------Escull una opció--------");
			System.out.println();
			System.out.println(" 1. Configurar Jugadores");
			System.out.println(" 2. Configurar tablero");
			System.out.println(" 3. Salir de la configuración");
			System.out.println();
			System.out.println("---------------------------------");
			
			int eleccion = sc.nextInt();
			
			if(eleccion == 1) {
				boolean salirJug = false;
				
				while(!salirJug) {
					System.out.println("---------Elige un jugador a configurar--------");
					System.out.println();
					System.out.println(" 1. Configurar nombre Jugador 1");
					System.out.println(" 2. Configurar nombre Jugador 2");
					System.out.println(" 3. Volver a Configuración");
					System.out.println();
					System.out.println("---------------------------------");
					
					int eleccionJug = sc.nextInt();
						
					if(eleccionJug == 1) {
						System.out.print("Escribe el nombre del jugador 1: ");
						j1.nom = sc.next();
						System.out.println("El nombre del Jugador 1 es " + j1.nom);
					}else if(eleccionJug == 2) {
						System.out.print("Escribe el nombre del jugador 2: ");
						j2.nom = sc.next();
						System.out.println("El nombre del Jugador 2 es " + j2.nom);
					}else if(eleccionJug == 3){
						salirJug = true;
					}		
				}
				
			}else if(eleccion == 2) {
				
				boolean salirTablero = false;
				
				while(!salirTablero) {
					System.out.println("---------Elige el tamaño del tablero--------");
					if(sizetableroX != 0 && sizetableroY != 0) {
						System.out.println("Este es el tamaño de tablero actual:");
						inicializarTablero();
					}else {
						System.out.println("------------------ALERTA---------------------");
						System.out.println("Actualmente el tablero no tiene ningun tamaño");
						System.out.println("Configura sus filas y columnas para poder visualizarlo y jugar.");
						System.out.println("---------------------------------------------");
					}
					
					System.out.println(" 1. Configurar filas");
					System.out.println(" 2. Configurar Columnas");
					System.out.println(" 3. Volver a Configuración");
					System.out.println();
					System.out.println("---------------------------------");
					int eleccionTablero = sc.nextInt();
					
					if(eleccionTablero == 1) {
						System.out.print("Escribe las Filas (eje X) que quieres que tenga el tablero: ");
						sizetableroX = sc.nextInt();
						System.out.println("Las Filas del tablero se estableceran a " + sizetableroX);
					}else if(eleccionTablero == 2) {
						System.out.print("Escribe las Columnas (Eje Y) que quieres que tenga el tablero: ");
						sizetableroY = sc.nextInt();
						System.out.println("Las Columnas del tablero se estableceran a " + sizetableroY);
					}else if(eleccionTablero == 3){
						salirTablero = true;
					}
					
				}
				
			}else if(eleccion == 3) {
				System.out.println("SALIENDO DE LA CONFIGURACION GUARDANDO CAMBIOS ESPERA...");
				System.out.println("Se ha regresado al menu principal");
				salir = true;
				
			}
		}
		
		
		
		
		
		
		
		
	}

}


