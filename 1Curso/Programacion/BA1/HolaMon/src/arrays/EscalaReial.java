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
			
			// BUBBLE SORT ALGORITMO
			
			
			
			int max = flop.length;
			
			for(int e = 0; e < max-1; e++) {
				boolean noswap = false;
				
				for(int j = 0; j < max-i-1; j++) {
					if(flop[j] > flop[j+1]) {
						int primero = flop[j];
						int segundo = flop[j+1];
						
						flop[j] = segundo;
						flop[j+1] = primero;
						boolean noswap = false;
					}
				}
			}
						
						
			
			
			
			

			}
		}
	}