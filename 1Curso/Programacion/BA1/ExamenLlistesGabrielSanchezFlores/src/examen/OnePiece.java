package examen;

import java.util.Scanner;

public class OnePiece {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String frase = sc.nextLine();
		
		String[] lista1 = frase.split("-");
		
		String illabusca = sc.nextLine();
		
		int distancia = 0;
		
		boolean encontrado = false;
		
		String rumb = null;
		
		for(int i = 0; i < lista1.length; i++) {
			
			
			String[] listamini = lista1[i].split(" ");
			
			for(String palabra : listamini) {
				if(palabra.equals(illabusca)) {
					distancia += Integer.parseInt(listamini[1]);
					rumb = listamini[0];
					encontrado = true;
					
				}
			}
			
			
			if(encontrado == false) {
				distancia += Integer.parseInt(listamini[1]);
			}
			
		}
		
		
		if(encontrado) {
			System.out.println("Illa trobada! " + "Rumb: " + rumb + ", " + "Distancia: " + distancia);
		}else {
			System.out.println("Aquesta illa no es troba al mapa");
		}
		
		
	}

}
