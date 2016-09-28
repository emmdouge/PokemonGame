package status;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

public class testDead {

	@Test
	public void test() {
		Pokemon testee = new MockPokemon();
		Pokemon testDummy = new MockPokemon();
		testee.setCurrentHitpoints(0);

		testee.makeAttack(testDummy, 0);
		assertEquals(100,testDummy.getCurrentHitpoints());
		assertEquals(0, testee.getCurrentHitpoints());
		
		assertEquals(testee.getCurrentStatus().toString(), "FNT");
		
		testee.changeStatus(testee.getNormalStatus());
		testee.makeAttack(testDummy, 0);
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());

		testee.changeStatus(testee.getBurnStatus());
		testee.makeAttack(testDummy, 0);
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());

		testee.changeStatus(testee.getPoisonStatus());
		testee.makeAttack(testDummy, 0);
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());
		
		testee.changeStatus(testee.getConfusedStatus());
		testee.makeAttack(testDummy, 0);
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());
		
	}

}
