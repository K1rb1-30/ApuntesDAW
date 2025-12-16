package joelmatrius;

import java.util.Scanner;

public class MatriuIdentitat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tamany = sc.nextInt();
		
		int[][] mat = new int[tamany][tamany];
		
		omplirMatriuInt(mat, 0);
		dibuixarDiagonalInt(mat, 1);
		printarMatriuInt(mat);

	}
	
	public static void printarMatriuInt(int[][] patata) {
		for (int i = 0; i < patata.length; i++) {
			for (int j = 0; j < patata[0].length; j++) {
				System.out.print(patata[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static void omplirMatriuInt(int[][] mat, int dibuix) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = dibuix;
			}
		}

	}
	
	public static void dibuixarDiagonalInt(int[][] mat, int dibuix) {
		for (int i = 0; i < mat.length; i++) {
			mat[i][i] = dibuix;

		}

	}
	
	

}
