package joel;

import java.util.Scanner;

public class DiferenciaGranPetit2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int grande = 0;
		
		if (a > b && a > c) {
			grande = a;
		} else if (b > a && b > c) {
			grande = b;
		} else if (c > a && c > b) {
			grande = b;
		}
		
		int peque = 0;
		
		if (a < b && a < c) {
			peque = a;
		} else if (b < a && b < c) {
			peque = b;
		} else if (c < a && c < b) {
			peque = b;
		}
		
		int resultado = grande - peque;
		
		System.out.println(resultado);

	}

}
