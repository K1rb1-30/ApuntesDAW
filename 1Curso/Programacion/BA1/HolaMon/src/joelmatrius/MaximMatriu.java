package joelmatrius;

import java.util.Scanner;

public class MaximMatriu {

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
			
			int maxfila = maximfilaMatriu(mat);
			int maxcolumna = maximcolumnaMatriu(mat);
			
			System.out.println((maxfila + 1) + " " + (maxcolumna + 1));
			
			
			
			
			
			
		}
		
		
		

	}
	
	public static int maximfilaMatriu(int[][] patata) {
		
		int maximo = 0;
		int maximofila = 0;
		
		for (int i = 0; i < patata.length; i++) {
			for (int j = 0; j < patata[0].length; j++) {
				if(patata[i][j] > maximo) {
					maximo = patata[i][j];
					maximofila = i;
				
				}
			}
		}
		
		return maximofila;
	}
	
	public static int maximcolumnaMatriu(int[][] patata) {
		
		int maximo = 0;
		int maximocolumna = 0;
		
		for (int i = 0; i < patata.length; i++) {
			for (int j = 0; j < patata[0].length; j++) {
				if(patata[i][j] > maximo) {
					maximo = patata[i][j];
					maximocolumna = j;
				}
			}
		}
		
		return maximocolumna;
		

	}
	

}
