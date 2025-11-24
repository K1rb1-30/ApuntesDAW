package introllistes;

import java.util.ArrayList;
import java.util.Scanner;

public class frequencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			
			int k = sc.nextInt();
			
			ArrayList<Integer> llistaInts = new ArrayList<>();
			
			int[] listacontador = new int[10];
			
			for(int e = 0; e < k; e++) {
				llistaInts.add(sc.nextInt());
			}
			
			for(int lista = 0; lista < llistaInts.size(); lista++) {
				listacontador[llistaInts.get(lista)] += 1;
			}
			
			for(int j = 0; j < listacontador.length; j++) {
				System.out.print(listacontador[j] + " ");
			}
			
			System.out.println();
		}

	}

}
