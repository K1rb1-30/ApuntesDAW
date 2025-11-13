package arrayssplit;

import java.util.Scanner;

public class Raid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			String hora = sc.nextLine();
			
			String[] parts = hora.split(":");
			
			String max = parts[1];
			String min = parts[0];
			
			int minuts = Integer.parseInt(min);
			int hores = Integer.parseInt(max);
			
			System.out.println(hores * 60 + minuts);
		}
		
	}

}
