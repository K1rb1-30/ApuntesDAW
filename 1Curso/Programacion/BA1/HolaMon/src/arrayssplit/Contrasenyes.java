package arrayssplit;

import java.util.Arrays;
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
			
		}
		
		for(int r = 0; r < vectorT; r++) {
			listacontrasenyas[r] = sc.next();
		}
		
		
		int vectorN = sc.nextInt();
		
		for(int e = 0; e < vectorN; e++) {
			String comprouser = sc.next();
			String comprocontrase = sc.next();
			
			boolean userencontrado = false;
			boolean pswdencontrado = false;
			
			for(int q = 0; q < listapalabras.length; q++) {
				if(comprouser.equals(listapalabras[q])) {
					userencontrado = true;
				}
			}
			
			for(int t = 0; t < listapalabras.length; t++) {
				if(comprocontrase.equals(listacontrasenyas[t])) {
					pswdencontrado = true;
				}
			}
			
			if(!userencontrado) {
				System.out.println("usuari no trobat");
			}else if (userencontrado && !pswdencontrado) {
				System.out.println("contrasenya incorrecte");
			}else if (userencontrado && pswdencontrado) {
				System.out.println("OK");
			}
		}
		
		Arrays.sort(listapalabras);
		
		for(int u = 0; u < listapalabras.length; u++) {
			System.out.print(listapalabras[u] + " ");
		}
		
		
	}

}
