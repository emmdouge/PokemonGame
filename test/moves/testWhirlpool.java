package moves;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * Tests the functionality of Whirlpool
 * @author Brandon Shawver
 *
 */
public class testWhirlpool 
{
	/**
	 * Tests the getName() method.
	 */
	@Test
	public void testGetName()
	{
		Special WaterSpecial = new Special();
		Move Whirlpool = new Whirlpool(WaterSpecial);
		
		assertEquals("Whirlpool", Whirlpool.getName());
	}
	
	/**
	 * Tests the calculation of the damage for this move
	 */
	@Test
	public void testDamage() 
	{
		Pokemon testDummy = new MockPokemon("Water");
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
		Pokemon testDummy = new MockPokemon("Water");
		Pokemon testDummy2 = new MockPokemon("Water");
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
		Special WaterSpecial = new Special();
		Move Whirlpool = new Whirlpool(WaterSpecial);
		Pokemon testDummy = new MockPokemon();
		
		assertTrue(Whirlpool.checkStatusChange(testDummy));
	}
}
