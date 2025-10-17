package joel;

import java.util.Scanner;

public class Banana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			int vida = sc.nextInt();
			int dany = sc.nextInt();
			if(vida > dany) {
				if(dany > vida * 0.2) {
					System.out.println("Momento Banana");
				}else {
					System.out.println("Nope");
				}
			}else {
				System.out.println("Nope");
			}
			
		}
	}

}
