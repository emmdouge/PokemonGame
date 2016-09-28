package items;

import growthBehavior.GrowthFractional;
import growthBehavior.GrowthLinear;

/**
 * @author Emmanuel
 * Creates items based on an integer
 * Integer can be provided by the AllItems class for readability
 */
public class ItemFactory {

	/**
	 * @param item id of the item to be created
	 * @return the to be created
	 */
	public static Item create(int item)
	{
		switch (item)
		{
		case AllItems.sitrusBerry:
			Potion sitrusBerry = new Potion("Sitrus Berry", new GrowthFractional(.5));
			return sitrusBerry;

		case AllItems.elixir:
			Potion elixir = new Potion("Elixir", new GrowthLinear(20));
			return elixir;
			
		case AllItems.superElixir:
			Potion superElixir = new Potion("Super Elixir", new GrowthLinear(50));
			return superElixir;
			
		default:
			return null;
		}
	}
}
