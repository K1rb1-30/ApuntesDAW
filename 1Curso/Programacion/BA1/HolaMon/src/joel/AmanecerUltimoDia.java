package joel;

import java.util.Scanner;

public class AmanecerUltimoDia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int segundos = sc.nextInt();
		
		int dia = segundos / 86400;
		
		int etapa = segundos % 86400;
		
		if (etapa < 43200) {
			System.out.println("mati del dia " + (dia + 1));
		}else {
			System.out.println("nit del dia " + (dia + 1));
		}
		
		
	}

}
