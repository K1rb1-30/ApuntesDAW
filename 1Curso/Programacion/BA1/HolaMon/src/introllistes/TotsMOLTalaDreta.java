package introllistes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TotsMOLTalaDreta {

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
			
			
			int derecha = sc.nextInt();
			
			Collections.rotate(lista, derecha);
			
			for(Integer numero : lista) {
				System.out.print(numero + " ");
			}
			
			System.out.println();
	}

}
}
