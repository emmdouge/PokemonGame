package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIvysaur {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Ivysaur, -1);
		
		assertEquals(tester.getPokeType(), "Grass");
		assertEquals(tester.getLevel(), 1);
		assertEquals(tester.getAttackPower(), 2);
		assertEquals(tester.getSpecialAttackPower(), 2);
		assertEquals(tester.getDefense(), 1);
		assertEquals(tester.getSpecialDefense(), 1);
		assertEquals(tester.getCurrentHitpoints(), 6);
		assertEquals(tester.getMaxHitpoints(), 6);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Ivysaur");
	}

}
