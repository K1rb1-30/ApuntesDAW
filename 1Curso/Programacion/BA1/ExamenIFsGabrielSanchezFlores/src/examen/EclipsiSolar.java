package examen;

import java.util.Scanner;

public class EclipsiSolar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int dias = sc.nextInt();
		
		int parcial = dias % 183;
		
		int total = dias % 548;
		
		int diferencia = 0;
		
		//Calculamos cuantos años han pasado si han pasado 2 parciales significa que el total esta mas cerca.
		int diaexacte = dias % 365;
		
		
		/*
		System.out.println(parcial);
		System.out.println(total);
		System.out.println(anyspasats);
		System.out.println(diaexacte);
		*/
		
		if(parcial != 0 && diaexacte < 183) {
			diferencia = 183 - parcial;
		}else if (total != 0 && diaexacte > 183) {
			diferencia = 548 - total;
		}
		
		
		
		if(parcial == 0) {
			System.out.println("PARCIAL " + parcial);
		} else if (total == 0) {
			System.out.println("TOTAL " + total);
		}else {
			System.out.println("NO " + diferencia);
		}

	}

}
