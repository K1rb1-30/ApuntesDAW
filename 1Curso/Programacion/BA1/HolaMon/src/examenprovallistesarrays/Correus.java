package examenprovallistesarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Correus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int quantitat = sc.nextInt();
		
		sc.nextLine();
		
		ArrayList<String> listaNombres = new ArrayList<>();
		ArrayList<String> listaCognoms = new ArrayList<>();
		ArrayList<String> listaAnys = new ArrayList<>();
		
		for(int i = 0; i < quantitat; i++) {
			listaNombres.add(sc.next().toLowerCase());
		}
		
		for(int e = 0; e < quantitat; e++) {
			listaCognoms.add(sc.next().toLowerCase());
		}
		
		for(int j = 0; j < quantitat; j++) {
			listaAnys.add(sc.next());
		}
		
		ArrayList<String> correus = new ArrayList<>();
		
		for(int y = 0; y < quantitat; y++) {
			
			
			String nombre = listaNombres.get(y);
			char letranom = nombre.charAt(0);
			String cognom = listaCognoms.get(y);
			String dominic = "@ies-sabadell.cat";
			
			
			String any = listaAnys.get(y);
			char anyc = any.charAt(2);
			char anyc2 = any.charAt(3);
			
			String correusinany = letranom + cognom + dominic;
			
			String correuany = letranom + cognom + anyc + anyc2 + dominic;
			
			if(correus.contains(correusinany)) {
				correus.add(correuany);
			}else {
				correus.add(correusinany);
			}
			
		}
		
		int ultimos = correus.size() -1;
		String ulti = correus.get(ultimos);
		
		Collections.sort(correus);
		//correus.set(0, ulti);
		
		System.out.println(correus);
		

	}

}
