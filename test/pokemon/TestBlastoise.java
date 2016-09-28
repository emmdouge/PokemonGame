package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBlastoise {

	@Test
	public void testInit ()
	{
		PokeFactory Pokeball = new PokeFactory();
		Pokemon tester = Pokeball.generatePokemon(Pokeball.Blastoise);
		
		assertEquals(tester.getPokeType(), "Water");
		assertEquals(tester.getLevel(), 100);
		assertEquals(tester.getAttackPower(), 250);
		assertEquals(tester.getSpecialAttackPower(), 250);
		assertEquals(tester.getDefense(), 110);
		assertEquals(tester.getSpecialDefense(), 110);
		assertEquals(tester.getCurrentHitpoints(), 450);
		assertEquals(tester.getMaxHitpoints(), 450);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "Blastoise");
	}

}
