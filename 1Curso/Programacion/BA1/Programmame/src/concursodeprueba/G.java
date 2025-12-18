package concursodeprueba;

import java.util.Scanner;

public class G {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int numero = sc.nextInt();
		
		long[] listanum = new long[numero];
		
		int grupos = 0;
		
		for (int i = 0; i < numero; i++) {
			
			 listanum[i] = sc.nextLong();
			
		}
		
		for (int j = 0; j < listanum.length; j++) {
			if(j == listanum.length - 1) {
				grupos++;
			}else {
				if(listanum[j] < listanum[j+1]) {
					grupos++;
				}
			}
		}
		
		System.out.println(grupos);

	}

}
