package joelmatrius;

import java.util.Scanner;

public class BlackFriday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int files = sc.nextInt();
		int columnes = sc.nextInt();
		
		int[][] tablero = new int[files][columnes];
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = sc.nextInt();
			}
		}
		
		int multi = sc.nextInt();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				System.out.print(tablero[i][j] * multi + " ");
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
