package recursividad;

import java.util.Scanner;

public class AmbrosioTriangular {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			int p = sc.nextInt();
			
			System.out.println(piramide(p));
		
		}
	}
	private static int piramide(int p) {
		// TODO Auto-generated method stub
		if(p <= 1) {
			return 1;
		}else {
			return piramide(p - 1) + p * (p+1) /2;
		}
		
	}

}
