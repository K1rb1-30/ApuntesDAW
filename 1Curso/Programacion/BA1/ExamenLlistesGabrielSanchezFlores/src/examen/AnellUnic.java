package examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class AnellUnic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int nombre = sc.nextInt();
		
		sc.nextLine();
		
		ArrayList<String> candidats = new ArrayList<>();
		
		for(int i = 0; i < nombre; i++) {
			candidats.add(sc.nextLine());
		}
		
		LinkedHashSet<String> eliminats = new LinkedHashSet<>();
		
		for(int e = 0; e < nombre -1 ; e++) {
			
			int moure = sc.nextInt();
			
			Collections.rotate(candidats, moure);
			
			String ultimo = candidats.get(candidats.size() - 1);
			
			
			if(candidats.size() == 1) {
				
			}else {
				candidats.remove(ultimo);
				if(candidats.contains(ultimo)) {
					candidats.remove(ultimo);
				}
				eliminats.add(ultimo);
			}
			
			
		}
		
		
		
		System.out.print("Han estat descartats: ");
		
		for (String j : eliminats) {
			System.out.print(j + " ");
		}
		
		System.out.println();
		
		System.out.println("el portador de l'Anell Únic és: " + candidats.get(0));

	}

}
