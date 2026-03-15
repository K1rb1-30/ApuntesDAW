package mokepon6;

import java.util.ArrayList;

public class ArrayListAcotada<T> extends ArrayList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public T get(int index) {
		
		if(index >= super.size()) {
			index = super.size() - 1;
		}else if(index < 0) {
			index = 0;
		}
		return super.get(index);
		
	}

}
