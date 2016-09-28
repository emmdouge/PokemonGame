package items;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ItemException;

/**
 * @author Emmanuel
 * Tests the bag that will hold the items for the player and enemy
 */
public class TestBag {

	/**
	 * Makes sure no item can be null once a bag is created
	 * @throws ItemException 
	 */
	@Test
	public void testInitialization() throws ItemException {
		Bag bag = new Bag();
		
		for(int i = 0; i < bag.getMaxItemsBagHolds(); i++)
		{
			assertNotNull(bag.getItem(i));
			
			//item slot within the bag is empty
			assertTrue(bag.getItem(0).isEmpty());
		}
	}
	
	/**
	 * Makes sure every item slot within bag is occupied when bag is filled
	 * with random items
	 * @throws ItemException 
	 */
	@Test
	public void testFillBag() throws ItemException
	{
		Bag bag = new Bag();
		
		bag.fillBag();
		
		for(int i = 0; i < bag.getMaxItemsBagHolds(); i++)
		{
			assertNotNull(bag.getItem(i));
			
			//item slot within the bag is occupied
			assertFalse(bag.getItem(0).isEmpty());
		}
	}
	
	/**
	 * Makes sure items are added correctly
	 * @throws ItemException 
	 */
	@Test
	public void testAddItem() throws ItemException
	{
		Bag bag = new Bag();
		
		for(int i = 0; i < bag.getMaxItemsBagHolds(); i++)
		{
			assertNotNull(bag.getItem(i));
		}
		
		//item slot within the bag is empty
		assertTrue(bag.getItem(0).isEmpty());
		bag.addItem(AllItems.elixir);
		
		//item slot within the bag is occupied
		assertFalse(bag.getItem(0).isEmpty());
		
		//item slot within the bag is occupied by an elixir
		assertEquals("Elixir", bag.getItem(0).getName());
		
		//item slot within the bag is empty
		assertTrue(bag.getItem(1).isEmpty());
		bag.addItem(AllItems.sitrusBerry);
		
		//item slot within the bag is occupied
		assertFalse(bag.getItem(1).isEmpty());
		
		//item slot within the bag is occupied by an elixir
		assertEquals("Sitrus Berry", bag.getItem(1).getName());
		
		bag.addItem(AllItems.sitrusBerry);
		bag.addItem(AllItems.sitrusBerry);
		bag.addItem(AllItems.sitrusBerry);
		bag.addItem(AllItems.sitrusBerry);
		
		//no out of bounds error thrown (max num of items bag can hold is six at compile time
		bag.addItem(AllItems.sitrusBerry);
	}
	
	/**
	 * Makes sure items are removed correctly
	 * @throws ItemException 
	 */
	@Test
	public void testRemoveItem() throws ItemException
	{
		Bag bag = new Bag();
		
		bag.fillBag();
		
		assertFalse(bag.getItem(0).isEmpty());
		assertFalse(bag.getItem(1).isEmpty());
		assertFalse(bag.getItem(2).isEmpty());
		
		bag.removeItem(0);
		
		assertTrue(bag.getItem(0).isEmpty());
		assertFalse(bag.getItem(1).isEmpty());
		assertFalse(bag.getItem(2).isEmpty());
		
		bag.removeItem(1);
		
		assertTrue(bag.getItem(0).isEmpty());
		assertTrue(bag.getItem(1).isEmpty());
		assertFalse(bag.getItem(2).isEmpty());
		
		bag.addItem(AllItems.elixir);
		
		assertFalse(bag.getItem(0).isEmpty());
		assertTrue(bag.getItem(1).isEmpty());
		assertFalse(bag.getItem(2).isEmpty());
	}
	
	/**
	 * Makes sure items return will return the correct name when
	 * accessed through a bag
	 */
	@Test
	public void testGetItemName()
	{
		Bag bag = new Bag();
		
		bag.addItem(AllItems.elixir);
		bag.addItem(AllItems.superElixir);
		bag.addItem(AllItems.sitrusBerry);
		
		assertEquals("Elixir", bag.getItemName(0));
		assertEquals("Super Elixir", bag.getItemName(1));
		assertEquals("Sitrus Berry", bag.getItemName(2));
	}
	
	/**
	 * Makes sure invalid inputs don't throw exceptions
	 * @throws ItemException 
	 */
	@Test
	public void testOutOfBounds() throws ItemException
	{
		Bag bag = new Bag();
		
		bag.addItem(7);
		assertTrue(bag.getItem(0).isEmpty());
		
		bag.addItem(-1);
		assertTrue(bag.getItem(0).isEmpty());
		
		bag.removeItem(7);
		bag.removeItem(-1);
		
		bag.getItemName(7);
		bag.getItemName(-1);

	}
}
