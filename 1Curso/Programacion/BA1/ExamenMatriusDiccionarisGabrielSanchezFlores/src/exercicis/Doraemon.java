package exercicis;

import java.util.Scanner;

public class Doraemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner sc = new Scanner(System.in);
		
		int files = sc.nextInt();
		int columnes = sc.nextInt();
		
		int[][] mat = new int[files][columnes];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j]=sc.nextInt();
			}
		}
		
		int buscarfila = sc.nextInt();
		int buscarcolumna = sc.nextInt();
		
		int dreta = 0;
		int esquerra = 0;
		int amunt = 0;
		int avall = 0;
		
		int nada = mat[buscarfila][buscarcolumna];
		
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i mirem la fila
			if(!esticFora(mat, buscarfila, buscarcolumna + i + 1)) {
				dreta += mat[buscarfila][buscarcolumna + i + 1];
			}
		}
		
		System.out.println(dreta);
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i mirem la fila
			if(!esticFora(mat, buscarfila, buscarcolumna - i -1)) {
				esquerra += mat[buscarfila][buscarcolumna - i -1];
			}
		}
		
		System.out.println(esquerra);
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i mirem la fila
			if(!esticFora(mat, buscarfila + i +1 , buscarcolumna)) {
				avall += mat[buscarfila + i +1 ][buscarcolumna];
			}
		}
		
		System.out.println(avall);
		
		for (int i = 0; i < mat[0].length; i++) {// ens movem per les columnes i mirem la fila
			if(!esticFora(mat, buscarfila - i -1, buscarcolumna)) {
				amunt += mat[buscarfila - i -1][buscarcolumna];
			}
		}
		
		System.out.println(amunt);
		
		
		if(dreta > esquerra && dreta > amunt && dreta > avall && dreta > nada) {
			System.out.println("DRETA");
		}else if(esquerra > dreta && esquerra > amunt && esquerra > avall && esquerra > nada) {
			System.out.println("ESQUERRA");
		}else if(amunt > dreta && amunt > esquerra && amunt > avall && amunt > nada) {
			System.out.println("AMUNT");
		}else if(avall > dreta && avall > esquerra && avall > amunt && avall > nada) {
			System.out.println("AVALL");
		}else if(nada > dreta && nada > esquerra && nada > amunt && nada > avall) {
			System.out.println("NO SORTIR");
		}
		
		
		
		
		
		
	}
	
	private static boolean esticFora(int[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}
	}

}
