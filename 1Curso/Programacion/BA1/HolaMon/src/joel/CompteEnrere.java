package joel;

import java.util.Scanner;

public class CompteEnrere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int compte = sc.nextInt();
		
		for(int i = compte; i >= 0; i = i - 1) {
			System.out.println(compte);
			compte = compte - 1;
			
		}
		
}}