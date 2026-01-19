package diccionaris;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class ProblemesDiferencial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();
		sc.nextLine();

		LinkedHashMap<String, Boolean> interruptores = new LinkedHashMap<>();

		String estropeado = sc.nextLine();

		int contrue = 0;
		int confalse = 0;

		for (int i = 0; i < casos-1; i++) {

			String zona = sc.nextLine();
			if (zona.equals(estropeado)) {
				for (String s : interruptores.keySet()) {
					interruptores.put(s, false);
				}
			} else if (interruptores.containsKey(zona)) {
				if (interruptores.get(zona) == true) {
					interruptores.put(zona, false);
				} else {
					interruptores.put(zona, true);
				}
			} else {
				interruptores.put(zona, true);
			}

		}
		
		for (String e : interruptores.keySet()) {
			if (interruptores.get(e) == false) {
				confalse++;
			} else {
				contrue++;
			}
		}

		System.out.println(contrue + " " + confalse);

	}
}
