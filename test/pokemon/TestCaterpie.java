package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCaterpie {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Caterpie, 20);
		
		assertEquals(tester.getPokeType(), "Grass");
		assertEquals(tester.getLevel(), 20);
		assertEquals(tester.getAttackPower(), 40);
		assertEquals(tester.getSpecialAttackPower(), 40);
		assertEquals(tester.getDefense(), 30);
		assertEquals(tester.getSpecialDefense(), 30);
		assertEquals(tester.getCurrentHitpoints(), 120);
		assertEquals(tester.getMaxHitpoints(), 120);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Caterpie");
	}

}
