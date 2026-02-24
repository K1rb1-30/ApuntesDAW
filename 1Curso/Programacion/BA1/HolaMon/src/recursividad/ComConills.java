package recursividad;

import java.util.Scanner;

public class ComConills {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			int p = sc.nextInt();
			
			System.out.println(Fibonacci(p));
		
		}
	}
	private static int Fibonacci(int n) {
		// TODO Auto-generated method stub
		if(n < 2) {
			return n;
		}
		
		return Fibonacci(n - 2) + Fibonacci(n - 1);
	}
}
