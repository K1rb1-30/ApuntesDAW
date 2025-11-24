package introllistes;

import java.util.ArrayList;
import java.util.Scanner;

public class Colarse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int a = 0; a < casos; a++) {
			
			int capacidad = sc.nextInt();
			
			ArrayList<Integer> lista = new ArrayList<>();
			ArrayList<Integer> valores = new ArrayList<>();
			
			for(int e = 0; e < capacidad; e++) {
				lista.add(sc.nextInt());
			}
			
			

	}

}}
