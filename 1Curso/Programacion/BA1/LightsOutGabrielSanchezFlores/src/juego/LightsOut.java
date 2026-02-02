package juego;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import juego.Jugador;

public class LightsOut {
	
	static Scanner sc = new Scanner(System.in);
	static int sizetableroY;
	static int sizetableroX;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuprincipal();
	}

	private static void menuprincipal() {
		// TODO Auto-generated method stub
		boolean salir = false; //variable para salir del juego
		Jugador j1 = new Jugador(); // Creamos el objeto del j1 con la clase jugador
		
		int taulell[][] = new int[sizetableroY][sizetableroX];
		
		while(!salir) {
			System.out.println("---------------------------------");     //Aspecto del menu principal
			System.out.println("-----Bienvenido a LightsOut------");
			System.out.println("---------------------------------");
			System.out.println("---------Escoge una opción-------");
			System.out.println();
			System.out.println(" 1. Jugar");
			System.out.println(" 2. Configuración");
			System.out.println(" 3. Salir");
			System.out.println();
			System.out.println("---------------------------------");
			
			
			int eleccion = sc.nextInt();
			
			if(eleccion == 1) { // Si eliges jugar y no has configurado todavia el tablero ni los jugadores te sale este mensaje y no puedes jugar
				if( (sizetableroY == 0 || sizetableroX == 0) || (j1.nombre == null)) {
					System.out.println("No has seleccionado correctamente el tamaño del tablero");
					System.out.println("o no has escrito los nombres de los jugadores");
					System.out.println("Ves al menu de configuración para configurarlos");
				}else {
					jugar(taulell, j1); // Si has configurado todo puedes jugar
				}
			}else if(eleccion == 2) {
				Configuracion(j1); //Funcion de configuracion
				
			}else if(eleccion == 3) {
				Victorias(j1); //Funcion de RANKING de victorias.
			}else if(eleccion == 4) { // Salir del juego
				System.out.println("SACANDO CARTUCHO ESPERA..."); 
				System.out.println("La serie de partidas a finalizado.");
				salir = true;
				
			}
			
			
		}
	}

	private static void Victorias(Jugador j1) {
		// TODO Auto-generated method stub
		
	}

	private static void Configuracion(Jugador j1) {
		// TODO Auto-generated method stub
		
	}

	private static void jugar(int[][] taulell, Jugador j1) {
		// TODO Auto-generated method stub
		
		boolean fi = false;
		int nMoviments=0;
		
		InicialitzarTaulell(taulell);
		
		while(!fi) {
			mostrarTaulell(taulell);
			Posicio p = seleccionarPosicio();
			canviarLlums(p,taulell);
			fi = comprovarVictoria(taulell);
			nMoviments++;
		}
		
	}

	private static void mostrarTaulell(int[][] taulell) {
		// TODO Auto-generated method stub
		//Con esta funcion imprimimos el Tablero
				for (int i = 0; i < taulell.length; i++) {
					for (int j = 0; j < taulell[0].length; j++) {
						System.out.print(" " + taulell[i][j] + " ");
					}
					System.out.println();
				}
	}

	private static void InicialitzarTaulell(int[][] taulell) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> casillas = new ArrayList<Integer>();
		
		seleccionEstado(taulell, casillas);
		añadirEstadoTablero(taulell, casillas);
		
		
	}

	private static void añadirEstadoTablero(int[][] taulell, ArrayList<Integer> casillas) {
		// TODO Auto-generated method stub
		
		int contador = 0; // contador para añadir todas las fichas
		
		for (int i = 0; i < taulell.length; i++) { //Rellenamos la matriz con las fichas que antes hemos puesto
			for (int j = 0; j < taulell[0].length; j++) {
				taulell[i][j] = casillas.get(contador); //gracias al contador añadiremos cada casilla al tablero
				contador++; //subimos el contador
			}
		}
		
	}

	private static void seleccionEstado(int[][] taulell, ArrayList<Integer> casillas) {
		// Seleccionar las casillas que estran encendidas y cuales no
		
		Random r = new Random();
		
		for(int i = 0;  i < taulell.length; i++) { // bucle para que añada o 1 o 0
			casillas.add(r.nextInt(0,2)); //aleatoriamente añade 0 o 1
		}
		
	}

	
	
}
