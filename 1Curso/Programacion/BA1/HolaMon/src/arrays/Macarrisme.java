package arrays;

import java.util.Scanner;

public class Macarrisme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		double [] lista = new double[casos];
		
		for(int i = 0; i < casos; i++) {
			lista[i] = sc.nextDouble();
		}
		
		
		for (int e = 0; e < lista.length; e++) {
			System.out.print(lista[e] * 100 + "% ");
			
		}

	}

}
