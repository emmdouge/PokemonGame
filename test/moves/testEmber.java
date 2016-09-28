package moves;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * Test the functionality of Ember
 * @author Brandon Shawver
 */
public class testEmber 
{
	/**
	 * Tests the getName() method.
	 */
	@Test
	public void testGetName()
	{
		Special FlameSpecial = new Special();
		Move Ember = new Ember(FlameSpecial);
		
		assertEquals("Ember", Ember.getName());
	}
	
	/**
	 * Tests the calculation of the damage for this move
	 */
	@Test
	public void testDamage() 
	{
		Pokemon testDummy = new MockPokemon();
		Move[] attacks = testDummy.getAttacks();
		int testDamage = (int) (testDummy.getSpecialAttackPower());
		
		assertEquals(testDamage, attacks[3].calcDamage());
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
		int testDamage = (int) (testDummy.getSpecialAttackPower());
		int testDefense = testDamage - testDummy.getSpecialDefense();
		
		assertEquals(testDefense, attacks[3].calcDefense(testDamage, testDummy2));
	}
	
	/**
	 * Checks that there is a status change attached to this move. True or False.
	 */
	@Test
	public void testCheckStatusChange()
	{
		Special EmberSpecial = new Special();
		Move Ember = new Ember(EmberSpecial);
		Pokemon testDummy = new MockPokemon();
		
		assertTrue(Ember.checkStatusChange(testDummy));
	}
}
