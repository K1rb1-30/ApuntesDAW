package examenprova;

import java.util.Scanner;

public class RAID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int horari = sc.nextInt();
		
		int dia = horari % 1440;
		
		/*
		if (horari > 1440) {
			dia = horari / 1440;
		}else {
			dia = 0;
			
			int horariactual = horari - dia * 1440;
		} */
		
		if (dia >= 1320 && dia <= 1439) {
			System.out.println("RAID");
		} else {
			System.out.println("OK");
		}

	}

}
