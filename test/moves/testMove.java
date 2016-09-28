package moves;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

/**
 * Tests the template used for the calculation of all moves damage.
 * @author Brandon Shawver
 * 
 * NOTE: There are no tests for the observer pattern used by the moves because it is the basis for all the moves.
 * If it did not work properly then the moves would not be able to calculate damage or anything and return null pointers or 0
 * becuase the stats are not initialized until the observer tells them what to initialize or change them to.
 */
public class testMove 
{
	@Test
	public void testSpecialTemplate() 
	{
		Pokemon testDummy = new MockPokemon();
		Pokemon testDummy2 = new MockPokemon("Grass");
		Move[] attacks = new Move[4];
		attacks = testDummy.getAttacks(); 
		int testFinalDamage = attacks[3].calcDamage();
		testFinalDamage = attacks[3].calcDefense(testFinalDamage, testDummy2);
		int targetsHealth = testDummy2.getCurrentHitpoints() - testFinalDamage;
		
		attacks[3].attack(testDummy2);
		assertEquals(targetsHealth, testDummy2.getCurrentHitpoints());
	}
	
	@Test
	public void testNonSpecialTemplate()
	{
		Pokemon testDummy = new MockPokemon();
		Pokemon testDummy2 = new MockPokemon("Grass");
		Move[] attacks = new Move[4];
		attacks = testDummy.getAttacks(); 
		int testFinalDamage = attacks[0].calcDamage();
		testFinalDamage = attacks[0].calcDefense(testFinalDamage, testDummy2);
		int targetsHealth = testDummy2.getCurrentHitpoints() - testFinalDamage;
		
		attacks[0].attack(testDummy2);
		assertEquals(targetsHealth, testDummy2.getCurrentHitpoints());
	}
}
