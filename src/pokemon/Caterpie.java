package pokemon;

import moves.Move;
import moves.MoveFactory;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public class Caterpie extends Pokemon{
	public Caterpie ()
	{
		this(100);
	}
	
	public Caterpie(int level)
	{
		if(level > 100)
		{// the max level any pokemon can achieve is level 100
			level = 100;
		}
		else if(level < 1)
		{// the min level any pokemon can make it to is level 1
			level = 1;
		}
		name = "Caterpie";
		this.level = level;
		attacks = new Move[4];
		maxHitpoints = (int)(level * 6);
		this.setAttackPower((int)(level * 2));
		this.setSpecialAttackPower((int)(level*2));
		this.setCurrentHitpoints(maxHitpoints);
		this.setCurrentStatus(this.getNormalStatus());
		this.setDefense((int)(1.5*level));
		this.setSpecialDefense((int)(1.5*level));
		addObservers( new MoveFactory().createGrassMoves());
	}

	/**
	 * Returns the type of the pokemon Caterpie
	 */
	public String getPokeType()
	{
		return "Grass";
	}
}
