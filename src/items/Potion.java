package items;

import pokemon.Pokemon;
import growthBehavior.GrowthBehavior;

/**
 * @author Emmanuel
 *
 */
public class Potion implements Item{
	private GrowthBehavior gb;
	private String itemName;
	
	/**
	 * @param itemName the name of the potion
	 * @param growthBehavior the behavior of the potion
	 */
	public Potion(String itemName, GrowthBehavior growthBehavior)
	{
		this.itemName = itemName;
		this.gb = growthBehavior;
	}
	
	@Override
	public void use(Pokemon pokemon) {
		int healthToBeAdded = gb.calculateGrowth(pokemon.getCurrentHitpoints(), pokemon.getMaxHitpoints());
		pokemon.setCurrentHitpoints(pokemon.getCurrentHitpoints()+healthToBeAdded);
	}
	
	@Override
	public String toString()
	{
		return itemName;
	}
	
	public String getName()
	{
		return itemName;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
