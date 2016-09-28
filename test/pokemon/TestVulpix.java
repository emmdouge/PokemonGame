package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVulpix {

	@Test
	public void testInit ()
	{
		PokeFactory poke = new PokeFactory();
		Pokemon tester = poke.generatePokemon(poke.Vulpix, 25);
		
		assertEquals(tester.getPokeType(), "Fire");
		assertEquals(tester.getLevel(), 25);
		assertEquals(tester.getAttackPower(), 75);
		assertEquals(tester.getSpecialAttackPower(), 75);
		assertEquals(tester.getDefense(), 18);
		assertEquals(tester.getSpecialDefense(), 18);
		assertEquals(tester.getCurrentHitpoints(), 75);
		assertEquals(tester.getMaxHitpoints(), 75);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Vulpix");
	}

}
