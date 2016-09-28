package status;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.*;

public class testNormal {

	@Test
	public void test() {
		Pokemon testee = new MockPokemon();
		Pokemon testDummy = new MockPokemon();
		assertEquals(testee.getCurrentStatus().toString(), "   ");
		
		testee.makeAttack(testDummy, 0);
		assertEquals(90,testDummy.getCurrentHitpoints());
		
		testee.changeStatus(testee.getBurnStatus());
		assertEquals(testee.getBurnStatus(), testee.getCurrentStatus());

		testee.setCurrentStatus(testee.getNormalStatus());
		testee.changeStatus(testee.getBurnStatus());
		assertEquals(testee.getBurnStatus(), testee.getCurrentStatus());

		testee.setCurrentStatus(testee.getNormalStatus());
		testee.changeStatus(testee.getPoisonStatus());
		assertEquals(testee.getPoisonStatus(), testee.getCurrentStatus());
		
		testee.setCurrentStatus(testee.getNormalStatus());
		testee.changeStatus(testee.getConfusedStatus());
		assertEquals(testee.getConfusedStatus(), testee.getCurrentStatus());
	}

}
