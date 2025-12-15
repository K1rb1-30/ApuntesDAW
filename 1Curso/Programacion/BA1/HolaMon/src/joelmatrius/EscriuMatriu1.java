package joelmatrius;

import java.util.Scanner;

public class EscriuMatriu1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int files = sc.nextInt();
		int columnes = sc.nextInt();
		
		int[][] mat = new int[files][columnes];
		
		for (int i = 0; i < mat.length; i++) {
		for (int j = 0; j < mat[0].length; j++) {
				mat[i][j]=sc.nextInt();
			}
		}
		
		int buscarfila = sc.nextInt();
		int buscarcolumna = sc.nextInt();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
					System.out.print(mat[i][j] + " ");;
			}
			System.out.println();
		}
		
		System.out.println(mat[buscarfila][buscarcolumna]);
		

	}

}
