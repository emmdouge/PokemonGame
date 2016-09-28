package pokemon;

import moves.Move;
import moves.MoveFactory;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public class Wartortle extends Pokemon {
	public Wartortle ()
	{//a constructor that is called if the level of the pokemon is not created
		this(100);
	}
	/**
	 * Constructors which define the values of Wartortle to use the pokemon super class
	 * @param level
	 */
	public Wartortle(int level)
	{
		if(level > 100)
		{// the max level any pokemon can achieve is level 100
			level = 100;
		}
		else if(level < 1)
		{// the min level any pokemon can make it to is level 1
			level = 1;
		}
		name = "Wartortle";
		this.level = level;
		attacks = new Move[4];
		maxHitpoints = (int)(level * 4.5);
		this.setAttackPower((int)(level * 2.5));
		this.setCurrentHitpoints(maxHitpoints);
		this.setCurrentStatus(this.getNormalStatus());
		this.setDefense((int)(1.1*level));
		this.setSpecialDefense((int)(1.1*level));
		this.setSpecialAttackPower((int)(2.5*level));
		addObservers(new MoveFactory().createWaterMoves());
	}
	/**
	 * the type of wartortle is water
	 */
	public String getPokeType()
	{
		return "Water";
	}
}
