package mokepon6;

import java.util.ArrayList;

public class ArrayListCircular<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    public T get(int index) {
        index = index % super.size();
        return super.get(index);
    }

}
