package status;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

public class testPoison {

	@Test
	public void test() {
		Pokemon testee = new MockPokemon();
		Pokemon testDummy = new MockPokemon();
		testee.setCurrentStatus(testee.getPoisonStatus());
		
		assertEquals(testee.getCurrentStatus().toString(), "PSN");
		
		testee.makeAttack(testDummy, 0);
		assertEquals(90,testDummy.getCurrentHitpoints());
		assertEquals(90, testee.getCurrentHitpoints());
		
		testee.changeStatus(testee.getNormalStatus());
		assertEquals(testee.getNormalStatus(), testee.getCurrentStatus());

		testee.setCurrentStatus(testee.getPoisonStatus());
		testee.changeStatus(testee.getBurnStatus());
		assertEquals(testee.getPoisonStatus(), testee.getCurrentStatus());

		testee.changeStatus(testee.getPoisonStatus());
		assertEquals(testee.getPoisonStatus(), testee.getCurrentStatus());
		
		testee.changeStatus(testee.getConfusedStatus());
		assertEquals(testee.getPoisonStatus(), testee.getCurrentStatus());
		
		while(testee.getCurrentHitpoints() > 0)
		{
			testee.makeAttack(testDummy,0);
		}
		testee.makeAttack(testDummy,0);
		assertEquals(testee.getCurrentStatus(), testee.getDeadStatus());
	}
}
