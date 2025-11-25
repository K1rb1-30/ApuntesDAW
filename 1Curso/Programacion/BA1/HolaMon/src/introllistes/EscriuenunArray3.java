package introllistes;

import java.util.ArrayList;
import java.util.Scanner;

public class EscriuenunArray3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean flag = false;
		
		ArrayList<Integer> lista = new ArrayList<>();
		
		while(!flag) {
			
			int numero = sc.nextInt();
			
			if(numero != -1) {
				lista.add(numero);
				
			}else {
				flag = true;
			}
		}
		
		int posicion = sc.nextInt();
		
		System.out.println(lista);
		System.out.println(lista.get(posicion));
		
	}

}
