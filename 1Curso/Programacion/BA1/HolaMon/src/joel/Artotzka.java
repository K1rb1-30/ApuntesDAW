package joel;

import java.util.Scanner;

public class Artotzka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int familia = sc.nextInt();
		int[] miembros = new int[familia];
		int comptador = 0;
		
		
		for(int i = 0; i < familia; i++){
			miembros[i] = sc.nextInt(); 
			}
		
		int tope = sc.nextInt();
		
		for(int miembro : miembros) {
			if(miembro < tope) {
				comptador++;
			}
		
		}
		
		System.out.println(comptador);
	}

}
