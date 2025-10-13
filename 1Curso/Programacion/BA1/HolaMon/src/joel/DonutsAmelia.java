package joel;

import java.util.Scanner;

public class DonutsAmelia {

	public static void main(String[] args) {
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
