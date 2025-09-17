package inici;

import java.util.Scanner;

public class EstimatSwitch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String personalitat = sc.nextLine();
		
		switch(personalitat) {
		case "Coratge":
			System.out.println("Gryffindor");
			break; //Para salir del switch es obligatorio tenerlo
		case "Coneixement":
			System.out.println("Ravenclaw");
			break;
		case "Ambicio":
			System.out.println("Slythering");
			break;
		default:
			System.out.println("Hufflepuff");
		}
		
		

	}

}
