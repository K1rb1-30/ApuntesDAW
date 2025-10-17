package joel;

import java.util.Scanner;

public class Patats1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int camiones = sc.nextInt();
		int acumulador = 0;
		
		for(int i = 0; i < camiones; i++) {
			int manzanas = sc.nextInt();
			acumulador = acumulador + manzanas;
		}
		System.out.println(acumulador);
	}

}
