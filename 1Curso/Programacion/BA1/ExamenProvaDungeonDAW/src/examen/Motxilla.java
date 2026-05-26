package examen;

import java.util.ArrayDeque;

public class Motxilla extends ArrayDeque<String> {
	
	
	
	public void afegir(String objecte) {
		if(this.size() < 3) {
			this.push(objecte);
		}else {
			this.pollFirst();
			this.push(objecte);
		}
	}
	
	public void usar() {
		if(this.peek().equals("màgic")) {
			System.out.println("L'heroi utilitza " + this.peek());
		}else if(this.peek().equals("normal")){
			System.out.println("L'heroi utilitza " + this.peek());
			this.pop();
		}else if(this.size() == 0) {
			
		}
	}
}
