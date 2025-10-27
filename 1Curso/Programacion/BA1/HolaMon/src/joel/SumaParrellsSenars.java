package joel;

import java.util.Scanner;

public class SumaParrellsSenars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		int parells = 0;
		int senars = 0;
		
		for(int i = 0; i < casos; i++) {
			int numero = sc.nextInt();
			
			if(numero % 2 == 0) {
				parells++;
			}else {
				senars++;
			}
		}
		
		System.out.print("PARELLS: " + parells);
		System.out.print(" SENARS: " + senars);

	}

}
