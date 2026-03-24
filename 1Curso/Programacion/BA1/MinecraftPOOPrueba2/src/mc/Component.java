package mc;

public class Component extends Item{

	public Component(String nom, int valor) {
		super(nom, valor);
		// TODO Auto-generated constructor stub
	}

	public void avaluar() {
		System.out.print(this.nom + " ");
		if(this.valor > 100) {
			System.out.println("MOLT VALUOS");
		}
	}
}
