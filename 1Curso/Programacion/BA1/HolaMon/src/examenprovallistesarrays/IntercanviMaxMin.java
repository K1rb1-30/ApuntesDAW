package examenprovallistesarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class IntercanviMaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int quantitat = 10;
		
		
		ArrayList<Integer> lista1 = new ArrayList<>();
		ArrayList<Integer> lista2 = new ArrayList<>();
		
		Random aleatori = new Random();
		
		
		for(int i = 0; i < quantitat; i++) {
			lista1.add(aleatori.nextInt(0,21));
		}
		
		for(int e = 0; e < quantitat; e++) {
			lista2.add(aleatori.nextInt(0,21));
		}
		
		System.out.println("Llista 1: "+ lista1);
		System.out.println("Llista 2: "+lista2);
		
		ArrayList<Integer> juntos = new ArrayList<>();
		
		for(Integer numero : lista1) {
			if(lista2.contains(numero)) {
				juntos.add(numero);
			}
		}
		
		System.out.println("Llista comuns: "+ juntos);
		
		int max = Collections.max(juntos);
		int min = Collections.min(juntos);
		
		int maxpos = 0;
		int minpos = 0;
		
		for(int j = 0; j < juntos.size(); j++) {
			if(juntos.get(j) == max) {
				maxpos = j;
			}
			
			if(juntos.get(j) == min) {
				minpos = j;
			}
			
		}
		
		Collections.swap(juntos, maxpos, minpos);
		
		System.out.println("Llista amb posició MAX i MIN intercanviada: " + juntos);
		
		
		

	}

}
