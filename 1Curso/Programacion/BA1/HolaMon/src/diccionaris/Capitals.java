package diccionaris;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Capitals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		
		for (int i = 0; i < casos; i++) {
			
			LinkedHashMap<String, String> dic = new LinkedHashMap<>();
			
			int letras = sc.nextInt();
			
			sc.nextLine();
			
			String busca = null;
			
			for(int e = 0; e < letras; e++) {
				if(e + 1 == letras){
					busca = sc.nextLine();
				}else {
					String[] paises = sc.nextLine().split("-");
					String pais = paises[0];
					String capital = paises[1];
					dic.put(pais, capital);
				}
			}
			
			if( dic.containsKey(busca)) {
				System.out.println(dic.get(busca));
			}else {
				System.out.println("NO HO SE");
			}
			
			
		}

	}

}
