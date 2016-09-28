package pokemon;

import moves.Move;
import moves.MoveFactory;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public class Bulbasaur extends Pokemon
{
	public Bulbasaur ()
	{
		this(100);
	}
	
	public Bulbasaur(int level)
	{
		if(level > 100)
		{// the max level any pokemon can achieve is level 100
			level = 100;
		}
		else if(level < 1)
		{// the min level any pokemon can make it to is level 1
			level = 1;
		}
		name = "Bulbasaur";
		this.level = level;
		attacks = new Move[4];
		maxHitpoints = (int)(level * 6);
		this.setAttackPower((int)(2*level));
		this.setCurrentHitpoints(maxHitpoints);
		this.setCurrentStatus(this.getNormalStatus());
		this.setDefense((int)(1.5*level));
		this.setSpecialDefense((int)(1.5*level));
		this.setSpecialAttackPower((int)(2*level));
		addObservers( new MoveFactory().createGrassMoves());
	}
	/**
	 * Returns the type of the pokemon Bulbasaur
	 */
	public String getPokeType()
	{
		return "Grass";
	}
}
