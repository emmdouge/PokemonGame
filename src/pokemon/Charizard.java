package pokemon;

import moves.Move;
import moves.MoveFactory;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public class Charizard extends Pokemon {
	public Charizard ()
	{//If no level is provided the pokemon is created with the maximum level
		this(100);
	}
	/**
	 * constructor which gives the values to the pokemon super class to create a Charizard
	 * @param level
	 */
	public Charizard(int level)
	{
		if(level > 100)
		{//the max level is 100 so this lowers the level to the max if it is above that
			level = 100;
		}
		else if(level < 1)
		{//the min level is 1 so this raises the level to the min
			level = 1;
		}
		name = "Charizard";
		this.level = level;
		attacks = new Move[4];
		maxHitpoints = (int)(level * 3);
		this.setAttackPower((int)(level * 3));
		this.setCurrentHitpoints(maxHitpoints);
		this.setCurrentStatus(this.getNormalStatus());
		this.setDefense((int)(.75*level));
		this.setSpecialDefense((int)(.75*level));
		this.setSpecialAttackPower((int)(3*level));
		addObservers( new MoveFactory().createFireMoves());
	}

	/**
	 * Returns the type of the pokemon Charizard
	 */
	public String getPokeType()
	{
		return "Fire";
	}
}
