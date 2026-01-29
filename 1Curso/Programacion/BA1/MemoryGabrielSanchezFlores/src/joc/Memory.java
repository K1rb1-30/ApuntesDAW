package joc;

import java.util.ArrayList;
import java.util.Arrays;
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
				Victorias(j1, j2);
			}else if(eleccion == 4) {
				System.out.println("SACANDO CARTUCHO ESPERA...");
				System.out.println("La serie de partidas a finalizado.");
				salir = true;
				
			}
			
			
		}
		
		
	}

	private static void Victorias(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		
		sc.nextLine(); // esto es el bug para que no se salga automaticamente
		String salir = null;
		
		while(salir == null) {
			System.out.println("////////////////////////////");
			System.out.println("----RANKING DE VICTORIAS----");
			System.out.println();
			comprovarTop(j1, j2);
			System.out.println();
			System.out.println("////////////////////////////");
			
			System.out.print("Presiona cualquier tecla para salir del RANKING: ");
			salir = sc.nextLine();
			System.out.println();
		}
		
	}

	private static void comprovarTop(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		if(j1.nVictories > j2.nVictories) {
			System.out.println("- 1º " + j1.nom + " nºVictorias " + j1.nVictories);
			System.out.println();
			System.out.println("- 2º " + j2.nom + " nºVictorias " + j2.nVictories);
		}else if(j1.nVictories < j2.nVictories) {
			System.out.println("- 1º " + j2.nom + " nºVictorias " + j2.nVictories);
			System.out.println();
			System.out.println("- 2º " + j1.nom + " nºVictorias " + j1.nVictories);
		}else if(j1.nVictories == j2.nVictories) {
			System.out.println("- EMPATE " + j2.nom + " nºVictorias " + j2.nVictories);
			System.out.println();
			System.out.println("- EMPATE " + j1.nom + " nºVictorias " + j1.nVictories);
		}
	}

	private static void Juego(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		
		String[][] tableroMuestra = inicializarTablero(); //Primero inicializamos el tablero que se mostrara
		String[][] tableroReal = inicializarTableroReal(); // Luego iniciamos el tablero real que sera con el que haremos las comprobaciones
		
		boolean juegoAcabado = false; //Esto es para que se repita el bucle de juego hasta que alguien gane
		Random r = new Random(); // Esto lo usaremos para ver que jugador empieza primero (alomejor se escala a un cara o cruz donde esto es la parte de la moneda que toca)
		int turno = r.nextInt(1,3); //El juego elige aleatoriamente quien empieza siendo 1 el j1 y 2 el j2 (esto de momento a no ser que se haga lo de la moneda)
		
		while(!juegoAcabado) {
			printarTablero(tableroMuestra);
			
			if(turno == 1) {
				System.out.println("Turno del jugador 1: " + j1.nom);
				boolean acierto = seleccionDeFitxas(tableroMuestra, tableroReal);
				if(acierto) {
					System.out.println(j1.nom + " has ganado 1 punto");
					j1.nPunts++; // Por cada acierto se suma un punto a las estadisticas del jugador
					System.out.println("Tienes " + j1.nPunts);
				}else {
					turno = 2; 
				}
				
				
			}else if(turno == 2) {
				System.out.println("Turno del jugador 2: " + j2.nom);
				boolean acierto = seleccionDeFitxas(tableroMuestra, tableroReal);
				if(acierto) {
					j2.nPunts++;
				}else {
					turno = 1;
				}
			}
			
			juegoAcabado = comprovarAcabado(tableroMuestra, tableroReal); // Una vez uno de los dos acierta se comprueba con esta funcion si se ha acabado el juego es decir que no quedan mas fichas por levantar
		}
		
		comprovarGanador(j1, j2); //Si el juego acaba se comprueba quien ha ganado
		
		System.out.println();
		System.out.println("Gracias por jugar.");
		
		
	}

	private static void comprovarGanador(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		String nombreganador = ""; //Esto para mostrar el nombre del ganador cuando se acabe la partida
		boolean empate = false;
		
		if(j1.nPunts > j2.nPunts) { // comprovamos si el jugador1 tiene mas puntos
			nombreganador = j1.nom; // Si es asi el nombre del ganador sera el del j1
			j1.nVictories++; 
		}else if(j1.nPunts < j2.nPunts) { //Hacemos lo mismo pero con el j2
			nombreganador = j2.nom; 
			j2.nVictories++;
		}else if(j1.nPunts == j2.nPunts) { //En caso de empate ningun jugador ganara puntos
			empate = true;
		}
		
		if(empate) {
			System.out.println("////////////////////////////////");
			System.out.println("HA HABIDO UN EMPATE");
			System.out.println("Ningun jugador obtendra puntos de Victoria.");
			System.out.println("////////////////////////////////");
		}else {
			System.out.println("////////////////////////////////");
			System.out.println("EL GANADOR ES: " + nombreganador);
			System.out.println("////////////////////////////////");
		}
		System.out.println();
	}

	private static boolean comprovarAcabado(String[][] tableroMuestra, String[][] tableroReal) {
		// TODO Auto-generated method stub
		if(Arrays.deepEquals(tableroMuestra, tableroReal)) { //Gracias a Arrays.deepEquals comprobamos si las matrices son exactamente iguales
			System.out.println();
			System.out.println("YA NO QUEDAN MAS FICHAS POR DESCUBRIR");
			System.out.println();
			return true; // si es asi devolvemos un true y sino false
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
		
//		printarTablero(tableroReal); // Quitar esto depues
		
		return tableroReal;
	}

	private static String[][] inicializarTablero() {
		// TODO Auto-generated method stub
		String[][] tablero = new String[sizetableroX][sizetableroY];
		omplirTablero(tablero, "X");
//		printarTablero(tablero); // Quitar esto depues
		
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
				configurarJugadores(j1, j2);
			}else if(eleccion == 2) {
				configurarTablero(j1, j2);
				
			}else if(eleccion == 3) {
				System.out.println("SALIENDO DE LA CONFIGURACION GUARDANDO CAMBIOS ESPERA...");
				System.out.println("Se ha regresado al menu principal");
				salir = true;
				
			}
		}
		
		
	}

	private static void configurarTablero(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		boolean salirTablero = false;
		
		while(!salirTablero) {
			System.out.println("---------Elige el tamaño del tablero--------");
			if(sizetableroX != 0 && sizetableroY != 0) { // si hemos seleccionado un tamaño valido se muestra el tablero
				System.out.println("Este es el tamaño de tablero actual:");
				String[][] tableromuestra = inicializarTablero(); //se inicializa el tablero de muestra con los tamaños indicados en las variables globales
				printarTablero(tableromuestra);
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
	}

	private static void configurarJugadores(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
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
				sc.nextLine();// arreglo de bug para que se pongan bien los jugadores
				
			if(eleccionJug == 1) {
				System.out.print("Escribe el nombre del jugador 1: ");
				j1.nom = sc.nextLine(); // escribimos el nombre del jugador 1
				System.out.println("El nombre del Jugador 1 es " + j1.nom);
			}else if(eleccionJug == 2) {
				System.out.print("Escribe el nombre del jugador 2: ");
				j2.nom = sc.next(); // escribimos el nombre del jugador 2
				System.out.println("El nombre del Jugador 2 es " + j2.nom);
			}else if(eleccionJug == 3){
				salirJug = true; // esto es para salir del menu del jugador
			}
			
		}
	}

}


