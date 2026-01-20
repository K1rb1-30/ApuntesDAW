package exercicis;

import java.util.Scanner;

public class SopaDeUwus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int files = sc.nextInt();
		int columnes = sc.nextInt();
		
		String[][] mat = new String[files][columnes];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j]=sc.next();
			}
		}
		
		int buscarfila = sc.nextInt();
		int buscarcolumna = sc.nextInt();
		
		boolean filauwu = false;
		boolean columnauwu = false;
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i mirem la fila
			if(!esticFora(mat, buscarfila, i + 1) && mat[buscarfila][i].equals("u")) {
				if(!esticFora(mat, buscarfila, i + 2) && mat[buscarfila][i+1].equals("w")) {
					if(mat[buscarfila][i+2].equals("u")) {
						filauwu = true;
					}
				}
			}
		}
		
		for (int i = 0; i < mat[0].length; i++) {
			if(!esticFora(mat, i + 1, buscarcolumna) && mat[i][buscarcolumna].equals("u")) {
				if(!esticFora(mat, i + 2, buscarcolumna) && mat[i+1][buscarcolumna].equals("w")) {
					if(mat[i+2][buscarcolumna].equals("u")) {
						columnauwu = true;
					}
				}
			}
		}
		
		if(filauwu == true && columnauwu == true) {
			System.out.println("UWU");
		}else if(filauwu == true || columnauwu == true) {
			System.out.println("uwu");
		}else {
			System.out.println("uwun't");
		}
		

	}
	
	private static boolean esticFora(String[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}
	}

}
