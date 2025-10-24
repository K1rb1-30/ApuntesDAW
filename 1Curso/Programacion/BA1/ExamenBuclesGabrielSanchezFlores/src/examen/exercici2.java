package examen;

import java.util.Scanner;

public class exercici2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		long capacitat = sc.nextLong();
		
		int rondes = sc.nextInt();
		
		long max = 0;
		long finales = 0;
		
		
		boolean error = false;
		
		for(int i = 0; i < rondes; i++) {
			
			long e = sc.nextLong();
			long s = sc.nextLong();
			long maximofor = e;
			if(maximofor > max) {
				max = maximofor;
			}
			finales += e - s;
			if(e < s || finales > capacitat) {
				error = true;
			}
		
		}
		if(error == false) {
			
			System.out.println("MAX " + max);
		
			System.out.println("FINAL " + finales);
			
		}else {
			System.out.println("ERROR");
		}
		

	}

}
