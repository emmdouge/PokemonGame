package pokemon;

import static org.junit.Assert.*;
import moves.*;

import org.junit.Test;

import status.*;
import type.*;

public class TestPokemon {

	@Test
	public void testInit ()
	{
		Pokemon tester = new MockPokemon();
		
		
		assertEquals(tester.getPokeType(), "???");
		assertEquals(tester.getLevel(), 100);
		assertEquals(tester.getAttackPower(), 100);
		assertEquals(tester.getSpecialAttackPower(), 100);
		assertEquals(tester.getDefense(), 90);
		assertEquals(tester.getSpecialDefense(), 90);
		assertEquals(tester.getCurrentHitpoints(), 100);
		assertEquals(tester.getMaxHitpoints(), 100);
		assertEquals(tester.getCurrentStatus(), tester.getNormalStatus());
		assertEquals(tester.getName(), "FakePokemon");
	}
	
	@Test
	public void testSetingStatus()
	{
		Pokemon tester = new MockPokemon(50);
		tester.setCurrentStatus(tester.getPoisonStatus());
		assertEquals(tester.getCurrentStatus(), tester.getPoisonStatus());
		tester.setCurrentStatus(tester.getConfusedStatus());
		assertEquals(tester.getCurrentStatus(), tester.getConfusedStatus());
		tester.setCurrentStatus(tester.getBurnStatus());
		assertEquals(tester.getCurrentStatus(), tester.getBurnStatus());
		tester.setCurrentStatus(tester.getDeadStatus());
		assertEquals(tester.getCurrentStatus(), tester.getDeadStatus());
	}
	
	@Test
	public void testSetters()
	{
		Pokemon tester = new MockPokemon(50);
		
		tester.setAttackPower(80);
		assertEquals(tester.getAttackPower(), 80);
		tester.setSpecialAttackPower(10);
		assertEquals(tester.getSpecialAttackPower(), 10);
		tester.setDefense(55);
		assertEquals(tester.getDefense(), 55);
		tester.setSpecialDefense(101);
		assertEquals(tester.getSpecialDefense(), 101);
		tester.setCurrentHitpoints(1);
		assertEquals(tester.getCurrentHitpoints(), 1);
		
		tester.setAttackPower(-80);
		assertEquals(tester.getAttackPower(), 1);
		tester.setSpecialAttackPower(-10);
		assertEquals(tester.getSpecialAttackPower(), 1);
		tester.setDefense(-0);
		assertEquals(tester.getDefense(), 1);
		tester.setSpecialDefense(-101);
		assertEquals(tester.getSpecialDefense(), 1);
		tester.setCurrentHitpoints(-1);
		assertEquals(tester.getCurrentHitpoints(), 0);
		tester.setCurrentHitpoints(10000);
		assertEquals(tester.getCurrentHitpoints(), 100);
	}
}
