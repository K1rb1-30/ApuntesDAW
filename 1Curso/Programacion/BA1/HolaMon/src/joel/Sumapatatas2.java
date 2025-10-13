package joel;

import java.util.Scanner;

public class Sumapatatas2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			int solo = sc.nextInt();
			int suma = 0;
			
			for(int e = 0; e < solo; e++) {
				int patacas = sc.nextInt();
				suma += patacas;
			}
			
			System.out.println(suma);
		}
		
	}

}
