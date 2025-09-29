package examenprova;

import java.util.Scanner;

public class Bambi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String paraula = sc.nextLine();
		
		switch(paraula) {
		case "GANDHI":
		case "DANDY":
		case "DAMM VI":
			System.out.println("DAMvi");
			break;
		case "YA VA":
		case "LLAMA":
			System.out.println("JAVA");
			break;
		case "EL RESULTAT ENS DONA":
			System.out.println("MERCADONA");
			break;
		default:
			System.out.println(paraula);
		
		}
			
		
	}

}
