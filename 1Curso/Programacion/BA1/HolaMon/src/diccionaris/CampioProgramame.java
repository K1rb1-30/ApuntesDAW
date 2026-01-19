package diccionaris;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class CampioProgramame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			LinkedHashMap<String, Integer> dic = new LinkedHashMap<>();
			
			int letras = sc.nextInt();
			
			sc.nextLine();
			
			String busca = null;
			
			for(int e = 0; e < letras; e++) {
				if(e + 1 == letras){
					busca = sc.nextLine();
				}else {
					String[] paises = sc.nextLine().split("-");
					if(dic.containsKey(paises[1])) {
						int cont = dic.get(paises[1]);
						dic.put(paises[1], cont + 1);
					}else {
						dic.put(paises[1], 1);
					}
				}
			}
			
			System.out.println(dic.getOrDefault(busca, 0));
			
			
		}

	}

}
