package examenprova;

import java.util.Scanner;

public class Parelles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int primer = sc.nextInt();
		int segon = sc.nextInt();
		int tercer = sc.nextInt();
		
		if(primer == segon && tercer == 0 || primer == 0 && segon == tercer || segon == 0 && tercer == primer) {
			System.out.println("TRIO");
		} else if (primer == segon || segon == tercer || tercer == primer || primer == 0 || segon == 0 || tercer == 0) {
			System.out.println("PARELLA");
		} else {
			System.out.println("RES");
		}
		
		
		/*
		 * 
 		if(primer == 0 || segon == 0) {
			primer = segon;
		}else if (tercer == 0) {
			tercer = segon;
		}
		
		
		if( primer == segon && segon == tercer) {
			System.out.println("TRIO");
		} else if (primer == segon || segon == tercer || tercer == primer) {
			System.out.println("PARELLA");
		} else {
			System.out.println("RES");
		}
		*/
		
	
	}

}
