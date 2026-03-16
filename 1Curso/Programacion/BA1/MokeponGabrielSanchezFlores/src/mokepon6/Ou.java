package mokepon6;

import java.util.Random;

public class Ou {
	private String especie;
	private Tipus tipus;
	private int passesRestants;
	
	public Ou(String especie, Tipus tipus) {
		this.especie = especie;
		this.tipus = tipus;
		
		//Calcular aleatoriament les passesRestants entre 5 i 10
		
		Random r = new Random();
		
		this.passesRestants = r.nextInt(10 - 5 + 1) + 5; 
		
	}
	
	public void caminar() {
		if(this.passesRestants > 0) {
			this.passesRestants--;
		}
		
		if(this.passesRestants == 0) {
			this.eclosionar();
		}
	}
	
	public Mokepon eclosionar() {
		Mokepon ouEclosionat = new Mokepon(this.especie, this.tipus);
		
		return ouEclosionat;
	}


	
	
}
