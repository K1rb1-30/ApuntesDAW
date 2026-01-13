package examenprovamatriusdiccionaris;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Clasesterrorist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		
		LinkedHashMap<String, Integer> dic = new LinkedHashMap<>();
		
		for (int i = 0; i < casos; i++) {
			String key = sc.next();
			int valorterr = sc.nextInt();
			
			if(dic.containsKey(key)) {
				int valor = dic.get(key);
				dic.put(key, valor + valorterr);
			}else {
				dic.put(key, valorterr);
			}
				
		}
		
		for (String s : dic.keySet()) {
			
			if(dic.get(s) > 0) {
				System.out.print(s);
			}
			
			System.out.println();
		}
		

	}

}
