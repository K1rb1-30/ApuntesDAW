package recursividad;

import java.util.Scanner;

public class LegoPiramide {
	
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
		if(p < 2) {
			return 0;
		}else {
			return (p/2) * (p/2) + piramide(p-2);
		}
		
	}

}
