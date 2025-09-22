package joel;

import java.util.Scanner;

public class PokerDaus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			
		int a = sc.nextInt();
		
		int b = sc.nextInt();
		
		int c = sc.nextInt();
		
		int d = sc.nextInt();
		
		

			if (a == b && b == c && c == d ) {
				System.out.println("POKER");
			} else if (a == b && b == c || a == b && b == d || a == c && c == d || b == c && c == d) {
				System.out.println("TRIO");
			} else if (a == b || a == c || a == d || b == c || b == d || c == d) {
				System.out.println("PARELLA");
			} else {
				System.out.println("RES");
			}
		
		

	}

}
