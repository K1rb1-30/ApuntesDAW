package joel;

import java.util.Scanner;

public class DiguesPatata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int veces = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < veces; i++ ) {
			String patata = sc.nextLine();
			System.out.println(patata);
			
		}

	}

}
