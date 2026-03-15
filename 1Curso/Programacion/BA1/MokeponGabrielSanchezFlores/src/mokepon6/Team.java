package mokepon6;

import java.util.ArrayList;

public class Team<T extends Mokepon> extends ArrayList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean add(T mok) {
		if(super.size() >= 6) {
			return false;
		}
		
		return super.add(mok);
	}
	
	

}
