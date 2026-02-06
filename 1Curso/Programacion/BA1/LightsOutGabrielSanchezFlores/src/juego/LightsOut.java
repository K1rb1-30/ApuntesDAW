package juego;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Core.Board;
import Core.Window;
import juego.Jugador;
import juego.Posicio;

public class LightsOut {
	
	static Scanner sc = new Scanner(System.in);
	static int sizetableroY = 0;
	static int sizetableroX = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuprincipal();
	}

	private static void menuprincipal() {
		// TODO Auto-generated method stub
		boolean salir = false; //variable para salir del juego
		Jugador j1 = new Jugador(); // Creamos el objeto del j1 con la clase jugador
		
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
					jugar(j1); // Si has configurado todo puedes jugar
				}
			}else if(eleccion == 2) {
				Configuracion(j1); //Funcion de configuracion
				
			}else if(eleccion == 3) { // Salir del juego
				System.out.println("SACANDO CARTUCHO ESPERA..."); 
				System.out.println("La serie de partidas a finalizado.");
				salir = true;
				
			}
			
			
		}
	}

	private static void Victorias(Jugador j1) {
		// TODO Auto-generated method stub
		
	}

	private static void jugar(Jugador j1) {
		// TODO Auto-generated method stub
		
		boolean fi = false; // variable para ecir si el juego acaba
		int nMoviments=0; // variable para contar el numero de moviminetos
		int taulell[][] = new int[sizetableroY][sizetableroX]; //se crea el tablero
		
		InicialitzarTaulell(taulell); //iniciamos el tablero con esta funcion
		
//		 graphicMode(j1 , taulell);
		
		while(!fi) {
			mostrarTaulell(taulell); //printamos el tablero
			Posicio p = seleccionarPosicio(taulell); // la posicion elegida la indicamos con esta funcion
			canviarLlums(p,taulell); //con esta funcion se cambian las luces
			fi = comprovarVictoria(taulell); // comprovamos la victoria
			nMoviments++; //añadimos el movimiento que hemos hecho
		}
		
		System.out.println("El Juego a terminado, has ganado con " + nMoviments + " Movimiento/s" );
		
	}

//	private static void graphicMode(Jugador j1, int[][] taulell) {
//		
//		// TODO Auto-generated method stub
//		
//		Board b = new Board();
//		Window f = new Window(b);
//
//		System.out.println("Iniciando ventana");
//		int [] colors = { 0xF000000, 0xFFFFFF};
//		
//		b.setColors(colors);
//		
//
//		do {
//			
//			try {
//				Thread.sleep(50);  //donem una mica de retard per no colapsar el buffer del mouse.
//			} catch (InterruptedException e) {} 
//			
//			boolean fi = false;
//			int nMoviments = 0;
//			
//			b.draw(taulell, 'c');
//			
//			while(!fi) {
//				mostrarTaulell(taulell);
//				Posicio p = seleccionarPosicio(taulell, b);
//				canviarLlums(p,taulell);
//				fi = comprovarVictoria(taulell);
//				nMoviments++;
//			}
//			
//			int leftCol = b.getCurrentMouseCol();
//			int leftRow = b.getCurrentMouseRow();
//			if (leftCol != -1 && leftRow != -1) {
//				System.out.println("S'ha apretat el bot� esquerra en la fila " + leftRow + " columna " + leftCol);
//			}
//			int rightCol = b.getCurrentRightMouseCol();
//			int rightRow = b.getCurrentRightMouseRow();
//			if (rightCol != -1 && rightRow != -1) {
//				System.out.println("S'ha apretat el bot� dret la fila " + rightRow + " columna " + rightCol);
//			}
//			if (!f.getPressedKeys().isEmpty()) {
//				System.out.println("Tecles apretades "+f.getPressedKeys());
//			}
//			
//
//		} while (!f.getPressedKeys().contains('\n'));
//		System.out.println("l'ultima casella clickada es:  fila " + b.getMouseRow() + "   columna: " + b.getMouseCol());
//		System.out.println("l'ultima tecla premuda es:   " + f.getKeyPressed());
//		System.out.println("Aquesta es la llista de totes les tecles que tenies apretades al premer l'enter:   "
//				+ f.getPressedKeys());
//	}

	private static boolean comprovarVictoria(int[][] taulell) {
		// Comprueba que todo el tablero este a cero
		
		for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell[0].length; j++) {
				if(taulell[i][j] != 0) {
					return false; //si en algun momento encuentra alguna casilla que no este apagada retorna false
				}
			}
			System.out.println();
		}
		
		return true; //Si todo esta apagado retorna true
	}

	private static void canviarLlums(Posicio p, int[][] taulell) {
		// TODO Auto-generated method stub
		comprobarLados(p, taulell); // Esto comprueba los cuatro lados de la ficha
	}

	private static void comprobarLados(Posicio p, int[][] taulell) {
		//Con esta funcion puedes comprobar los 4 lados solo cambiando las entradas
		comprobarUno(p.x, p.y, taulell); //Mirar la casilla seleccionada
		comprobarUno(p.x, p.y + 1, taulell); //Mirar derecha
		comprobarUno(p.x, p.y - 1, taulell); //Mirar izquiera
		comprobarUno(p.x - 1, p.y, taulell); //Mirar arriba
		comprobarUno(p.x + 1, p.y, taulell); //Mirar abajo
	}

	private static void comprobarUno(int x, int y, int[][] taulell) {
		// TODO Auto-generated method stub
		if(noEsticFora(taulell, x, y) && taulell[x][y] == 0) { //Comprueba que no este fuera
			taulell[x][y] = 1;
		}else if(noEsticFora(taulell, x, y) && taulell[x][y] == 1) {
			taulell[x][y] = 0;
		}
		
	}

	private static Posicio seleccionarPosicio(int[][] taulell) {
		// TODO Auto-generated method stub
		boolean correcto1 = false; //esto hara de que si introduces algo incorrecto o un valor fuera de la matriz te vuelva a pedir
		
		int fila1 = 0;
		int columna1 = 0;
		
		Posicio p = new Posicio(); // Creamos un objecto posicion que contendra las coordenadas de la ficha
				
		while(!correcto1) {
			System.out.println("Selecciona una casillas por fila(x) y columna(y) (ej. 3 0): ");
			fila1 = sc.nextInt(); // coordenadas de fila
			columna1 = sc.nextInt(); // coordenadas de columna
			
			if(noEsticFora(taulell, fila1, columna1)) { // Si las coordenadas no son equivocas se hara esto
																							
				p.x = fila1; //ponemos las coordenadas de la fila dentro del objeto posiciones
				p.y = columna1; // igual pero con la columna
				correcto1 = true; //devolvera true para salir del bucle
			}else { //si seleccionas mal las coordenadas te mostrara este mensaje indicandote cuales son las permitidas y como se escribe el prompt
				System.out.println("ERROR al indicar la ficha recuerda que es del 0 - " + (taulell.length - 1) + " y primero van las filas y luego las columnas (ej 0 "+ (taulell.length - 2) + ")." );
			}
		}
		
		return p; //retorna el objecte
	}

	private static boolean noEsticFora(int[][] taulell, int fila1, int columna1) {
		// funcion para saber que las cordenadas no estan fuera del array y no de error

				if (fila1 < 0 || columna1 < 0 || fila1 > taulell.length - 1 || columna1 > taulell[0].length - 1) {
					return false;
				} else {

					return true;
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
		
//		ArrayList<Integer> casillas = new ArrayList<Integer>();
		
		Random r = new Random(); //inicializamos variable random
		for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell[0].length; j++) {
				 taulell[i][j] = r.nextInt(0,2);
			}
			System.out.println();
		}
		
//		seleccionEstado(taulell, casillas);
//		añadirEstadoTablero(taulell, casillas);
		
		
	}

//	private static void añadirEstadoTablero(int[][] taulell, ArrayList<Integer> casillas) {
//		// TODO Auto-generated method stub
//		
//		int contador = 0; // contador para añadir todas las fichas
//		
//		for (int i = 0; i < taulell.length; i++) { //Rellenamos la matriz con las fichas que antes hemos puesto
//			for (int j = 0; j < taulell[0].length; j++) {
//				taulell[i][j] = casillas.get(contador); //gracias al contador añadiremos cada casilla al tablero
//				contador++; //subimos el contador
//			}
//		}
//		
//	}
//
//	private static void seleccionEstado(int[][] taulell, ArrayList<Integer> casillas) {
//		// Seleccionar las casillas que estran encendidas y cuales no
//		
//		Random r = new Random(); //inicializamos variable random
//		
//		for(int i = 0;  i < taulell.length; i++) { // bucle para que añada o 1 o 0
//			casillas.add(r.nextInt(0,2)); //aleatoriamente añade 0 o 1
//		}
//		
//	}

	private static void Configuracion(Jugador j1) {
		// FUNCION del Apartado de CONFIGURACION
		
		boolean salir = false; // para salir del bucle cuando le demos al boton de salir
				
		while(!salir) {
			System.out.println("---------------------------------"); // Menu de configuracion
			System.out.println("----------Configuración----------");
			System.out.println("---------------------------------");
			System.out.println("---------Escull una opció--------");
			System.out.println();
			System.out.println(" 1. Configurar Jugadores");
			System.out.println(" 2. Configurar tablero");
			System.out.println(" 3. Salir de la configuración");
			System.out.println();
			System.out.println("---------------------------------");
			
			int eleccion = sc.nextInt(); // variable para elegir la config
			
			if(eleccion == 1) {	
				configurarJugadores(j1); //Funcion para configurar el nombre de los jugadores, le pasamos los jugadores
			}else if(eleccion == 2) {
				configurarTablero(); // Funcion para configurar el tamaño del tablero, le pasamos los jugadores
				
			}else if(eleccion == 3) { // Salir de la Config
				System.out.println("SALIENDO DE LA CONFIGURACION GUARDANDO CAMBIOS ESPERA...");
				System.out.println("Se ha regresado al menu principal");
				salir = true;
				
			}
		}
		
		
	}

	private static void configurarTablero() {
		// FUNCION para configurar tablero
		boolean salirTablero = false;
		
		while(!salirTablero) {
			System.out.println("---------Elige el tamaño del tablero--------");
			if(sizetableroX != 0 && sizetableroY != 0) { // si hemos seleccionado un tamaño valido se muestra el tablero
				System.out.println("Este es el tamaño de tablero actual:");
				int taulell[][] = new int[sizetableroY][sizetableroX];
				InicialitzarTaulell(taulell); //se inicializa el tablero de muestra con los tamaños indicados en las variables globales
				mostrarTaulell(taulell);
			}else { 
				// Sino se ha configurado el tamaño sale este mensaje
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
			
			if(eleccionTablero == 1) { // si seleccionamos configurar filas ponemos el tamaño de las filas
				System.out.print("Escribe las Filas (eje X) que quieres que tenga el tablero (Ha de ser un numero par): ");
				escribirTamaño("filas"); // funcion para configurar el tamaño si añadimos el nombre de filas configurara las filas
				
			}else if(eleccionTablero == 2) {
				System.out.print("Escribe las Columnas (Eje Y) que quieres que tenga el tablero: ");
				escribirTamaño("columnas"); // lo mismo pero configurara las columnas
				
			}else if(eleccionTablero == 3){ // salir de la config del tablero
				salirTablero = true;
			}
			
		}
	}

	private static void escribirTamaño(String tipo) {
		// TODO Auto-generated method stub
		
		boolean seleccionado = false; // esto es para si se ha seleccionado correctamente que salga del bucle
		
		while(!seleccionado) {
			int tamaño = sc.nextInt();
			boolean esPar = comprovarPar(tamaño); // Comprovamos si el numero puesto es par
			if(esPar) {
				if(tipo.equals("filas")) { // si es par y es filas se añadira a la variable global sizetableroX
					sizetableroX = tamaño;	
					System.out.println("Las Filas del tablero se estableceran a " + sizetableroX);
				}else if(tipo.equals("columnas")) { // si es par  y has seleccionado columnas se añadira a sizetableroY
					sizetableroY = tamaño;	
					System.out.println("Las columnas del tablero se estableceran a " + sizetableroY);
				}
				
				seleccionado = true;
			}else {
				System.out.println("Selecciona un numero PAR: "); // si no se selecciona un numero par se repetira
			}
		}
	}

	private static boolean comprovarPar(int tamaño) {
		// FUNCION para comprovar si el numero es par
		if(tamaño%2 == 0) { // si es par retorna true
			return true;
		}else { //sino false
			return false;
		}
		
	}

	private static void configurarJugadores(Jugador j1) {
		// FUNCION para configurar jugadores
		boolean salirJug = false;
		
		while(!salirJug) {
			System.out.println("---------Elige un jugador a configurar--------"); // Menu config jugadores
			System.out.println();
			System.out.println(" 1. Configurar nombre Jugador 1");
			System.out.println(" 2. Volver a Configuración");
			System.out.println();
			System.out.println("---------------------------------");
			
			int eleccionJug = sc.nextInt();
				sc.nextLine();// arreglo de bug para que se pongan bien los jugadores
				
			if(eleccionJug == 1) {
				System.out.print("Escribe el nombre del jugador 1: ");
				j1.nombre = sc.nextLine(); // escribimos el nombre del jugador 1
				System.out.println("El nombre del Jugador 1 es " + j1.nombre);
			}else if(eleccionJug == 2){
				salirJug = true; // esto es para salir del menu del jugador
			}
			
		}
	}
	
}
