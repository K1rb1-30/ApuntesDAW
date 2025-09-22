package joel;

import java.util.Scanner;

public class CalorcitoC4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int alumnos = sc.nextInt();
	
		int temperatura = sc.nextInt();
	
		sc.nextLine();
		
		String comandament = sc.nextLine();
		
		if (temperatura > 25 && comandament == "SI") {
			System.out.println("Aire");	
		}
		else if (alumnos > 15 && temperatura >18) {
				if (alumnos > 15 && temperatura >22 && temperatura <= 25 && comandament == "SI") {
					System.out.println("Aire");
				}else if (alumnos > 15 && temperatura >22 && temperatura <= 25 && comandament == "NO") {
					System.out.println("Obrir Finestra");
				}else {
					System.out.println("Obrir Finestra");
			}
			
		}else {
			System.out.println("Res");
		}
	}

}
