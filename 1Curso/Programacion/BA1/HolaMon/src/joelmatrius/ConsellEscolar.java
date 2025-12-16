package joelmatrius;

import java.util.Scanner;

public class ConsellEscolar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int tamany = sc.nextInt();
		
		String[][] mat = new String[tamany][tamany];
		
		omplirMatriuString(mat, ".");
		omplirVoresMatriuString(mat, "X");
		dibuixarDiagonalString(mat, "X");
		dibuixarDiagonalInversaString(mat, "X");
		printarMatriuString(mat);
		
		
		
		

	}
	
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
	
	public static void omplirVoresMatriuString(String[][] mat, String dibuix) {

		// printar primera y ultima fila
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i printem la fila indicada
			mat[0][i] = dibuix;
		}
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i printem la fila indicada
			mat[mat.length-1][i] = dibuix;
		}
		
		
		// printar primera y ultima columna
		for (int j = 0; j < mat.length; j++) {
			mat[j][0] = dibuix;
		}
		
		for (int j = 0; j < mat.length; j++) {
			mat[j][mat.length-1] = dibuix;
		}

	}
	
	
	public static void dibuixarDiagonalString(String[][] mat, String dibuix) {
		for (int i = 0; i < mat.length; i++) {
			mat[i][i] = dibuix;

		}

	}
	
	public static void dibuixarDiagonalInversaString(String[][] mat2, String dibuix) {
		for (int i = 0; i < mat2.length; i++) {
			mat2[i][mat2.length - 1 - i] = dibuix;
		}

	}

}
