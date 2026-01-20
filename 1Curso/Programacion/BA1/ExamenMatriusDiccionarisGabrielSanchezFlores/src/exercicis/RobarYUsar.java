package exercicis;


import java.util.Scanner;
import java.util.TreeMap;

public class RobarYUsar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean sigue = true;
		boolean acabado = false;
		TreeMap<String, Integer> nombresdic = new TreeMap<>();
		
		
		int inventariple = 0;
		int inventaribuit = 0;
		
		while(sigue) {
			String frase = sc.nextLine();
			
			
			if(frase.equals("FI")) {
				sigue = false;
			}else {
				String[] nombre = frase.split(" ");
				String tipo = nombre[0];
				String elemento = nombre[1];
				
				if(tipo.equals("ROBAR")) {
					if(nombresdic.containsKey(elemento)) {
						if(nombresdic.get(elemento) < 5) {
							int valor = nombresdic.get(elemento);
							nombresdic.put(elemento, valor + 1);
						}
					}else {
						nombresdic.put(elemento, 1);
					}
				
				}else if(tipo.equals("USAR")) {
					if(nombresdic.containsKey(elemento)) {
						if(nombresdic.get(elemento) > 0) {
							int valor = nombresdic.get(elemento);
							nombresdic.put(elemento, valor - 1);
						}
					}
				}
				
			}	
		}
		
		for(String s: nombresdic.keySet()) {
			if(nombresdic.get(s) == 5) {
				inventariple++;
			}else if(nombresdic.get(s) == 0) {
				inventaribuit++;
			}
		}
		
		
		
		System.out.println(nombresdic);
		System.out.println("Inventari ple: " + inventariple);
		System.out.println("Inventari buit: " + inventaribuit);
		
		
	}

}
