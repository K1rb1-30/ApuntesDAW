package joel;

import java.util.Scanner;

public class FelicitatAscendent {

	public static void main(String[] args) {
		int f1;
		int f2;
		int f3;
		
		Scanner sc = new Scanner(System.in);
		
		f1 = sc.nextInt(); // declarem i donem valor a la variable frase llegint un string amb el nextLine des de teclat
		
		sc.nextLine();
	
		f2 = sc.nextInt(); // declarem i donem valor a la variable frase llegint un string amb el nextLine des de teclat
		
		sc.nextLine();
		
		f3 = sc.nextInt();
		
		if(f1 < f2 && f2 < f3) {
			System.out.println("SI");
		}else {
			System.out.println("NO");
		}
		sc.close();
	}

}
