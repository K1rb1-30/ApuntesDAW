package mokepon4;

public class Armadura extends Objecte implements Equipament{
	
	int defExtra;

	public Armadura(String nom, int defExtra) {
		super(nom);
		this.defExtra = defExtra;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Equipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.objecteEquipat = this;
		mok.setDef(mok.getDef() + defExtra);
	}

	@Override
	public void Desequipar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		mok.objecteEquipat = this;
		mok.setDef(mok.getDef() - defExtra);
	}

	@Override
	public void utilitzar(MokeponCapturat mok) {
		// TODO Auto-generated method stub
		this.Equipar(mok);
	}

}
