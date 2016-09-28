package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoliwag {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Poliwag, 10);
		
		assertEquals(tester.getPokeType(), "Water");
		assertEquals(tester.getLevel(), 10);
		assertEquals(tester.getAttackPower(), 25);
		assertEquals(tester.getSpecialAttackPower(), 25);
		assertEquals(tester.getDefense(), 11);
		assertEquals(tester.getSpecialDefense(), 11);
		assertEquals(tester.getCurrentHitpoints(), 45);
		assertEquals(tester.getMaxHitpoints(), 45);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Poliwag");
	}

}
