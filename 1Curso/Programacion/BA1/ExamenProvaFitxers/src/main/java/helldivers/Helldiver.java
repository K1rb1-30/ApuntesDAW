package helldivers;

import java.util.ArrayList;

public class Helldiver {
	String name;
	int hp;
	boolean democracy;
	boolean alive;
	ArrayList<Stratagem> stratagems;
	
	
	public Helldiver() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Helldiver(String name, int hp, boolean democracy, boolean alive, ArrayList<Stratagem> stratagems) {
		super();
		this.name = name;
		this.hp = hp;
		this.democracy = democracy;
		this.alive = alive;
		this.stratagems = stratagems;
	}


	@Override
	public String toString() {
		return "Helldiver [name=" + name + ", hp=" + hp + ", democracy=" + democracy + ", alive=" + alive
				+ ", stratagems=" + stratagems + "]";
	}

	
	
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public boolean isDemocracy() {
		return democracy;
	}


	public void setDemocracy(boolean democracy) {
		this.democracy = democracy;
	}


	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	public ArrayList<Stratagem> getStratagems() {
		return stratagems;
	}


	public void setStratagems(ArrayList<Stratagem> stratagems) {
		this.stratagems = stratagems;
	}
	
	
	
	
	
}
