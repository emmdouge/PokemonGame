package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCharizard {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Charizard, 100);
		
		assertEquals(tester.getPokeType(), "Fire");
		assertEquals(tester.getLevel(), 100);
		assertEquals(tester.getAttackPower(), 300);
		assertEquals(tester.getSpecialAttackPower(), 300);
		assertEquals(tester.getDefense(), 75);
		assertEquals(tester.getSpecialDefense(), 75);
		assertEquals(tester.getCurrentHitpoints(), 300);
		assertEquals(tester.getMaxHitpoints(), 300);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Charizard");
	}

}
