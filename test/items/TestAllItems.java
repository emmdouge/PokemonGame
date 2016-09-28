package items;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * @author Emmanuel
 * Tests all items that implement the item interface
 */
public class TestAllItems {

	/**
	 * Tests all items derived from potion
	 */
	@Test
	public void testPotionItems() {
		Item sitrusBerry = ItemFactory.create(AllItems.sitrusBerry);
		Pokemon mock = new MockPokemon();
		mock.setCurrentHitpoints(50);
		sitrusBerry.use(mock);
		//sitrus berry adds half of mock pokemons current lifepoints (25)
		assertEquals(75, mock.getCurrentHitpoints());
		sitrusBerry.use(mock);
		//sitrus berry adds half of mock pokemons current lifepoints (37)
		//using sitrus berry again does not result in overflow
		//and keeps the pokemon at max health
		assertEquals(100, mock.getCurrentHitpoints());
		
		Item elixir = ItemFactory.create(AllItems.elixir);
		mock = new MockPokemon();
		//set mock pokemon's health to 50 to test elixir
		mock.setCurrentHitpoints(50);
		elixir.use(mock);
		//elixir adds 20 health to mock pokemon
		assertEquals(70, mock.getCurrentHitpoints());
		
		Item superElixir = ItemFactory.create(AllItems.superElixir);
		mock = new MockPokemon();
		//set mock pokemon's health to 50 to test super elixir
		mock.setCurrentHitpoints(50);
		superElixir.use(mock);
		//super elixir adds 50 health to mock pokemon
		assertEquals(100, mock.getCurrentHitpoints());
	}

	/**
	 * Makes sure items return the correct string
	 */
	@Test
	public void testGetItemName()
	{
		assertEquals("Sitrus Berry", ItemFactory.create(AllItems.sitrusBerry).getName());
		assertEquals("Super Elixir", ItemFactory.create(AllItems.superElixir).getName());
		assertEquals("Elixir", ItemFactory.create(AllItems.elixir).getName());
	}
}
