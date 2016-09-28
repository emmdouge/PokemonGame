package moves;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the creation of Moves in MoveFactory
 * @author Brandon Shawver
 */
public class testMoveFactory 
{
	/**
	 * Tests the creation of the moves to make sure the factory actually returns Water moves.
	 */
	@Test
	public void testWaterFactory() 
	{
		MoveFactory factory = new MoveFactory();
		Move[] attack = new Move[4];
		
		// Uses the getName() method to test the factory since its Abstract in Move. Only way to get a string is to have the
		// Only way to get a string is to have the concrete class of that move.
		attack = factory.createWaterMoves();
		assertEquals("Tackle", attack[0].getName());
		assertEquals("Tailwhip", attack[1].getName());
		assertEquals("Surf", attack[2].getName());
		assertEquals("Whirlpool", attack[3].getName());
	}

	/**
	 * Tests the creation of the moves to make sure the factory actually returns Fire moves.
	 */
	@Test
	public void testFireFactory() 
	{
		MoveFactory factory = new MoveFactory();
		Move[] attack = new Move[4];
		
		// Uses the getName() method to test the factory since its Abstract in Move. Only way to get a string is to have the
		// Only way to get a string is to have the concrete class of that move.
		attack = factory.createFireMoves();
		assertEquals("Scratch", attack[0].getName());
		assertEquals("Growl", attack[1].getName());
		assertEquals("Flamethrower", attack[2].getName());
		assertEquals("Ember", attack[3].getName());
	}
	
	/**
	 * Tests the creation of the moves to make sure the factory actually returns Grass moves.
	 */
	@Test
	public void testGrassFactory() 
	{
		MoveFactory factory = new MoveFactory();
		Move[] attack = new Move[4];
		
		// Uses the getName() method to test the factory since its Abstract in Move. Only way to get a string is to have the
		// Only way to get a string is to have the concrete class of that move.
		attack = factory.createGrassMoves();
		assertEquals("Tackle", attack[0].getName());
		assertEquals("Growl", attack[1].getName());
		assertEquals("Razorleaf", attack[2].getName());
		assertEquals("Poisonsting", attack[3].getName());
	}
}
