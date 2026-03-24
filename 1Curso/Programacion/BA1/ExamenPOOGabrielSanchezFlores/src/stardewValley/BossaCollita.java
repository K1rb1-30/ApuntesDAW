package stardewValley;

import java.util.ArrayList;



public class BossaCollita<F extends Hortalissa> extends ArrayList<F> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public F remove(int index) {
		F item = this.get(index);
		
		item.vendre();

		return super.remove(index);

	}
	
}
