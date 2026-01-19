package diccionaris;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class ElPrimerArribiA5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		boolean sigue = true;
		boolean acabado = false;
		LinkedHashMap<String, Integer> nombresdic = new LinkedHashMap<>();
		
		String primeroacabar = "No";
		
		while(sigue) {
			String nombre = sc.nextLine();
			
			if(nombre.equals("xxx")) {
				sigue = false;
			}else {
				if(nombresdic.containsKey(nombre)) {
					int valor = nombresdic.get(nombre);
					nombresdic.put(nombre, valor + 1);
				}else {
					nombresdic.put(nombre, 1);
				}
			
					for(String s: nombresdic.keySet()) {
						if(acabado==false && nombresdic.get(s) == 5) {
							primeroacabar = s;
							acabado = true;
						}
					}
			}	
		}
		
		System.out.println(primeroacabar);
		
	}

}
