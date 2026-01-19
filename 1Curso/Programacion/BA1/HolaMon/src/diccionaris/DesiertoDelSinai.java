package diccionaris;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class DesiertoDelSinai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		
		for (int i = 0; i < casos; i++) {
			
			LinkedHashMap<String, Integer> mapas = new LinkedHashMap<>();
			
			int nmapas = sc.nextInt();
			
			sc.nextLine();
			
			
			for(int e = 0; e < nmapas; e++) {
				String mapanombre = sc.nextLine();
				if(mapas.containsKey(mapanombre)) {
					int valor = mapas.get(mapanombre);
					mapas.put(mapanombre, valor + 1);
				}else {
					mapas.put(mapanombre, 1);
				}
			
			}
			
			String masvotado = null;
			int valormas = 0;
			
			for(String s : mapas.keySet()) {
				if(mapas.get(s) > valormas) {
					valormas = mapas.get(s);
					masvotado = s;
				}
			}
			
			System.out.println(masvotado);
			
			
		}

	}

}