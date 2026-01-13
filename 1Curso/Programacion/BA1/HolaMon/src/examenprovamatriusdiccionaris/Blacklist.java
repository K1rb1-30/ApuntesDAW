package examenprovamatriusdiccionaris;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Blacklist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		sc.nextLine();
		
		LinkedHashMap<String, String> dic = new LinkedHashMap<>();
		
		for (int i = 0; i < casos; i++) {
			
			String[] paises = sc.nextLine().split(",");
			String pais = paises[0];
			String capital = paises[1];
			dic.put(pais, capital);
		}
		
		boolean die = false;
		
		int contador = 0;
		while(die == false) {
			String buscar = sc.nextLine();
			
			
			if(buscar == "DIE") {
				die = true;
			}else {
				if(dic.containsKey(buscar)) {
					dic.remove(buscar);
				}else if(dic.containsValue(buscar)) {
					for(Map.Entry<String,String> e: dic.entrySet()) {
						if(e.getValue() == buscar) {
							dic.remove(e, e);
						}
					}
				}else {
					String[] palabra = buscar.split("");
					if(palabra[0] == "N") {
						dic.put(buscar, "Nom Ocult");
					}else {
						String keyrandom = "50" + contador;
						dic.put(keyrandom, buscar);
						contador++;
						
					}
				}
			}
			
		}
		
		System.out.println(dic);
		
		

	}

}
