package examen;

import java.util.Scanner;

public class Butlletins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
				
				String departament = sc.nextLine();
				
				switch(departament) {
				case "RECURSOS HUMANS":
				case "SECRETARIA":
					System.out.println("INFORME " + departament);
					break;
				case "INFORMATICA":
					System.out.println("GASETA " + departament);
					break;
				case "DIRECCIO":
					System.out.println("BUTLLETI " + departament);
					break;
				case "LOGISTICA":
					System.out.println("COMUNICAT " + departament);
					break;
				case "I+D":
					System.out.println("SETMANAL " + departament);
					break;
				default:
					System.out.println("Desconec el departament de " + departament);
				
				}

	}

}
