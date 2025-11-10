package arrays;

import java.util.Scanner;

public class ParchisParchis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {
			int inicial = sc.nextInt();

			int[] dados = new int[3];

			int actual = inicial;

			for (int e = 0; e < 3; e++) {
				dados[e] = sc.nextInt();
			}

			for (int j = 0; j < dados.length; j++) {

				if (actual != 8) {
					actual = actual + dados[j];
					if (actual > 8) {
						int resto = actual - 8;
						actual = 8 - resto;
					}
				}

			}

			System.out.println(actual);

		}

	}

}
