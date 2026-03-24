package stardewValley;

public class Llavor extends Objecte{

	public int tornsRegada;
	public int tornsPerCreixer;
	public Hortalissa hortalissa;
	
	public Llavor(String nom, int tornsPerCreixer, Hortalissa hortalissa) {
		super(nom);
		this.tornsPerCreixer = tornsPerCreixer;
		this.tornsRegada = 0;
		this.hortalissa = hortalissa;
	}
	
	@Override
	public int vendre() {
		// TODO Auto-generated method stub
		System.out.println("no és un objecte que es pugui vendre");
		return 0;
	}
	
	
}
