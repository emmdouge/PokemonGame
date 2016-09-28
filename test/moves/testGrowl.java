package moves;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * Tests the functionality of Growl
 * @author Brandon Shawver
 *
 */
public class testGrowl 
{
	/**
	 * Tests the getName() method.
	 */
	@Test
	public void testGetName()
	{
		StatChange stat = new StatChange();
		Move Growl = new Growl(stat);
		
		assertEquals("Growl", Growl.getName());
	}
	
	/**
	 * Tests the calculation of the damage for this move
	 */
	@Test
	public void testDamage() 
	{
		Pokemon testDummy = new MockPokemon();
		Move[] attacks = testDummy.getAttacks();
		int testDamage = 0;
		
		assertEquals(testDamage, attacks[1].calcDamage());
	}
	
	/**
	 * Test the negation of damage from this move
	 */
	@Test
	public void testDefense()
	{	
		Pokemon testDummy = new MockPokemon();
		Pokemon testDummy2 = new MockPokemon();
		Move[] attacks = testDummy.getAttacks();
		int testDamage = 0;
		int testDefense = 0;
		
		assertEquals(testDefense, attacks[1].calcDefense(testDamage, testDummy2));
	}
	
	/**
	 * Checks that there is a status change attached to this move. True or False.
	 */
	@Test
	public void testCheckStatusChange()
	{
		StatChange stat = new StatChange();
		Move Growl = new Growl(stat);
		Pokemon testDummy = new MockPokemon();
		
		assertTrue(Growl.checkStatusChange(testDummy));
	}
}
