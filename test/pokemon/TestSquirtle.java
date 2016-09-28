package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSquirtle {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Squirtle, 100);
		
		assertEquals(tester.getPokeType(), "Water");
		assertEquals(tester.getLevel(), 100);
		assertEquals(tester.getAttackPower(), 250);
		assertEquals(tester.getSpecialAttackPower(), 250);
		assertEquals(tester.getDefense(), 110);
		assertEquals(tester.getSpecialDefense(), 110);
		assertEquals(tester.getCurrentHitpoints(), 450);
		assertEquals(tester.getMaxHitpoints(), 450);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Squirtle");
	}

}
