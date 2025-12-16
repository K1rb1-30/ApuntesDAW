package joelmatrius;

import java.util.Scanner;

public class Notes1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int e = 0; e < casos; e++) {
			
			int files = sc.nextInt();
			int columnes = sc.nextInt();
			
			int[][] mat = new int[files][columnes];
			
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[0].length; j++) {
					mat[i][j]=sc.nextInt();
				}
			}
			
			
			for (int r = 0; r < mat.length; r++) {
				
				int contador = 0;
				
				for (int g = 0; g < mat[0].length; g++) {
					
					contador += mat[r][g];
					
					}
				
					System.out.print(contador/columnes + " ");
				}
				
			System.out.println();
			}

	}

}
