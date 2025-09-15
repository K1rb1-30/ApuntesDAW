package inici;
import java.util.Scanner;

public class EstimatScanner {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //Declara el objecto de Scanner para hacer el input
		
		System.out.println("Escriu una frase");
		
		String frase=sc.nextLine(); // Para dejar que se pueda escribir
		
		System.out.println(frase);
		
		
		System.out.println("Escriu un enter");
		
		int a =sc.nextInt(); // Para dejar que se pueda escribir
		
		System.out.println(a);
		
		
		System.out.println("Escriu otra frase");
		
		
		sc.nextLine(); // Esto es porque despues de un entero se llevara el enter de antes
		String frase2=sc.nextLine(); // Para dejar que se pueda escribir
		
		System.out.println(frase2);
		
		
		
		sc.close(); //Termina el objecto de Scanner
		

	}

}
