package status;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.Pokemon;

public class testConfused {

	@Test
	public void test() {
		Pokemon testee = new MockPokemon();
		Pokemon testDummy = new MockPokemon();
		testee.setCurrentStatus(testee.getConfusedStatus());
		
		assertEquals(testee.getCurrentStatus().toString(), "CNF");
		
		int hitpoints = testee.getCurrentHitpoints();
		
		while(hitpoints == testee.getCurrentHitpoints())
		{
			testee.makeAttack(testDummy, 0);
			testee.setCurrentStatus(testee.getConfusedStatus());
		}
		
		assertEquals(hitpoints - 10, testee.getCurrentHitpoints());
		testDummy = new MockPokemon();
		hitpoints = testDummy.getCurrentHitpoints();
		while(hitpoints == testDummy.getCurrentHitpoints())
		{
			if(testee.getCurrentHitpoints() > 30)
			{
				testee.setCurrentHitpoints(100);
			}
			testee.makeAttack(testDummy, 0);
		}
		assertEquals(hitpoints - 10, testDummy.getCurrentHitpoints());
		
		testee.setCurrentStatus(testee.getConfusedStatus());
		testee.changeStatus(testee.getBurnStatus());
		assertEquals(testee.getConfusedStatus(), testee.getCurrentStatus());

		testee.changeStatus(testee.getPoisonStatus());
		assertEquals(testee.getConfusedStatus(), testee.getCurrentStatus());
		
		testee.changeStatus(testee.getConfusedStatus());
		assertEquals(testee.getConfusedStatus(), testee.getCurrentStatus());
		
		testee.changeStatus(testee.getDeadStatus());
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());
		
		testee = new MockPokemon();
		testee.setCurrentStatus(testee.getConfusedStatus());
		testee.setCurrentHitpoints(0);
		testee.makeAttack(testDummy, 0);
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());
		testee = new MockPokemon();
		testee.setCurrentStatus(testee.getConfusedStatus());
		testee.setCurrentHitpoints(5);
		while(testee.getCurrentStatus() != testee.getDeadStatus())
		{
			testee.setCurrentStatus(testee.getConfusedStatus());
			testee.makeAttack(testDummy, 0);
		}
		assertEquals(testee.getDeadStatus(), testee.getCurrentStatus());
	}
	
	@Test
	public void testLoseConfusion()
	{
		Pokemon testee = new MockPokemon();
		Pokemon testDummy = new MockPokemon();
		testee.setCurrentStatus(testee.getConfusedStatus());
		
		while(testee.getCurrentStatus() == testee.getConfusedStatus())
		{
			testee.makeAttack(testDummy,0);
			testee.setCurrentHitpoints(100);
			testDummy.setCurrentHitpoints(100);
		}
		assertEquals(testee.getCurrentStatus(), testee.getNormalStatus());
	}
}
