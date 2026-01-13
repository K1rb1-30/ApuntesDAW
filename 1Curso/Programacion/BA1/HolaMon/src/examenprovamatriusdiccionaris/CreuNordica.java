package examenprovamatriusdiccionaris;

import java.util.Scanner;

public class CreuNordica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int files = sc.nextInt();
		int columnes = sc.nextInt();
		
		String[][] tablero = new String[files][columnes];
		
		omplirMatriuString(tablero, ".");
		omplirMeitatMatriuString(tablero, files, "X");
		omplirFranjaMatriuString(tablero, columnes, "X");
		
		printarMatriuString(tablero);
		
		
		
		

	}
	
	
	// funciones ahora cambia
	
	public static void printarMatriuString(String[][] patata) {
		for (int i = 0; i < patata.length; i++) {
			for (int j = 0; j < patata[0].length; j++) {
				System.out.print(patata[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	
	public static void omplirMatriuString(String[][] mat, String dibuix) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = dibuix;
			}
		}

	}
	
	public static void omplirMeitatMatriuString(String[][] mat, int filas, String dibuix) {

		// printar meitat
		
		int mitad = filas/2;
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i printem la fila indicada
			mat[mitad][i] = dibuix;
		}
		
		
		//

	}
	
	
	public static void omplirFranjaMatriuString(String[][] mat, int n, String dibuix) {

		// printar franja
		
		int franja = n/3; // (n+2*n)+1)
		
		// al comenzar por 0 no hace falta restarle 1
		for (int j = 0; j < mat.length; j++) {
			mat[j][franja] = dibuix;
		}

	}
	

}
