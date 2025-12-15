package joelmatrius;

import java.util.Scanner;

public class EscriuMatriu2 {

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
		
		int buscarnumero = sc.nextInt();
		int cambiarlo = sc.nextInt();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == buscarnumero) {
					// mat[i][j] = cambiarlo;
					System.out.print(cambiarlo + " ");
				}else {
					System.out.print(mat[i][j] + " ");
				}
				
			}
			System.out.println();
		}
		
	}

}
