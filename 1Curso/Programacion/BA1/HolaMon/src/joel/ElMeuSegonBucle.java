package joel;

import java.util.Scanner;

public class ElMeuSegonBucle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++ ) {
			int hola = sc.nextInt();
			for(int e = 0; e < hola; e++) {
				int adios = sc.nextInt();
				System.out.println(adios + 1);
			}
		}

	}

}
