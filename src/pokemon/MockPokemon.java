package pokemon;

import moves.Move;
import moves.MoveFactory;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public class MockPokemon extends Pokemon
{	
	public MockPokemon (String moveSet)
	{//creates a fake pokemon for testing purposes.  It has set states no matter the inputs to make math when testing easier.
		name = "FakePokemon";
		level = 100;
		attacks = new Move[4];
		maxHitpoints = 100;
		if(moveSet.equals("Fire"))
		{
			addObservers(new MoveFactory().createFireMoves());
		}
		if(moveSet.equals("Water"))
		{
			addObservers(new MoveFactory().createWaterMoves());
		}
		if(moveSet.equals("Grass"))
		{
			addObservers(new MoveFactory().createGrassMoves());
		}
		this.setAttackPower(100);
		this.setCurrentHitpoints(100);
		this.setCurrentStatus(this.getNormalStatus());
		this.setDefense(90);
		this.setSpecialDefense(90);
		this.setSpecialAttackPower(100);
	}
	
	public MockPokemon ()
	{
		this("Fire");
	}
	
	public MockPokemon(int level)
	{
		this();
	}
}
