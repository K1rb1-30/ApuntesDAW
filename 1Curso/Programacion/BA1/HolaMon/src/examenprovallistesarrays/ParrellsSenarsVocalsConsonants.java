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
				stringb.setCharAt(i, '*');
				countvocals++;
			}
			
			System.out.println(stringb);
			
		}
		
		System.out.println(stringb);
		System.out.println(countvocals + " vocals eliminades");
		
		
	}

}
