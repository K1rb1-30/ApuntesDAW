package joel;

import java.util.Scanner;

public class JordiWhile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int strikes = 0;
		int videos = 0;
		
		while(strikes < 3) {
			int numero = sc.nextInt();
			if (numero <= -1) {
				strikes++;
			}else {
				videos+= numero;
			}
		}
		System.out.println(videos);

	}

}
