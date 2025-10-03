package examen;

import java.util.Scanner;

public class Aprovo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		double mitjana = (num1 + num2 + num3) / 3;
		
		//System.out.println(mitjana);
		
		
		if(num1 == 0 || num2 == 0 || num3 == 0) {
			System.out.println("SUSPES");
		} else if (num3 != 10 && num3 != 9) { 
			if (mitjana >= 5 && (num1 >= 4 && num2 >= 4 && num3 >= 4)) {
				System.out.println("APROVAT");
			}else {
				System.out.println("SUSPES");
			}
			
			}else {
				System.out.println("APROVAT FINAL");
		}
	}

}
