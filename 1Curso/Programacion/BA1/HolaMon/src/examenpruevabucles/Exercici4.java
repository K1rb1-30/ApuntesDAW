package examenpruevabucles;

import java.util.Scanner;

public class Exercici4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int parell = 0;
		int senar = 0;
		int nombre = 0;
		boolean magia = false;
		String ganador = "";
		
		while (nombre >=0) {
			nombre = sc.nextInt();
			
			if(nombre != -1) {
				if(nombre % 2 == 0) {
					parell+= nombre;
				}else if(nombre % 2 != 0) {
					senar+=nombre;
				}
				
				if(nombre == 73) {
					magia = true;
				}
				
				if(magia == false) {
					if(parell > senar) {
						ganador = "PARELLS";
					}else if(parell < senar) {
						ganador = "SENARS";
					}
				}else if (magia == true){
					ganador = "MAGIA";
				}
			}
			
		}
		
		System.out.println(ganador);

	}

}
