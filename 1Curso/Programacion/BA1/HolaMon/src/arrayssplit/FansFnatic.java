package arrayssplit;

import java.util.Scanner;

public class FansFnatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			
			int partidas = sc.nextInt();
			sc.nextLine();
			
			int victorias = 0;
			int derrotas = 0;
			
			
			for(int e = 0; e< partidas; e++) {
				String partit = sc.nextLine();
				
				String[] contador = partit.split(" - ");
				
				
				if(contador[1].equals("Fnatic")){
					derrotas++;
				}if(contador[0].equals("Fnatic")){
					victorias++;
				}
				
			}
			
			System.out.println(victorias + " " + derrotas);
			
			
		}
		
		
		
	}

}
