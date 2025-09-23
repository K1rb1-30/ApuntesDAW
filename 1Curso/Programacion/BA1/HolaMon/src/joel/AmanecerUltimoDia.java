package joel;

import java.util.Scanner;

public class AmanecerUltimoDia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int segundos = sc.nextInt();
		
		int horas = segundos / 43200;
		
		if(horas < 1) {
			System.out.println("mati del dia 1");
		}else if(horas >= 1 && horas < 2) {
			System.out.println("nit del dia 1");
		}else if(horas >= 2 && horas < 3) {
			System.out.println("mati del dia 2");
		}else if(horas >= 3 && horas < 4) {
			System.out.println("nit del dia 2");
		}else if(horas >= 4 && horas < 5) {
			System.out.println("mati del dia 3");
		}else if(horas >= 5 && horas < 6) {
			System.out.println("nit del dia 3");
		}else if(horas >= 6 && horas < 7) {
			System.out.println("mati del dia 4");
		}else if(horas >= 7 && horas < 8) {
			System.out.println("nit del dia 4");
		}else if(horas >= 8 && horas < 9) {
			System.out.println("mati del dia 5");
		}else if(horas >= 9 && horas < 10) {
			System.out.println("nit del dia 5");
		}
	}

}
