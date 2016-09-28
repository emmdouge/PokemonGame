package items;

/**
 * @author Emmanuel
 *
 */
public abstract class AllItems {
	
	/**
	 * Ordinal value to compare items to sitrus berries from ItemFactory
	 * Adds amount equal to half of pokemon's health
	 */
	public static final int sitrusBerry = 0;
	
	/**
	 * Ordinal value to compare items to elixirs from ItemFactory
	 * Adds 20 flat health
	 */
	public static final int elixir = 1;
	
	/**
	 * Ordinal value to compare items to super elixirs from ItemFactory
	 * Adds 50 flat health
	 */
	public static final int superElixir = 2;
	
	private final static int numPossibleItems = 3;
	
	/**
	 * @return the number of items possible
	 */
	public static int getNumPossibleItems()
	{
		return numPossibleItems;
	}
}

