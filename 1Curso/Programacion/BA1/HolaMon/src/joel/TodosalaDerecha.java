package joel;

import java.util.Scanner;

public class TodosalaDerecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int tamany = sc.nextInt();
		
		int[] derecha = new int[tamany];
		
		for(int i = 0; i < tamany; i++) {
			int numero = sc.nextInt();
			if(i < (tamany - 1)) {
				derecha[i+1] = numero;
			}else {
				derecha[i-i] = numero;
			}
			
		}
		
		for(int e = 0; e < derecha.length; e++) {
			System.out.print(derecha[e]+ " ");
		}
		

	}

}