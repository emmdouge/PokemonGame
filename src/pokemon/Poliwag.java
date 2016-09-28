package pokemon;

import moves.Move;
import moves.MoveFactory;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public class Poliwag extends Pokemon {
	public Poliwag ()
	{//If no level is provided the pokemon is created with the maximum level
		this(100);
	}
	/**
	 * constructor which gives the values to the pokemon super class to create a Poliwag
	 * @param level
	 */
	public Poliwag(int level)
	{
		if(level > 100)
		{//the highest level is 100 if a higher level is provided it lowers it to the max
			level = 100;
		}
		else if(level < 1)
		{//the lowest level is 1 if a lower level is provided it raises it to the min
			level = 1;
		}
		name = "Poliwag";
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
	 * Returns the type of the pokemon Poliwag
	 */
	public String getPokeType()
	{
		return "Water";
	}
}
