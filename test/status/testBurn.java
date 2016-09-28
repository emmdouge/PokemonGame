package status;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

public class testBurn {

	@Test
	public void test() {
		Pokemon testee = new MockPokemon();
		Pokemon testDummy = new MockPokemon();
		testee.setCurrentStatus(testee.getBurnStatus());
		
		assertEquals(testee.getCurrentStatus().toString(), "BRN");
		
		testee.makeAttack(testDummy, 0);
		assertEquals(90, testee.getCurrentHitpoints());
		assertEquals(90,testDummy.getCurrentHitpoints());
		
		testee.changeStatus(testee.getNormalStatus());
		assertEquals(testee.getNormalStatus(), testee.getCurrentStatus());

		testee.setCurrentStatus(testee.getBurnStatus());
		testee.changeStatus(testee.getBurnStatus());
		assertEquals(testee.getBurnStatus(), testee.getCurrentStatus());

		testee.changeStatus(testee.getDeadStatus());
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());
		
		testee.setCurrentStatus(testee.getBurnStatus());
		testee.changeStatus(testee.getPoisonStatus());
		assertEquals(testee.getBurnStatus(), testee.getCurrentStatus());
		
		testee.setCurrentStatus(testee.getBurnStatus());
		testee.changeStatus(testee.getConfusedStatus());
		assertEquals(testee.getBurnStatus(), testee.getCurrentStatus());
		
		testee = new MockPokemon();
		testee.setCurrentStatus(testee.getBurnStatus());
		while(testee.getCurrentStatus() == testee.getBurnStatus())
		{
			testee.makeAttack(testDummy,0);
		}
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());
		
	}

}
