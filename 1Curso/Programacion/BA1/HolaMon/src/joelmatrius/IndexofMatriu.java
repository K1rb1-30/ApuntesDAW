package joelmatrius;

import java.util.Scanner;

public class IndexofMatriu {

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
		boolean encontrado = false;
		
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
					if(mat[i][j] == buscarnumero) {
						encontrado = true;
						System.out.println( i + " " + j );
					}
			}
		}
		
		if(!encontrado) {
			System.out.println(-1 + " " + -1);
		}
	}

}
