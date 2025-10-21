package joel;

import java.util.Scanner;

public class DobleBucle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 1; i <= casos; i++ ) {
			
			
			for(int e = i; e >= 1; e--)
				
				System.out.print(e);
		}

	}

}
