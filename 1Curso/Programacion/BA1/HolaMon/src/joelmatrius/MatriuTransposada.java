package joelmatrius;

import java.util.Scanner;

public class MatriuTransposada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int f = sc.nextInt();
		int c = sc.nextInt();
		
		int[][] mat = new int[c][f];
		
		
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat[j][i] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}

}
