package joel;

import java.util.Scanner;

public class DobleBucle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int finals = sc.nextInt();
		
		for(int i = 1; i <= finals; i++) {
			for(int e = 1; e <= i; e++) {
				System.out.print(i);
			}
		}
		
		

	}

}
