package moves;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * Tests the functionality of Sractch
 * @author Brandon Shawver
 *
 */
public class testScratch 
{
	/**
	 * Tests the getName() method.
	 */
	@Test
	public void testGetName()
	{
		Physical phy = new Physical();
		Move Scratch = new Scratch(phy);
		
		assertEquals("Scratch", Scratch.getName());
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
		
		assertEquals(testDamage, attacks[0].calcDamage());
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
		int testDamage = (int) (testDummy.getAttackPower());
		int testDefense = testDamage - testDummy.getDefense();
		
		assertEquals(testDefense, attacks[0].calcDefense(testDamage, testDummy2));
	}
	
	/**
	 * Checks that there is a status change attached to this move. True or False.
	 */
	@Test
	public void testCheckStatusChange()
	{
		Physical phy = new Physical();
		Move Scratch = new Scratch(phy);
		Pokemon testDummy = new MockPokemon();
		
		assertFalse(Scratch.checkStatusChange(testDummy));
	}
}
