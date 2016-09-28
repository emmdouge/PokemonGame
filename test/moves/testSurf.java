package moves;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * Tests the functionality of Surf
 * @author Brandon Shawver
 *
 */
public class testSurf 
{
	/**
	 * Tests the getName() method.
	 */
	@Test
	public void testGetName()
	{
		Special WaterSpecial = new Special();
		Move Surf = new Surf(WaterSpecial);
		
		assertEquals("Surf", Surf.getName());
	}
	
	/**
	 * Tests the calculation of the damage for this move
	 */
	@Test
	public void testDamage() 
	{
		Pokemon testDummy = new MockPokemon("Water");
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
		Pokemon testDummy = new MockPokemon("Water");
		Pokemon testDummy2 = new MockPokemon("Water");
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
		Special WaterSpecial = new Special();
		Move Surf = new Surf(WaterSpecial);
		Pokemon testDummy = new MockPokemon();
		
		assertFalse(Surf.checkStatusChange(testDummy));
	}
}
