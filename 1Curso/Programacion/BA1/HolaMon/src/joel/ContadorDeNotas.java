package joel;

import java.util.Scanner;

public class ContadorDeNotas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int notas = 0;
		float mitjana = 0;
		int e = 0;
		int n = 0;
		int b = 0;
		int s = 0;
		int i = 0;
		int md = 0;
		int numero = 1;
		
		while (numero >= 0) {
			numero = sc.nextInt();
			if(numero <= 10 && numero >= 0) {
				notas++;
				mitjana += numero;
				if(numero >= 9) {
					e++;
				}else if(numero >= 7) {
					n++;
				}else if(numero == 6) {
					b++;
				}else if(numero == 5) {
					s++;
				}else if(numero < 5 && numero > 3) {
					i++;
				}else if(numero < 3) {
					md++;
				}
			}	
		}
		
		mitjana = mitjana / notas;
		
		System.out.print("NOTES: "+ notas);
		System.out.print(" MITJANA: " + mitjana);
		System.out.print(" E: " + e);
		System.out.print(" N: " + n);
		System.out.print(" B: " + b);
		System.out.print(" S: " + s);
		System.out.print(" I: " + i);
		System.out.print(" MD: " + md);
		
	}

}
