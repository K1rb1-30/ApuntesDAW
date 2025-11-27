package introllistes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trileros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int vasos = sc.nextInt();
		
		ArrayList<Integer> triler = new ArrayList<>();
		
		for(int i = 0; i < vasos; i++) {
			if(i == 0) {
				triler.add(1);
			}else {
				triler.add(0);
			}
		}
		
		boolean flag = false;
		
		while(!flag) {
			int primero = sc.nextInt();
			int segundo = sc.nextInt();
			
			if(primero != -1 && segundo != -1) {
				Collections.swap(triler, primero, segundo);
				
			}else {
				flag = true;
			}
			
			
		}
		
		System.out.println(triler);
		
		for(Integer bolita : triler) {
			if(bolita == 1) {
				System.out.println();
			}
		}
		

	}

}
