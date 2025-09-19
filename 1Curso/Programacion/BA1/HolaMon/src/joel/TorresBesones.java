package joel;

import java.util.Scanner;

public class TorresBesones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double primeratorre = sc.nextDouble();
		
		sc.nextLine();
		
		double segundatorre = sc.nextDouble();
		
		double diferencia;
		
		if (primeratorre > segundatorre) {
			 diferencia = primeratorre - segundatorre;
			
		}else {
			diferencia = segundatorre - primeratorre;
		}
		
		if (diferencia <= 5) {
			System.out.println("SI");
		}else {
			System.out.println("NO");
		}
		
		
				

	}

}
