package joelmatrius;

import java.util.Scanner;

public class SumaFilesColumnes {

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
		
		int buscar = sc.nextInt();
		int filasum = 0;
		int columnasum = 0;
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i printem la fila indicada
			filasum += mat[buscar][i];
		}
		
		for (int j = 0; j < mat.length; j++) {
			columnasum += mat[j][buscar];
		}
		
		System.out.println(filasum + " " + columnasum);
		
		
	}

}
