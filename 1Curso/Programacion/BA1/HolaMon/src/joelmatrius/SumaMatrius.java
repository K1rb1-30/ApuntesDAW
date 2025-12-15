package joelmatrius;

import java.util.Scanner;

public class SumaMatrius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int grandaria = sc.nextInt();
		
		int[][] mat1 = new int[grandaria][grandaria];
		int[][] mat2 = new int[grandaria][grandaria];
		
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
					mat1[i][j]=sc.nextInt();
				}
			}
		
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
					mat2[i][j]=sc.nextInt();
				}
			}
		
		int[][] matresultant = new int[grandaria][grandaria];
		
		for (int i = 0; i < matresultant.length; i++) {
			for (int j = 0; j < matresultant[0].length; j++) {
					matresultant[i][j]= mat1[i][j] + mat2[i][j];
				}
			}
		
		for (int i = 0; i < matresultant.length; i++) {
			for (int j = 0; j < matresultant[0].length; j++) {
					System.out.print(matresultant[i][j] + " ");;
			}
			System.out.println();
		}
		
		
		
	}

}
