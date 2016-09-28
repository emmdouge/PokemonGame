package moves;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * Tests the functionality of the Flamethrower Move
 * @author Brandon Shawver
 *
 */
public class testFlamethrower 
{
	/**
	 * Tests the getName() method.
	 */
	@Test
	public void testGetName()
	{
		Special FlameSpecial = new Special();
		Move Flamethrower = new Flamethrower(FlameSpecial);
		
		assertEquals("Flamethrower", Flamethrower.getName());
	}
	
	/**
	 * Tests the calculation of the damage for this move
	 */
	@Test
	public void testDamage() 
	{
		Pokemon testDummy = new MockPokemon();
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
		Pokemon testDummy = new MockPokemon();
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
		Special FlameSpecial = new Special();
		Move Flamethrower = new Flamethrower(FlameSpecial);
		Pokemon testDummy = new MockPokemon();
		
		assertFalse(Flamethrower.checkStatusChange(testDummy));
	}
}
