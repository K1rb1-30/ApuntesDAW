package examenprova;

import java.util.Scanner;

public class FullRestore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int hp = sc.nextInt();
		int max_hp = sc.nextInt();
		int status = sc.nextInt();

		if (hp == 0) {
			System.out.println("DEBILITAT");
		} else if (hp > 0) {
			if (hp < max_hp) {
				if (status == 0) {
					hp = max_hp;
					System.out.println("CURAR");
				} else if (status != 0) {
					hp = max_hp;
					status = 0;
					System.out.println("CURAR I ESTAT");
				}
			} else if (hp == max_hp) {
				if (status == 0) {
					System.out.println("RES");
				} else if (status != 0) {
					status = 0;
					System.out.println("ESTAT");
				}
			}

		}

	}

}
