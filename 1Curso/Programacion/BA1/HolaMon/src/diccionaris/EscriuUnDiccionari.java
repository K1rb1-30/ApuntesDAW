package diccionaris;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class EscriuUnDiccionari {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		
		LinkedHashMap<String, String> dic = new LinkedHashMap<>();
		
		for (int i = 0; i < casos; i++) {
			dic.put(sc.next(), sc.next());
		}
		sc.nextLine();
		String nom = sc.nextLine();
		
		System.out.println(dic);
		System.out.println(dic.get(nom));

	}

}
