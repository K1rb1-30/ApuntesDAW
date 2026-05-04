package exercicis;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HTML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		sc.nextLine();
		
		ArrayDeque<String> cua = new ArrayDeque<String>();
		
		for (int i = 0; i < casos; i++) {
			String[] tag = sc.nextLine().split("");
			String name = "";
			for (int j = 1; j < tag.length - 1; j++) {
				name += tag[j];
			}
			cua.add(name);
		}
		
		boolean flag = false;
		
		for (int i = 0; i < casos - 1; i++) {
			if(cua.pollLast().equals("/" +cua.pollFirst())) {
				flag = true;
			}else {
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("Etiquetes ben tancades");
		}else {
			System.out.println("Etiquetes mal tancades");
		}
	}

}
