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
			dic.put(paises[0], paises[1]);
		}
		
		
		int contador = 500;
		String buscar = sc.nextLine();
		while(!buscar.equals("DIE")) {
			
				if(dic.containsKey(buscar)) {
					dic.remove(buscar);
				}else if(dic.containsValue(buscar)) {
					
					String key = "";
					
					for(String s : dic.keySet()) {
						if(dic.get(s).equals(buscar)) {
							key = s;
						}
					}
					
					dic.remove(key);
					
				}else {
					String[] palabra = buscar.split("");
					if(buscar.charAt(0) == 'N') {
						dic.put(buscar, "Nom Ocult");
					}else {
						String keyrandom = "N" + contador;
						dic.put(keyrandom, buscar);
						contador++;
						
					}
				}
				
				buscar = sc.nextLine();
			}
		
		System.out.println(dic);
		
		

	}

}
