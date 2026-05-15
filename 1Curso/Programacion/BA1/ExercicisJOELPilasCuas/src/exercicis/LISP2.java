package exercicis;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LISP2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		sc.nextLine();
		
		ArrayDeque<String> cua = new ArrayDeque<String>();
		
		String[] linea = sc.nextLine().split("");
		
		boolean correcte;
		
		for(int i = 0; i < linea.length; i++) {
			if(linea[i].equals(")") || linea[i].equals("]") || linea[i].equals("}") || linea[i].equals(">")) {
				
			}else {
				cua.push(linea[i]);
			}
		}
	}

}
