package arrays;

import java.util.Scanner;

public class EscalaReial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos ; i++) {
			
			int [] flop = new int[7];
			
			for(int e = 0; e < 7; e++) {
				int carta = sc.nextInt();
				flop[e] = carta;
			}
			
			int sup = flop[0];
			
			//int compte =
			
			for(int a = 0; a < flop.length; a++) {
				if( flop[a] == sup + 1 || flop[a] == sup - 1) {
					
				}
			}
			
			
		}
		
		

	}

}
