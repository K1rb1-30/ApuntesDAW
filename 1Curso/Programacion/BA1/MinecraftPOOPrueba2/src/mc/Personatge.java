package mc;

public abstract class Personatge {
	public String nom;
	public boolean viu;
	private int maxHp;
	private int hp;
	
	public Personatge(String nom) {
		this.nom = nom;
		this.viu = true;
		this.maxHp = 1;
		this.hp = this.maxHp;
	}
	
	public Personatge(String nom, int maxHp) {
		this.nom = nom;
		this.viu = true;
		this.maxHp = maxHp;
		this.hp = maxHp;
	}
	
	

	@Override
	public String toString() {
		return  nom + ": " + hp + "/" + maxHp ;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if(hp > this.maxHp) {
			this.hp = this.maxHp;
		}else if(hp <= 0){
			this.hp = 0;
			this.viu = false;
		}else {
			this.hp = hp;
		}
		
	}
	
	
	
	
}
