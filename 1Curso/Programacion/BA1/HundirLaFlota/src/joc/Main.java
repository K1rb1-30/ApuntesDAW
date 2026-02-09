package joc;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] tableroj1 = new String[10][10];
		String[][] tableroj2 = new String[10][10];
		Posicion pos = new Posicion();
		Jugador j1 = new Jugador();
		
		iniciarTablero(tableroj1, pos);
		//iniciarTablero(tableroj2,pos); ESTO PARA CUANDO SE QUIERA HACER QUE CADA JUGADOR TENGA UN TABLERO
		turnoJugador(tableroj1, pos, j1);
		
		printarTablero(tableroj1);
	}

	private static void turnoJugador(String[][] tableroj1, Posicion pos, Jugador j1) {
		// TODO Auto-generated method stub
		System.out.println("Turno del jugador: " + j1.nombre );
		
		pedirPosicion(pos, tableroj1);
		
	}

	private static void pedirPosicion(Posicion pos, String[][] tablero) {
		// TODO Auto-generated method stub
		
		boolean correcto1 = false; //esto hara de que si introduces algo incorrecto o un valor fuera de la matriz te vuelva a pedir
		
		int fila1 = 0;
		int columna1 = 0;
				
		while(!correcto1) {
			System.out.println("Selecciona una casillas por fila(x) y columna(y) (ej. 3,a): ");
			fila1 = sc.nextInt(); // coordenadas de fila
			columna1 = sc.nextInt(); // coordenadas de columna
			
			if(noEsticFora(tablero, fila1, columna1)) { // Si las coordenadas no son equivocas se hara esto
																							
				pos.fila = fila1; //ponemos las coordenadas de la fila dentro del objeto posiciones
				pos.columna = columna1; // igual pero con la columna
				correcto1 = true; //devolvera true para salir del bucle
			}else { //si seleccionas mal las coordenadas te mostrara este mensaje indicandote cuales son las permitidas y como se escribe el prompt
				System.out.println("ERROR al indicar la ficha recuerda que es del 0 - " + (tablero.length - 1) + " y primero van las filas y luego las columnas en letras (ej 0 "+ (tablero.length - 2) + ")." );
			}
		}
		
	}

	private static void iniciarTablero(String[][] tablero, Posicion pos) {
		// TODO Auto-generated method stub
		
		rellenarTablero(tablero, "·");
		
		Random r = new Random(); //inicializamos variable random
		
		// Aleatoriamente cremos unas cordenadas y las comprovamos
		boolean sepuede = false;
		int nSubmarinos = 8; // cambiar si se quiere añadir mas numero de submarinos
		
		while(!sepuede) {
			pos.fila = r.nextInt(0,10);
			pos.columna = r.nextInt(0,10);
			
			//Comprovamos los lados para ver si hay algun barco
			
			boolean colocar = comprobarLados(tablero, pos);
			
			if(nSubmarinos > 0 && colocar == true) {
				tablero[pos.fila][pos.columna] = "X";
				nSubmarinos--;
			}else if(nSubmarinos <= 0) {
				sepuede = true;
			}
			
		}
		
		
		
		
	}

	private static boolean comprobarLados(String[][] tablero, Posicion pos) {
		// TODO Auto-generated method stub
		if(comprobarUno(pos.fila, pos.columna + 1, tablero) && 
			comprobarUno(pos.fila, pos.columna - 1, tablero) && 
			comprobarUno(pos.fila - 1, pos.columna, tablero) &&
			comprobarUno(pos.fila + 1, pos.columna, tablero) ) {
			
			return true;
			
		}
		
		return false;
	}

	private static void rellenarTablero(String[][] mat, String dibujo) {
		// TODO Auto-generated method stub
		// Esta funcion llena el tablero con la string que hayamos puesto cuando declaramos la funcion
				for (int i = 0; i < mat.length; i++) {
					for (int j = 0; j < mat[0].length; j++) {
						mat[i][j] = dibujo;
					}
				}
	}
	
	private static boolean noEsticFora(String[][] taulell, int fila1, int columna1) {
		// funcion para saber que las cordenadas no estan fuera del array y no de error

				if (fila1 < 0 || columna1 < 0 || fila1 > taulell.length - 1 || columna1 > taulell[0].length - 1) {
					return false;
				} else {

					return true;
				}
	}
	
	private static boolean comprobarUno(int x, int y, String[][] taulell) {
		// TODO Auto-generated method stub
		if(noEsticFora(taulell, x, y) && taulell[x][y].equals("X")) { //Comprueba que no este fuera
			return false;
		}else if(noEsticFora(taulell, x, y) && taulell[x][y].equals("·")) {
			return true;
		}
		
		return false;
		
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
	
	

}
