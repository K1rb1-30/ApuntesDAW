package joel;

import java.util.Scanner;

public class Iron4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String tecla = sc.nextLine();
		
		switch(tecla) {
		case "Q":
			System.out.println("Skill 1");
			break;
		case "W":
			System.out.println("Skill 2");
			break;
		case "E":
			System.out.println("Skill 3");
			break;
		case "R":
			System.out.println("Ultimate");
			break;
		case "B":
			System.out.println("Recall");
			break;
		case "D":
			System.out.println("Bronzes never use summoners");
			break;
		case "F":
			System.out.println("Bronzes never use summoners");
			break;
		default:
			System.out.println("Error");
		}

	}

}
