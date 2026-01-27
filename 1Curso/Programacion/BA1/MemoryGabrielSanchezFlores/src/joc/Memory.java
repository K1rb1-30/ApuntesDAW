package joc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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
		
		String[][] tableroMuestra = inicializarTablero(); //Primero inicializamos el tablero que se mostrara
		String[][] tableroReal = inicializarTableroReal(); // Luego iniciamos el tablero real que sera con el que haremos las comprobaciones
		
		boolean ganador = false; //Esto es para que se repita el bucle de juego hasta que alguien gane
		String nombreganador = " ";
		Random r = new Random();
		int turno = r.nextInt(1,3); //El juego elige aleatoriamente quien empieza siendo 1 el j1 y 2 el j2
		
		while(!ganador) {
			printarTablero(tableroMuestra);
			
			if(turno == 1) {
				System.out.println("Turno del jugador 1 " + j1.nom);
				boolean acierto = seleccionDeFitxas(tableroMuestra, tableroReal);
				if(acierto) {
					ganador = comprovarGanador(tableroMuestra, tableroReal);
					if(ganador == true) {
						nombreganador = j1.nom;
					}
				}else {
					turno = 2;
				}
				
				
			}else if(turno == 2) {
				System.out.println("Turno del jugador 2 " + j2.nom);
				boolean acierto = seleccionDeFitxas(tableroMuestra, tableroReal);
				if(acierto) {
					ganador = comprovarGanador(tableroMuestra, tableroReal);
					if(ganador == true) {
						nombreganador = j2.nom;
					}
				}else {
					turno = 1;
				}
			}
		}
		
		
		
		
		
		
	}

	private static boolean comprovarGanador(String[][] tableroMuestra, String[][] tableroReal) {
		// TODO Auto-generated method stub
		if(tableroMuestra.equals(tableroReal)) {
			return true;
		}else {
			return false;
		}
		
	}

	private static boolean seleccionDeFitxas(String[][] tableroMuestra, String[][] tableroReal) {
		// TODO Auto-generated method stub
		
		int[] primeraficha = pedirPosicion(tableroMuestra, tableroReal);
		
		printarTablero(tableroMuestra);
				
		System.out.println();
		
		int[] segundaficha = pedirPosicion(tableroMuestra, tableroReal);
		
		printarTablero(tableroMuestra);
		
		boolean acierto = compararIgualdad(primeraficha, segundaficha, tableroMuestra, tableroReal);
		
		return acierto;
	}

	private static boolean compararIgualdad(int[] primeraficha, int[] segundaficha, String[][] tableroMuestra,
			String[][] tableroReal) {
		// TODO Auto-generated method stub
		
		if(tableroReal[primeraficha[0]][primeraficha[1]].equals(tableroReal[segundaficha[0]][segundaficha[1]])) {
			System.out.println("Has acertado");
			return true;
		}else {
			System.out.println("Has Fallado");
			tableroMuestra[primeraficha[0]][primeraficha[1]] = "X";
			tableroMuestra[segundaficha[0]][segundaficha[1]] = "X";
			return false;
		}
		
	}

	private static int[] pedirPosicion(String[][] tableroMuestra, String[][] tableroReal) {
		// TODO Auto-generated method stub
		boolean correcto1 = false; //esto hara de que si introduces algo incorrecto como una ficha que ya esta destapada o un valor fuera de la matriz te vuelva a pedir
		
		int fila1 = 0;
		int columna1 = 0;
		
		int[]posiciones = new int[2];
				
		while(!correcto1) {
			System.out.println("Selecciona una ficha por fila(x) y columna(y) (ej. 3 0): ");
			fila1 = sc.nextInt();
			columna1 = sc.nextInt();
			
			if(noEsticFora(tableroReal, fila1, columna1) && tableroMuestra[fila1][columna1].equals("X") ) {
				tableroMuestra[fila1][columna1] = tableroReal[fila1][columna1];
				correcto1 = true;
			}else {
				System.out.println("ERROR al indicar la ficha recuerda que es del 0 - " + (tableroMuestra.length - 1) + " y primero van las filas y luego las columnas (ej 0 "+ (tableroMuestra.length - 2) + ")." );
			}
		}
		
		posiciones[0] = fila1;
		posiciones[1] = columna1;
		
		return posiciones;
	}

	private static boolean noEsticFora(String[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return false;
		} else {

			return true;
		}
	}

	private static String[][] inicializarTableroReal() {
		// TODO Auto-generated method stub
		int numParelles = (sizetableroX * sizetableroY)/2;
		
		String[][] tableroReal = new String[sizetableroX][sizetableroY];
		
		ArrayList<String> fitxes = new ArrayList<String>();
		
		for(int i = 1;  i <= numParelles; i++) {
			fitxes.add(Integer.toString(i));
		}
		
		for(int i = 1;  i <= numParelles; i++) {
			fitxes.add(Integer.toString(i));
		}
		
//		System.out.println(fitxes);
		Collections.shuffle(fitxes);
//		System.out.println(fitxes);
		
		int contador = 0;
		
		for (int i = 0; i < tableroReal.length; i++) {
			for (int j = 0; j < tableroReal[0].length; j++) {
				tableroReal[i][j] = fitxes.get(contador);
				contador++;
			}
		}
		
		printarTablero(tableroReal); // Quitar esto depues
		
		return tableroReal;
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
				System.out.print(" " + mat[i][j] + " ");
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


