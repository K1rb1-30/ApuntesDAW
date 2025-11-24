package introllistes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ContrasenyesconListas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int vectorT = sc.nextInt();
		
		
		ArrayList<String> listapalabras = new ArrayList<>();
		ArrayList<String> listacontrasenyas = new ArrayList<>();
		
		for(int i = 0; i < vectorT; i++) {
			listapalabras.add(sc.next());
			
		}
		
		for(int r = 0; r < vectorT; r++) {
			listacontrasenyas.add(sc.next());
		}
		
		int vectorN = sc.nextInt();
		
		for(int e = 0; e < vectorN; e++) {
			String comprouser = sc.next();
			String comprocontrase = sc.next();
			
			boolean userencontrado = listapalabras.contains(comprouser);
			boolean pswdencontrado = listacontrasenyas.contains(comprocontrase);
			
			
			if(!userencontrado) {
				System.out.println("usuari no trobat");
			}else if (userencontrado && !pswdencontrado) {
				System.out.println("contrasenya incorrecta");
			}else if (userencontrado && pswdencontrado) {
				System.out.println("OK");
			}
		}
		
		
		Collections.sort(listapalabras);
		
		for(String lista : listapalabras) {
			System.out.print(lista + " ");
		}
		
	}

}
