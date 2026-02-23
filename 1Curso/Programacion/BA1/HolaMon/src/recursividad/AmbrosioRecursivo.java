package recursividad;

import java.util.Scanner;

public class AmbrosioRecursivo {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			int bombons = 0;
			int pisos = sc.nextInt();
			
			bombons = piramide(pisos, bombons);
			System.out.println(bombons);
			
		
		}
	}

	private static int piramide(int pisos, int bombons) {
		// TODO Auto-generated method stub
		
		if(pisos == 0) {
			return bombons;
		}else {
			return(piramide(pisos-1, bombons + pisos * pisos));
		}
	}

}
