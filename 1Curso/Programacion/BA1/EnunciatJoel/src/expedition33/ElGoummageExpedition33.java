package expedition33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ElGoummageExpedition33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			int npersonas = sc.nextInt();
			int goummage = sc.nextInt();
			
			sc.nextLine();
			String[] listapersonas = new String[npersonas];
			String[] solonombres = new String[npersonas];
			int[] soloedad = new int[npersonas];
			
			
			for (int j = 0; j < npersonas; j++) {
				String nom = sc.next();
				int edat = sc.nextInt();
				
				listapersonas[j] = nom + "(" + edat + ")";
				solonombres[j] = nom;
				soloedad[j] = edat;
				
			}
			
			System.out.println(Arrays.toString(listapersonas));
			
			for (int e = 0; e < listapersonas.length; e++) {
				int nexpedicio = (goummage - soloedad[e]) / 2;
				int desapareix = soloedad[e] + nexpedicio;
				System.out.println(solonombres[e] + " -> desapareix a edat " + desapareix + ", expedició " + nexpedicio);
			}
			
			
			
		}
	}
	
	public static ArrayList<String> resolverCaso(int G, String[] nombres, int[] edades) {
		ArrayList<String> resultado = new ArrayList<>();
        
        for (int i = 0; i < nombres.length; i++) {
            int Y = (G - edades[i]) / 2;
            int X = edades[i] + Y;
            resultado.add(nombres[i] + " -> desapareix a edat " + X + ", expedició " + Y);
        }
        
        return resultado;
    }

}
