package pokemon;

import moves.*;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public class Blastoise extends Pokemon
{
	public Blastoise ()
	{
		this(100);
	}
	
	public Blastoise(int level)
	{
		if(level > 100)
		{// the max level any pokemon can achieve is level 100
			level = 100;
		}
		else if(level < 1)
		{// the min level any pokemon can make it to is level 1
			level = 1;
		}
		name = "Blastoise";
		this.level = level;
		attacks = new Move[4];
		addObservers(new MoveFactory().createWaterMoves());
		maxHitpoints = (int)(level * 4.5);
		this.setAttackPower((int)(level * 2.5));
		this.setCurrentHitpoints(maxHitpoints);
		this.setCurrentStatus(this.getNormalStatus());
		this.setDefense((int)(1.1*level));
		this.setSpecialDefense((int)(1.1*level));
		this.setSpecialAttackPower((int)(2.5*level));
	}

	/**
	 * Returns the type of the pokemon Blastoise
	 */
	public String getPokeType()
	{
		return "Water";
	}
}
