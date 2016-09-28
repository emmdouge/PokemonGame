package items;

import pokemon.Pokemon;

/**
 * @author Emmanuel
 * Item interface to make sure all items no matter how diverse 
 * can use the following functions
 */
public interface Item {
	
	/**
	 * @param pokemon pokemon the item will have an effect on
	 */
	public void use(Pokemon pokemon);
	
	/**
	 * @return the name of the item
	 */
	public String getName();
	
	/**
	 * @return true if item is NoItem. False if item is not.
	 */
	public boolean isEmpty();
}
