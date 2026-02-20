package juego;

import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
	
	static Scanner sc = new Scanner(System.in);  //Scanner global para poder usarlo en todas las funciones

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuracion config = new Configuracion();
		
		
		boolean salir = false; //variable para salir del juego
		
		while(!salir) {
			System.out.println("---------------------------------");     //Aspecto del menu principal
			System.out.println("-----Bienvenido al Buscaminas----");
			System.out.println("---------------------------------");
			System.out.println("---------Escoge una opción-------");
			System.out.println();
			System.out.println(" 1.- Mostrar Ajuda");
			System.out.println(" 2.- Opcions");
			System.out.println(" 3.- Jugar Partida");
			System.out.println(" 4.- Veure Llista de Guanyadors");
			System.out.println(" 0.- Sortir");
			System.out.println();
			System.out.println("---------------------------------");
			
			int eleccion = sc.nextInt();
			sc.nextLine();
			
			switch (eleccion) {
			case 1: {
				//mostrarAjuda();
				break;
			}case 2: {
				opcions(config);
				break;
			}case 3: {
				jugar(config);
				break;
			}case 4: {
				//guanyadors();
				break;
			}case 5: {
				System.out.println("Saliendo del juego...");
				System.out.println("GRACIAS POR JUGAR");
				salir = true;
				break;
			}
			default:
				
			}
		}

	}

	private static void jugar(Configuracion config) {
		// TODO Auto-generated method stub
		int[][] mines = new int[config.filas][config.columnas];
		int[][] camp = new int[config.filas][config.columnas];
		Posicion pos = new Posicion(); // Con esto tendremos as coordenadas
		boolean partidaEnCurs;
		int d = 0;
		
		inicialitzarMines(mines, config.nMinas);
		inicialitzarCamp(camp);
		partidaEnCurs = true;
		
		while(partidaEnCurs) {
			visualitzarCamp(mines);
			System.out.println(" ");
//			System.out.println(pos.fila);
			demanarcoords(pos);
//			System.out.println(pos.fila);
			descobrir(pos.fila, pos.columna, camp, mines);
			//partidaEnCurs = partidaAcabada(pos, camp);
			visualitzarCamp(camp);
		}
		
		
		

	}

	private static void demanarcoords(Posicion pos) {
		// REVISAR Y PROTEGER ESTO
		System.out.println("Selecciona las coordenadas de la zona que quieres revisar ej (1 1)");
		pos.fila = sc.nextInt() - 1;
		pos.columna = sc.nextInt() - 1;
		
		
	}

	private static boolean partidaAcabada(int fila, int columna, int[][] camp) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	private static void descobrir(int fila, int columna, int[][] camp, int[][] mines) {
		// TODO Auto-generated method stub
		if(esticFora(mines,fila, columna) || camp[fila][columna] != 9) {
			return;
		}
		
		int n = destapar(fila, columna, mines);
		System.out.println(n);
		camp[fila][columna] = n;
		
		if(n == 0) {
			descobrir(fila - 1, columna, camp, mines); // arriba
			descobrir(fila + 1, columna, camp, mines); // abajo
			descobrir(fila, columna + 1, camp, mines); // derecha
			descobrir(fila, columna - 1, camp, mines); // izquierda
		}
	}
	
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

	private static boolean esticFora(int[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}
	}

	private static void visualitzarCamp(int[][] camp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp[0].length; j++) {
				System.out.print(" " + camp[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void inicialitzarCamp(int[][] camp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp.length; j++) {
				camp[i][j] = 9;
			}
		}
			
	}

	private static void inicialitzarMines(int[][] mines, int nMinas) {
		// TODO Auto-generated method stub
		int minasPorPoner = nMinas; //ponemos otra variable con el nombre de minas puesto anteriormente
		Random r = new Random(); // para Randomizar la posicion de las minas
		
		while(minasPorPoner > 0) {
			
			for (int i = 0; i < mines.length; i++) {
				for (int j = 0; j < mines.length; j++) {
					int mina = r.nextInt(0, 2);
					if(minasPorPoner > 0 && mina == 1 && mines[i][j] == 0) {
						mines[i][j] = mina;
						minasPorPoner--;
					}else if (mina != 1){
						mines[i][j] = 0;
					}
				}
			}
		}
		
	}

	private static void opcions(Configuracion config) {
		// TODO Auto-generated method stub
		System.out.println("Selecciona el nombre del jugador");
		config.nombreJugador = sc.nextLine();
		System.out.println("Selecciona el nombre de filas del tablero");
		config.filas = sc.nextInt();
		System.out.println("Selecciona el nombre de columnas del tablero");
		config.columnas = sc.nextInt();
		System.out.println("Selecciona el nombre de minas que habra en el tablero");
		config.nMinas = sc.nextInt();
	}
}
