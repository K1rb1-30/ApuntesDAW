package examenpruevabucles;

import java.util.Scanner;

public class Exercici1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int rondes = sc.nextInt();
		int a = 0;
		int b = 0;
		int boomers = 0;
		int joves = 0;
		
		boolean error = false;
		
		for(int i = 0; i < rondes; i++) {
			
			int carra = sc.nextInt();
			int desca = sc.nextInt();
			a += desca;
			boomers += desca;
			if(carra < desca) {
				error = true;
			}
			int carraj = sc.nextInt();
			int descaj = sc.nextInt();
			a += descaj;
			joves += descaj;
			if(carraj < descaj) {
				error = true;
			}
			int carrb = sc.nextInt();
			int descb = sc.nextInt();
			b += descb;
			boomers += descb;
			if(carrb < descb) {
				error = true;
			}
			int carrbj = sc.nextInt();
			int descbj = sc.nextInt();
			b += descbj;
			joves += descbj;
			if(carrbj < descbj) {
				error = true;
			}
		}
		if(error == false) {
			if(a > b) {
				System.out.println("A");
			}else if(a < b) {
				System.out.println("B");
			}
			
			if(boomers > joves) {
				System.out.println("BOOMERS");
			}else if(joves > boomers) {
				System.out.println("JOVES");
			}
			
		}else {
			System.out.println("ERROR");
		}
		

	}

}
