package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBulbasaur {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Bulbasaur, 10);
		
		assertEquals(tester.getPokeType(), "Grass");
		assertEquals(tester.getLevel(), 10);
		assertEquals(tester.getAttackPower(), 20);
		assertEquals(tester.getSpecialAttackPower(), 20);
		assertEquals(tester.getDefense(), 15);
		assertEquals(tester.getSpecialDefense(), 15);
		assertEquals(tester.getCurrentHitpoints(), 60);
		assertEquals(tester.getMaxHitpoints(), 60);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Bulbasaur");
	}
}
