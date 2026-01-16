package diccionaris;

import java.util.Scanner;
import java.util.TreeMap;

public class CercaPerValorDiccionari {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		
		for (int i = 0; i < casos; i++) {
			
			TreeMap<String, String> dic = new TreeMap<>();
			
			int letras = sc.nextInt();
			
			sc.nextLine();
			
			String busca = null;
			
			for(int e = 0; e < letras; e++) {
				if(e + 1 == letras){
					busca = sc.nextLine();
				}else {
					String[] paises = sc.nextLine().split("-");
					dic.put(paises[0], paises[1]);
				}
			}
			
			String key = "";
			
			if(dic.containsValue(busca)) {
					
					for(String s : dic.keySet()) {
						if(dic.get(s).equals(busca)) {
							key = s;
						}
					}	
				
			}
			
			System.out.println(dic);
			System.out.println(key);
			
			
		}

	}

}
