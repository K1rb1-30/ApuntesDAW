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
				
			}case 2: {
				opcions(config);
				
			}case 3: {
				jugar(config);
				
			}case 4: {
				//guanyadors();
				
			}case 5: {
				System.out.println("Saliendo del juego...");
				System.out.println("GRACIAS POR JUGAR");
				
			}
			default:
				
			}
		}

	}

	private static void jugar(Configuracion config) {
		// TODO Auto-generated method stub
		int[][] mines = new int[config.filas][config.columnas];
		int[][] camp = new int[config.filas][config.columnas];
		boolean partidaEnCurs;
		int d = 0;
		
		inicialitzarMines(mines, config.nMinas);
		inicialitzarCamp(camp);
		partidaEnCurs = true;
		
		visualitzarCamp(mines);
		

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
