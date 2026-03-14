package mokepon4;

public interface Equipament {
	
	public abstract void Equipar(MokeponCapturat mok);
	
	public abstract void Desequipar(MokeponCapturat mok);
	
	 public default boolean potEquipar(MokeponCapturat mok) {
		 if(mok.objecteEquipat == null && mok.debilitat == false) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
	 default boolean equipMalPosat(MokeponCapturat mok) {
		 if(mok.objecte instanceof Equipament) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
}
