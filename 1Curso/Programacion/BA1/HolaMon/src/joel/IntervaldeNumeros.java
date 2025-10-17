package joel;

import java.util.Scanner;

public class IntervaldeNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int numero1 = sc.nextInt();
		
		int numero2 = sc.nextInt();
		
		if(numero1 >= numero2) {
			for(int i = numero1; i >= numero2; i-- ) {
				System.out.println(i);
			}
		}else {
			System.out.println("El segon numero no es mes petit que el primer");
		}
		
		
	}

}
