package examenprovallistesarrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ParrellsSenarsVocalsConsonants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String frase = sc.nextLine();
		
		StringBuilder stringb = new StringBuilder(frase);
		
		int countvocals = 0;
		
		for(int i = 0; i < stringb.length(); i++ ) {
			
			char c = stringb.charAt(i);
			if(i % 2 != 0) {
				stringb.setCharAt(i, '*');
			}else if( i % 2 == 0 && (c == 'a'|| c == 'e' || c == 'i' || c == 'o'|| c == 'u')) {
				stringb.deleteCharAt(i);
				countvocals++;
				i = -1;
			}
			
		}
		
		if(stringb.length() == 0) {
			System.out.println("Buida");
		}else {
			System.out.println(stringb);
		}
		System.out.println(countvocals + " vocals eliminades");
		
		
	}

}
