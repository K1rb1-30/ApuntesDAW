package joel;

import java.util.Scanner;

public class DiferenciaGranPetit2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int grande = 0;
		
		if (a > b && a > c || a==b && a > c || a == c && a > b) {
			grande = a;
		} else if (b > a && b > c || b == c && b > a) {
			grande = b;
		} else if (c > a && c > b) {
			grande = c;
		}
		
		int peque = 0;
		
		if (a < b && a < c || a==b && a < c || a == c && a < b) {
			peque = a;
		} else if (b < a && b < c || b == c && b < a) {
			peque = b;
		} else if (c < a && c < b) {
			peque = c;
		}
		
		int resultado = grande - peque;
		
		System.out.println(resultado);

	}

}
