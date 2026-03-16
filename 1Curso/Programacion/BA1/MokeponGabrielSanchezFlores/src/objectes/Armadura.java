package objectes;
import mokepon6.MokeponCapturat;

public class Armadura extends Objecte implements Equipament{
	
	int defExtra;

	public Armadura(int defExtra) {
		super("Armadura");
		this.defExtra = defExtra;
		// TODO Auto-generated constructor stub
	}

	public void Equipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.setObjecteEquipat(this);
		mok.setDef(mok.getDef() + defExtra);
	}

	public void Desequipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.setObjecteEquipat(this);
		mok.setDef(mok.getDef() - defExtra);
	}

	public void utilitzar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		this.Equipar(mok);
	}

}
