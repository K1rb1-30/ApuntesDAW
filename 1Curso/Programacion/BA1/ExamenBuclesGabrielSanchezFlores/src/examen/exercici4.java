package examen;

import java.util.Scanner;

public class exercici4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		
		int c = sc.nextInt();
		
		int puntos = 0;
		
		
		for(int i = 1; i <= r; i++) {
			
			int fila = 0;
			
			for(int e = 1; e <= c; e++) {
				
				int base = (i + e) * 10;
				
				
				if ( (i + e) % 6 == 0) {
					base =  0;
				}else if ((i + e) % 3 == 0) {
					base = base * 2;
				}
				
				
				fila += base;
			}
			
			if(fila % 4 == 0) {
				fila += 50;
			}
			puntos += fila;
		}
		
		System.out.println(puntos);

	}

}
