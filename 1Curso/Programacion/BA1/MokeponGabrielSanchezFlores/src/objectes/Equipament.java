package objectes;
import mokepon6.MokeponCapturat;

public interface Equipament {
	
	public abstract void Equipar(MokeponCapturat mok);
	
	public abstract void Desequipar(MokeponCapturat mok);
	
	 public default boolean potEquipar(MokeponCapturat mok) {
		 if(mok.getObjecteEquipat() == null && mok.isDebilitat() == false) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
	 default boolean equipMalPosat(MokeponCapturat mok) {
		 if(mok.getObjecte() instanceof Equipament) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
}
