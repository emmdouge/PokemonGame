package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCharmander {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Charmander, 50);
		
		assertEquals(tester.getPokeType(), "Fire");
		assertEquals(tester.getLevel(), 50);
		assertEquals(tester.getAttackPower(), 150);
		assertEquals(tester.getSpecialAttackPower(), 150);
		assertEquals(tester.getDefense(), 37);
		assertEquals(tester.getSpecialDefense(), 37);
		assertEquals(tester.getCurrentHitpoints(), 150);
		assertEquals(tester.getMaxHitpoints(), 150);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Charmander");
	}

}
