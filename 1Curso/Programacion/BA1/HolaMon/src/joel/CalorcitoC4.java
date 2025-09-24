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
		
		if (temperatura > 25 && comandament.equals("SI")) {
			System.out.println("Aire");	
		} else if (alumnos > 15) {
			if (temperatura > 22 && temperatura <= 25) {
				if (comandament.equals("SI")) {
					System.out.println("Aire");
				}else {
					System.out.println("Obrir finestra");
				}
			} else if (temperatura >18) {
				System.out.println("Obrir finestra");
			}else {
				System.out.println("Res");
			}
	} else {
		System.out.println("Res");
	}

	}
}
