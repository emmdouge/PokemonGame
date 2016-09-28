package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWartortle {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Wartortle, 75);
		
		assertEquals(tester.getPokeType(), "Water");
		assertEquals(tester.getLevel(), 75);
		assertEquals(tester.getAttackPower(), 187);
		assertEquals(tester.getSpecialAttackPower(), 187);
		assertEquals(tester.getDefense(), 82);
		assertEquals(tester.getSpecialDefense(), 82);
		assertEquals(tester.getCurrentHitpoints(), 337);
		assertEquals(tester.getMaxHitpoints(), 337);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Wartortle");
	}

}
