package introllistes;

import java.util.ArrayList;
import java.util.Scanner;

public class Repetits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int a = 0; a < casos; a++) {
			
			int capacidad = sc.nextInt();
			
			ArrayList<Integer> lista = new ArrayList<>();
			
			for(int e = 0; e < capacidad; e++) {
				lista.add(sc.nextInt());
			}
			
			int contador = 0;
			
			for(Integer numero : lista) {
				contador = 0;
				if(lista.contains(numero)) {
					contador++;
				}
			}
			
			System.out.println(contador);
			
			if(contador != 1) {
				System.out.println("SI");
			}else {
				System.out.println("NO");
			}
			
		}

	}

}
