package strings;

import java.util.Scanner;

public class Mecano {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			
			String [] primera = sc.nextLine().split(" ");
			String [] segunda = sc.nextLine().split(" ");
			
			if(primera[primera.length-1].equals(segunda[segunda.length-1])) {
				System.out.println("SI");
			}else {
				System.out.println("NO");
			}
			
			
			
		}
	}

}
