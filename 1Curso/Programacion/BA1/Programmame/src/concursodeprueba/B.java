package concursodeprueba;

import java.util.ArrayList;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int ramal = sc.nextInt();
		
		while(ramal != 0) {
			
			ArrayList<String> listageneral = new ArrayList<>();
			
			
			for(int i = 0; i < ramal; i++) {
				
				
				
				String texto = sc.nextLine();
				
				String[] lista = texto.split(" ");
				
				String propietario = lista[0];
				
				String lado = lista[1];
				
				int distancia = Integer.parseInt(lista[2]);
			}
			
			System.out.println("---");
			
			
			
		}
		

	}

}
