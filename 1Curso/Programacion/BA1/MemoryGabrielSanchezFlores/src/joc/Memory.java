package joc;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Memory {

	//Apartado de variables globales
	
	static Scanner sc = new Scanner(System.in);  //Scanner global para poder usarlo en todas las funciones
	static int sizetableroY = 0; //tamaño del tablero verticalmente (eje Y)
	static int sizetableroX = 0; //tamaño del tablero horizontalmente (eje X)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menuprincipal(); //Funcion del menu principal del juego
		
	}

	private static void Menuprincipal() {
		// TODO Auto-generated method stub
		
		boolean salir = false; //variable para salir del juego
		Jugador j1 = new Jugador(); // Creamos el objeto del j1 con la clase jugador
		Jugador j2 = new Jugador(); // Creamos el objeto del j2 con la clase jugador
		
		while(!salir) {
			System.out.println("---------------------------------");     //Aspecto del menu principal
			System.out.println("--Bienvenido al Juego del Memory-");
			System.out.println("---------------------------------");
			System.out.println("---------Escoge una opción-------");
			System.out.println();
			System.out.println(" 1. Jugar");
			System.out.println(" 2. Configuración");
			System.out.println(" 3. Victorias");
			System.out.println(" 4. Salir");
			System.out.println();
			System.out.println("---------------------------------");
			
			
			int eleccion = sc.nextInt();
			
			if(eleccion == 1) { // Si eliges jugar y no has configurado todavia el tablero ni los jugadores te sale este mensaje y no puedes jugar
				if( (sizetableroY == 0 || sizetableroX == 0) || (j1.nom == null || j2.nom == null)) {
					System.out.println("No has seleccionado correctamente el tamaño del tablero");
					System.out.println("o no has escrito los nombres de los jugadores");
					System.out.println("Ves al menu de configuración para configurarlos");
				}else {
					Juego(j1, j2); // Si has configurado todo puedes jugar
				}
			}else if(eleccion == 2) {
				Configuracion(j1, j2); //Funcion de configuracion
				
			}else if(eleccion == 3) {
				Victorias(j1, j2); //Funcion de RANKING de victorias.
			}else if(eleccion == 4) { // Salir del juego
				System.out.println("SACANDO CARTUCHO ESPERA..."); 
				System.out.println("La serie de partidas a finalizado.");
				salir = true;
				
			}
			
			
		}
		
		
	}

	private static void Victorias(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		
		sc.nextLine(); // esto es el bug para que no se salga automaticamente ya que anteriormente has hecho un nextInt()
		String salir = null; // si escribes lo que sea se sale del bucle
		
		while(salir == null) {
			System.out.println("////////////////////////////");
			System.out.println("----RANKING DE VICTORIAS----");
			System.out.println();
			comprovarTop(j1, j2); //Funcion para comprovar el top de los dos jugadores y printarlos
			System.out.println();
			System.out.println("////////////////////////////");
			
			System.out.print("Presiona cualquier tecla para salir del RANKING: ");
			salir = sc.nextLine(); //Escribes para salir del bucle
			System.out.println();
		}
		
	}

	private static void comprovarTop(Jugador j1, Jugador j2) {
		// TODO Auto-generated method stub
		
		if(j1.nVictories > j2.nVictories) { // Si el jugador 1 tiene mas victorias que el 2, este sale en top1
			System.out.println("- 1º " + j1.nom + " nºVictorias " + j1.nVictories);
			System.out.println();
			System.out.println("- 2º " + j2.nom + " nºVictorias " + j2.nVictories);
		}else if(j1.nVictories < j2.nVictories) { // Si el jugador 2 tiene mas victorias que el 1, este sale en top1
			System.out.println("- 1º " + j2.nom + " nºVictorias " + j2.nVictories);
			System.out.println();
			System.out.println("- 2º " + j1.nom + " nºVictorias " + j1.nVictories);
		}else if(j1.nVictories == j2.nVictories) { // En caso de empate no hay top 1 ni top 2
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
			printarTablero(tableroMuestra); // se printa el tablero de muestra
			
			if(turno == 1) { // turno j1
				System.out.println("Turno del jugador 1: " + j1.nom);
				boolean acierto = seleccionDeFitxas(tableroMuestra, tableroReal); //funcion para que el jugador escoja las 2 fixas devuelve un True si acierta
				if(acierto) {
					System.out.println(j1.nom + " has ganado 1 punto"); //Si el jugador acierta lo indica
					j1.nPunts++; // Por cada acierto se suma un punto a las estadisticas del jugador
					System.out.println("Tienes " + j1.nPunts + " puntos"); // informa al jugador cuantos puntos tiene
				}else {
					turno = 2; //Si no acierta es turno del jugador 2
				}
				
				
			}else if(turno == 2) { // exactamente igual que con el j1 pero con el j2
				System.out.println("Turno del jugador 2: " + j2.nom);
				boolean acierto = seleccionDeFitxas(tableroMuestra, tableroReal);
				if(acierto) {
					System.out.println(j2.nom + " has ganado 1 punto");
					j2.nPunts++;
					System.out.println("Tienes " + j2.nPunts + " puntos");
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
		boolean empate = false; // Flag para si hay empate
		
		if(j1.nPunts > j2.nPunts) { // comprovamos si el jugador1 tiene mas puntos
			nombreganador = j1.nom; // Si es asi el nombre del ganador sera el del j1
			j1.nVictories++; // el jugador 1 gana una victoria en sus estadisticas
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
		
		j1.nPunts = 0;
		j2.nPunts = 0; // Una vez se comprueva el ganador se ponen los puntos a cero otra vez
		
		System.out.println();
	}

	private static boolean comprovarAcabado(String[][] tableroMuestra, String[][] tableroReal) {
		// Esto es para comprovar si el juego  acabado
		
		if(Arrays.deepEquals(tableroMuestra, tableroReal)) { //Gracias a Arrays.deepEquals comprobamos si las matrices son exactamente iguales
			System.out.println(); // si es asi significa que el juego a acabado
			System.out.println("YA NO QUEDAN MAS FICHAS POR DESCUBRIR");
			System.out.println();
			return true; // si es asi devolvemos un true y sino false
		}else {
			return false;
		}
		
	}

	private static boolean seleccionDeFitxas(String[][] tableroMuestra, String[][] tableroReal) {
		// Funcion para seleccionar las dos fichas a comparar
		
		int[] primeraficha = pedirPosicion(tableroMuestra, tableroReal); //Funcion para pedir la posicion de la primera ficha que guardaremos en un array
		
		printarTablero(tableroMuestra); //Volvemos a printar el tablero para que el jugador pueda elegir la segunda fixa
				
		System.out.println();
		
		int[] segundaficha = pedirPosicion(tableroMuestra, tableroReal); // lo mismo que la primeraficha solo que ahora lo guardamos en otra variable de segundaficha
		
		printarTablero(tableroMuestra);
		
		boolean acierto = compararIgualdad(primeraficha, segundaficha, tableroMuestra, tableroReal); // Funcion para comparar si el contenido de las dos fichas son iguales
		
		return acierto; // retorna si has acertado o no
	}

	private static boolean compararIgualdad(int[] primeraficha, int[] segundaficha, String[][] tableroMuestra,
			String[][] tableroReal) {
		// Funcion para comparar la Igualdad de las dos fichas
		
		if(tableroReal[primeraficha[0]][primeraficha[1]].equals(tableroReal[segundaficha[0]][segundaficha[1]])) {
			System.out.println("Has acertado"); // si las dos fichas contienen lo mismo acieras y devuelve true
			return true;
		}else {
			System.out.println("Has Fallado"); // si fallas las fichas se volveran a "dar la vuelta" y devolvera false
			tableroMuestra[primeraficha[0]][primeraficha[1]] = "X";
			tableroMuestra[segundaficha[0]][segundaficha[1]] = "X";
			return false;
		}
		
	}

	private static int[] pedirPosicion(String[][] tableroMuestra, String[][] tableroReal) {
		// Funcion para pedir la posicion de cada ficha
		boolean correcto1 = false; //esto hara de que si introduces algo incorrecto como una ficha que ya esta destapada o un valor fuera de la matriz te vuelva a pedir
		
		int fila1 = 0;
		int columna1 = 0;
		
		int[]posiciones = new int[2]; // Creamos un array que contendra las coordenadas de la ficha
				
		while(!correcto1) {
			System.out.println("Selecciona una ficha por fila(x) y columna(y) (ej. 3 0): ");
			fila1 = sc.nextInt(); // coordenadas de fila
			columna1 = sc.nextInt(); // coordenadas de columna
			
			if(noEsticFora(tableroReal, fila1, columna1) && tableroMuestra[fila1][columna1].equals("X") ) { // Si las coordenadas no son equivocas y se selecciona una ficha que no esta descubierta 
																												//el tablero de muestra cambiara la X por el contenido de esta misma posicion del tablero real
				tableroMuestra[fila1][columna1] = tableroReal[fila1][columna1]; // Se iguala la tablero real para mostrar la ficha seleccionada
				correcto1 = true; //devolvera true para salir del bucle
			}else { //si seleccionas mal las coordenadas o dices alguna ficha que ya esta descubierta te mostrara este mensaje indicandote cuales son las permitidas y como se escribe el prompt
				System.out.println("ERROR al indicar la ficha recuerda que es del 0 - " + (tableroMuestra.length - 1) + " y primero van las filas y luego las columnas (ej 0 "+ (tableroMuestra.length - 2) + ")." );
			}
		}
		
		posiciones[0] = fila1; //ponemos las coordenadas de la fila dentro del array posiciones
		posiciones[1] = columna1; // igual pero con la columna
		
		return posiciones; //devolvemos el array posiciones
	}

	private static boolean noEsticFora(String[][] mat2, int f, int c) { 
		
		// funcion para saber que las cordenadas no estan fuera del array y no de error

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return false;
		} else {

			return true;
		}
	}

	private static String[][] inicializarTableroReal() {
		// Funcion para crear el tablero Real donde estaran la posicion verdaderra de las fichas
		int numParelles = (sizetableroX * sizetableroY)/2; //calculamos el numero de parejas que habra en nuestro memory en funcion del tamaño del tablero
		
		String[][] tableroReal = new String[sizetableroX][sizetableroY]; //creamos la matriz del tablero real 
		
		ArrayList<String> fitxes = new ArrayList<String>(); //creamos una lista donde estaran las fichas que tendra el memory
		
		for(int i = 1;  i <= numParelles; i++) { // bucle para en funcion de las parejas añadir la primera tanda de fichas
			fitxes.add(Integer.toString(i));
		}
		
		for(int i = 1;  i <= numParelles; i++) { // bucle para la segunda ya que tiene que haber dos fichas de cada
			fitxes.add(Integer.toString(i));
		}
		
//		System.out.println(fitxes);
		Collections.shuffle(fitxes); // Gracias a esto mezclaremos las fichas dentro de la lista
//		System.out.println(fitxes);
		
		int contador = 0; // contador para añadir todas las fichas
		
		for (int i = 0; i < tableroReal.length; i++) { //Rellenamos la matriz con las fichas que antes hemos puesto
			for (int j = 0; j < tableroReal[0].length; j++) {
				tableroReal[i][j] = fitxes.get(contador); //gracias al contador añadiremos cada ficha de la lista
				contador++; //subimos el contador
			}
		}
		
//		printarTablero(tableroReal); // Quitar esto despues
		
		return tableroReal; //devolvemos la matiz creada
	}

	private static String[][] inicializarTablero() { 
		// Funcion para iniciar el tablero de muestra
		
		String[][] tablero = new String[sizetableroX][sizetableroY]; //Creamos una matriz con las dimensiones de las variables globales
		omplirTablero(tablero, "X"); // funcion para llenar el tablero con el string que pongamos en nuestro caso es la X
//		printarTablero(tablero); // Quitar esto despues
		
		return tablero; //Devuelve la matriz del tablero
	}
	
	
	
	private static void printarTablero(String[][] mat) {
		//Con esta funcion imprimimos el Tablero
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(" " + mat[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	private static void omplirTablero(String[][] mat, String dibujo) {
		// Esta funcion llena el tablero con la string que hayamos puesto cuando declaramos la funcion
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = dibujo;
			}
		}

	}

	private static void Configuracion(Jugador j1, Jugador j2) {
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
				configurarJugadores(j1, j2); //Funcion para configurar el nombre de los jugadores, le pasamos los jugadores
			}else if(eleccion == 2) {
				configurarTablero(j1, j2); // Funcion para configurar el tamaño del tablero, le pasamos los jugadores
				
			}else if(eleccion == 3) { // Salir de la Config
				System.out.println("SALIENDO DE LA CONFIGURACION GUARDANDO CAMBIOS ESPERA...");
				System.out.println("Se ha regresado al menu principal");
				salir = true;
				
			}
		}
		
		
	}

	private static void configurarTablero(Jugador j1, Jugador j2) {
		// FUNCION para configurar tablero
		boolean salirTablero = false;
		
		while(!salirTablero) {
			System.out.println("---------Elige el tamaño del tablero--------");
			if(sizetableroX != 0 && sizetableroY != 0) { // si hemos seleccionado un tamaño valido se muestra el tablero
				System.out.println("Este es el tamaño de tablero actual:");
				String[][] tableromuestra = inicializarTablero(); //se inicializa el tablero de muestra con los tamaños indicados en las variables globales
				printarTablero(tableromuestra);
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
					System.out.println("Las Filas del tablero se estableceran a " + sizetableroY);
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

	private static void configurarJugadores(Jugador j1, Jugador j2) {
		// FUNCION para configurar jugadores
		boolean salirJug = false;
		
		while(!salirJug) {
			System.out.println("---------Elige un jugador a configurar--------"); // Menu config jugadores
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
				j2.nom = sc.nextLine(); // escribimos el nombre del jugador 2
				System.out.println("El nombre del Jugador 2 es " + j2.nom);
			}else if(eleccionJug == 3){
				salirJug = true; // esto es para salir del menu del jugador
			}
			
		}
	}

}


