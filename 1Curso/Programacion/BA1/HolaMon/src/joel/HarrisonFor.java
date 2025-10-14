package joel;

import java.util.Scanner;

public class HarrisonFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int dinero = sc.nextInt();
		
		int dividir = dinero / 1000000;
		
		int diseparado = 0;
		
		if(dinero >= 1000000) {
			for(int i = 0; i < dividir; i++) {
				diseparado += 1000000;
				System.out.println(diseparado);
			}
		}
	}

}
