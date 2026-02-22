package juego;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal del juego Buscaminas.
 * Contiene el menú principal y la lógica general del programa.
 * 
 * @author Gabriel Sanchez Flores
 * @version 1.0
 */
public class Buscaminas {
	
	/** Scanner global para poder usarlo en todas las funciones */
	static Scanner sc = new Scanner(System.in);

	/**
	 * Menu principal del buscaminas
	 * @param args main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuracion config = new Configuracion();
		
		
		boolean salir = false; //variable para salir del juego
		
		while(!salir) {
			System.out.println("=================================================");
		    System.out.println("                  BUSCAMINAS                  ");
		    System.out.println("=================================================");
			System.out.println(" --------------Escoge una opción----------------");
			System.out.println();
			System.out.println(" 1.- Mostrar Ayuda");
			System.out.println(" 2.- Opciones");
			System.out.println(" 3.- Jugar Partida");
			System.out.println(" 4.- Ver Lista de Ganadores");
			System.out.println(" 0.- Salir");
			System.out.println();
			System.out.println("=================================================");
			
			int eleccion = sc.nextInt();
			sc.nextLine();
			
			switch (eleccion) {
			case 1: {
				mostrarAjuda();
				break;
			}case 2: {
				opcions(config);
				break;
			}case 3: {
				if(config.columnas == 0 || config.filas == 0 || config.nMinas == 0) {
					System.out.println("===============================================================");
					System.out.println("Antes de jugar por primera vez Configura el juego en opciones");
					System.out.println("===============================================================");
				}else {
					jugar(config);
				}
				break;
			}case 4: {
				guanyadors(config.winners);
				break;
			}case 0: {
				System.out.println("Saliendo del juego...");
				System.out.println("GRACIAS POR JUGAR");
				salir = true;
				break;
			}
			default:
				System.out.println("El numero introducido no es valido");
			}
		}

	}

	
	/**
	 * Devuelve una lista con los nombres de los jugadores que han ganado
	 *
	 * @param winners Lista con los nombres de los jugadores
	 */
	private static void guanyadors(ArrayList<String> winners) {
		// TODO Auto-generated method stub
		System.out.println("=================================================");
	    System.out.println("                  GANADORES                  ");
	    System.out.println("=================================================");
	    
	    for (String s : winners) {
			System.out.println("- " + s);
		}
	}

	/**
	 * Explica como se juega al buscaminas,
	 * para los que no han jugado nunca al buscaminas
	 */
	private static void mostrarAjuda() {
		// TODO Auto-generated method stub
		System.out.println("=================================================");
	    System.out.println("                  BUSCAMINAS                  ");
	    System.out.println("=================================================");
	    System.out.println();
	    System.out.println("  OBJETIVO DEL JUEGO:");
	    System.out.println("Descubrir todas las casillas del tablero");
	    System.out.println("sin pisar ninguna mina.");
	    System.out.println();
	    System.out.println("-------------------------------------------------");
	    System.out.println("  ¿CÓMO FUNCIONA?");
	    System.out.println("-------------------------------------------------");
	    System.out.println("• El tablero contiene minas ocultas.");
	    System.out.println("• En cada turno debes elegir una posición");
	    System.out.println("  introduciendo fila y columna.");
	    System.out.println("• Si la casilla NO tiene mina:");
	    System.out.println("     → Aparecerá un número (0-8).");
	    System.out.println("     → Ese número indica cuántas minas");
	    System.out.println("       hay alrededor de esa casilla.");
	    System.out.println();
	    System.out.println("• Si la casilla tiene una mina:");
	    System.out.println("     💥 ¡PIERDES LA PARTIDA!");
	    System.out.println();
	    System.out.println("-------------------------------------------------");
	    System.out.println("  SIGNIFICADO DE LOS NÚMEROS:");
	    System.out.println("-------------------------------------------------");
	    System.out.println("0  → No hay minas alrededor.");
	    System.out.println("1  → Hay 1 mina en las casillas vecinas.");
	    System.out.println("2  → Hay 2 minas alrededor.");
	    System.out.println("...");
	    System.out.println("8  → Hay 8 minas alrededor.");
	    System.out.println();
	    System.out.println("Si aparece un 0, el juego descubrirá");
	    System.out.println("automáticamente las casillas cercanas.");
	    System.out.println();
	    System.out.println("-------------------------------------------------");
	    System.out.println("  ¿CÓMO SE GANA?");
	    System.out.println("-------------------------------------------------");
	    System.out.println("Ganas cuando todas las casillas que NO");
	    System.out.println("tienen mina han sido descubiertas.");
	    System.out.println();
	    System.out.println("-------------------------------------------------");
	    System.out.println("  CONSEJOS:");
	    System.out.println("-------------------------------------------------");
	    System.out.println("• Usa los números para deducir dónde");
	    System.out.println("  pueden estar las minas.");
	    System.out.println("• No elijas posiciones al azar.");
	    System.out.println("• Piensa antes de seleccionar.");
	    System.out.println();
	    System.out.println("=================================================");
	    System.out.println("           ¡BUENA SUERTE, JUGADOR!             ");
	    System.out.println("=================================================");
	    System.out.println();
	}
	
	/**
	 * Empieza la partida al buscaminas
	 *
	 * @param config configuracion para la partida
	 */
	private static void jugar(Configuracion config) {
		// TODO Auto-generated method stub
		int[][] mines = new int[config.filas][config.columnas];
		int[][] camp = new int[config.filas][config.columnas];
		Posicion pos = new Posicion(); // Con esto tendremos as coordenadas
		boolean partidaEnCurs;
		
		inicialitzarMines(mines, config.nMinas);
		inicialitzarCamp(camp);
		partidaEnCurs = true;
		
		while(partidaEnCurs) {
			visualitzarCamp(camp);
			System.out.println(" ");
//			System.out.println(pos.fila);
			demanarcoords(pos, camp);
//			System.out.println(pos.fila);
			descobrir(pos.fila, pos.columna, camp, mines);
			partidaEnCurs = partidaAcabada(pos.fila,pos.columna, camp, mines, config);
			
		}
		
		fiPartida(config, mines, camp);
		
		

	}
	
	/**
	 * Indica al jugador si ha ganado o ha perdido segun el estado de la partida.
	 *
	 * @param config configuracion para la partida dpnde se verificara el estado
	 * @param mines Matriz de campo de minas
	 * @param camp Matriz campo que visualiza el jugador siempre
	 */
	private static void fiPartida(Configuracion config, int[][] mines, int[][] camp) {
		// TODO Auto-generated method stub
		if(config.estadoPartida.equals("Perdida")) {
			System.out.println("=================================================");
			System.out.println("                 HAS PERDIDO                     ");
			System.out.println("             Has pisado una mina.                ");
		    System.out.println("=================================================");
			System.out.println("Este era el campo con minas (Los 1 son la posicion de las minas)");
			visualitzarCamp(mines);
		}else if(config.estadoPartida.equals("Ganada")) {
			visualitzarCamp(camp);
			System.out.println("=================================================");
			System.out.println("                 HAS GANADO                      ");
			System.out.println("          No has pisado ninguna mina             ");
			System.out.println("                                                 ");
			System.out.println("");
			System.out.println(config.nombreJugador + ", seras añadido a la lista de Ganadores");
		    System.out.println("=================================================");
			config.winners.add(config.nombreJugador);
		}
	}

	/**
	 * Pide las cordenadas y las guarda en un objeto de posicion
	 *
	 * @param pos Objeto con la posicion que elegira el jugador
	 * @param camp Matriz campo que visualiza el jugador siempre
	 */
	private static void demanarcoords(Posicion pos, int[][] camp) {
		//Demanar coordenadas protegidas
		
		boolean correcto1 = false; //esto hara de que si introduces algo incorrecto volvera
		
		while(!correcto1) {
			System.out.println("Selecciona las coordenadas de la zona que quieres revisar ej (1 " + camp.length + ")");
			int fila = sc.nextInt() - 1; // coordenadas de fila
			int columna = sc.nextInt() - 1; // coordenadas de columna
			
			if(!esticFora(camp, fila, columna) && camp[fila][columna] == 9) { // Si las coordenadas no son equivocas y se selecciona una zona que no esta descubierta 																							//el tablero de muestra cambiara la X por el contenido de esta misma posicion del tablero real
				pos.fila = fila;
				pos.columna = columna; // Se iguala la tablero real para mostrar la ficha seleccionada
				correcto1 = true; //devolvera true para salir del bucle
			}else { //si seleccionas mal las coordenadas o dices alguna ficha que ya esta descubierta te mostrara este mensaje 
				System.out.println("ERROR al indicar la ficha");
			}
		}
		
	}

	
	/**
	 * Verifica si la partida ha finalizado, 
	 * dependiendo si ha explotado una mina o ya no hay mas zonas por descubrir sin minas
	 * , se determinara el estado de la partida a "Perdida" o "Ganada".
	 * @param fila Int con la fila que ha elegido el jugador.
	 * @param columna Int con la columna que ha elegido el jugador.
	 * @param camp Matriz campo que visualiza el jugador siempre.
	 * @param mines Matriz del campo de minas
	 * @param config Configuracion del juego
	 * @return false o true dependiendo si ha finalizado o no la partida 
	 */
	private static boolean partidaAcabada(int fila, int columna, int[][] camp, int[][] mines, Configuracion config) {
		// TODO Auto-generated method stub
		
		if(mines[fila][columna] == 1) {
			config.estadoPartida = "Perdida";
			return false;
			
		}else if(CasellesLliures(camp) == config.nMinas) {
			config.estadoPartida = "Ganada";
			return false;
		}
		return true;
	}

	
	/**
	 * Verifica cuantas casillas hay sin descubrir.
	 * @param camp Matriz del campo a verificar
	 * @return Un Int con el numero de casillas sin descubrir.
	 */
	private static int CasellesLliures(int[][] camp) {
		
		int contador = 0; //Contara el nombre de casillas libres en el tablero
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp.length; j++) {
				if(camp[i][j] == 9) {
					contador++;
				}
			}
		}
		return contador;
		
	}

	/**
	 * Dadas unas coordenadas verifica cuantas minas hay alrededor y actualiza el campo.
	 * Si se da el caso que alrededor no haya ninguna mina se destaparan las demas casillas recursivamente
	 * hasta que alrededor haya alguna mina.
	 * @param fila Int con la fila que ha elegido el jugador.
	 * @param columna Int con la columna que ha elegido el jugador.
	 * @param camp Matriz campo que visualiza el jugador siempre.
	 * @param mines Matriz del campo de minas
	 */
	private static void descobrir(int fila, int columna, int[][] camp, int[][] mines) {
		// TODO Auto-generated method stub
		if(esticFora(mines,fila, columna) || camp[fila][columna] != 9) {
			return;
		}
		
		int n = destapar(fila, columna, mines);
//		System.out.println(n);
		camp[fila][columna] = n;
		
		if(n == 0) {
			descobrir(fila - 1, columna, camp, mines); // arriba
			descobrir(fila + 1, columna, camp, mines); // abajo
			descobrir(fila, columna + 1, camp, mines); // derecha
			descobrir(fila, columna - 1, camp, mines); // izquierda
		}
	}
	
	/**
	 * Dadas unas coordenadas verifica cuantas minas hay alrededor y las cuenta.
	 * @param fila Int con la fila que ha elegido el jugador.
	 * @param columna Int con la columna que ha elegido el jugador.
	 * @param mines Matriz del campo de minas a verificar.
	 * @return Un Int con el numero de minas alrededor.
	 */
	private static int destapar(int fila, int columna, int[][] mines) {
		// TODO Auto-generated method stub
		int contador = 0;
			for (int i = fila - 1; i <= fila + 1; i++) {
				for (int j = columna - 1; j <= columna + 1; j++) {
					if(!esticFora(mines,i,j) && mines[i][j] == 1) {
						contador++;
					}
				}
			}
		return contador;
	}
	
	/**
	 * Verifica si las coordenadas estan fuera de la matriz
	 * @param mat2 Matriz a verificar.
	 * @param f fila a verificar dentro de la matriz
	 * @param c columna a verificar dentro de la matriz
	 * @return true si estas fuera de la matriz o false si estas dentro de la matriz.
	 */
	private static boolean esticFora(int[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}
	}

	/**
	 * Printa por consola la matriz especificada
	 * @param camp Matriz a printar.
	 */
	private static void visualitzarCamp(int[][] camp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp[0].length; j++) {
				System.out.print(" " + camp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Inicializa el campo con las casillas tapadas (9).
	 * @param camp Matriz a iniciar.
	 */
	private static void inicialitzarCamp(int[][] camp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp.length; j++) {
				camp[i][j] = 9;
			}
		}
			
	}
	
	/**
	 * Inicializa el campo de minas poniendolas aleatoriamente
	 * en una posicion del campo.
	 * @param mines Matriz del campo de minas.
	 * @param nMinas Int con el numero de minas a colocar.
	 */
	private static void inicialitzarMines(int[][] mines, int nMinas) {
		// TODO Auto-generated method stub
		int minasColocadas = 0; //ponemos otra variable con el nombre de minas puesto anteriormente
		Random r = new Random(); // para Randomizar la posicion de las minas
		
		while(minasColocadas < nMinas) { // Siempre que haya menos minas colocadas que el numero de minas de verdad
			
			int f = r.nextInt(0, mines.length);
            int c = r.nextInt(0, mines.length);

            if (mines[f][c] == 0) { //si el sitio aleatoriamente escogido no hay minas
                mines[f][c] = 1; // se p[one un uno conforme ya hay mina
                minasColocadas++; // se suma al contador
            }
		}
		
	}
	
	/**
	 * Opciones a configurar del juego
	 * @param config Objeto configuracion donde se guardaran todos los parametros.
	 */
	private static void opcions(Configuracion config) {
		// TODO Auto-generated method stub
		System.out.print("Selecciona el nombre del jugador: ");
		config.nombreJugador = sc.nextLine();
		System.out.print("Selecciona el nombre de filas del tablero: ");
		config.filas = sc.nextInt();
		System.out.print("Selecciona el nombre de columnas del tablero: ");
		config.columnas = sc.nextInt();
		System.out.print("Selecciona el nombre de minas que habra en el tablero: ");
		config.nMinas = sc.nextInt();
	}
}
