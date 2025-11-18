package arrayssplit;

import java.util.Scanner;

public class Contrasenyes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int vectorT = sc.nextInt();
		
		String[] listapalabras = new String[vectorT];
		String[] listacontrasenyas = new String[vectorT];
		
		for(int i = 0; i < vectorT; i++) {
			listapalabras[i] = sc.next();
			listacontrasenyas[i] = sc.next();
			
		}
		
		int vectorN = sc.nextInt();
		
		for(int e = 0; e < vectorN; e++) {
			String comprouser = sc.next();
			String comprocontrase = sc.next();
			
			
		}
		
	}

}
