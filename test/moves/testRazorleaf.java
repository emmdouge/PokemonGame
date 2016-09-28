package moves;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * Test the functionality of Razorleaf
 * @author Brandon Shawver
 *
 */
public class testRazorleaf 
{
	/**
	 * Tests the getName() method.
	 */
	@Test
	public void testGetName()
	{
		Special GrassSpecial = new Special();
		Move razorleaf = new Razorleaf(GrassSpecial);
		
		assertEquals("Razorleaf", razorleaf.getName());
	}
	
	/**
	 * Tests the calculation of the damage for this move
	 */
	@Test
	public void testDamage() 
	{
		Pokemon testDummy = new MockPokemon("Grass");
		Move[] attacks = testDummy.getAttacks();
		int testDamage = (int) (testDummy.getSpecialAttackPower()*1.5);
		
		assertEquals(testDamage, attacks[2].calcDamage());
	}
	
	/**
	 * Test the negation of damage from this move
	 */
	@Test
	public void testDefense()
	{	
		Pokemon testDummy = new MockPokemon("Grass");
		Pokemon testDummy2 = new MockPokemon();
		Move[] attacks = testDummy.getAttacks();
		int testDamage = (int) (testDummy.getSpecialAttackPower()*1.5);
		int testDefense = testDamage - testDummy.getSpecialDefense();
		
		assertEquals(testDefense, attacks[2].calcDefense(testDamage, testDummy2));
	}
	
	/**
	 * Checks that there is a status change attached to this move. True or False.
	 */
	@Test
	public void testCheckStatusChange()
	{
		Special GrassSpecial = new Special();
		Move Rl = new Razorleaf(GrassSpecial);
		Pokemon testDummy = new MockPokemon();
		
		assertFalse(Rl.checkStatusChange(testDummy));
	}
}
