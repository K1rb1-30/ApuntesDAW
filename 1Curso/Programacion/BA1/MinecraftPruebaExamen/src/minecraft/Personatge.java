package minecraft;

public abstract class Personatge {
	public String nom;
	public boolean viu;
	private int maxHp;
	private int hp;
	
	public Personatge(String nom, int maxHp) {
		this.nom = nom;
		this.viu = true;
		this.maxHp = maxHp;
		this.hp = maxHp;
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
		if(hp < 0) {
			this.hp = 0;
		}else if(hp > this.maxHp) {
			this.hp = this.maxHp;
		}else {
			this.hp = hp;
		}
		
		// Para calcular si esta muerto o no
		if(this.getHp() == 0) {
			this.viu = false;
		}
	}
	
	
	
	
}
