package joel;

import java.util.Scanner;

public class Ambrosio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int j = 1; j <= casos; j++) {
			
			int pisos = sc.nextInt();
			
			double bombones = 0;
			
					
			for(double i = 1; i <= pisos; i++) {
				bombones = bombones + Math.pow(i, 2);
				
			}
			int bombonesint = (int)bombones;
			System.out.println(bombonesint);
		}

	}

}
