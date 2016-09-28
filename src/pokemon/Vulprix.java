package pokemon;

import moves.Move;
import moves.MoveFactory;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public class Vulprix extends Pokemon {
	public Vulprix ()
	{//assumes the level is 100 if no level is provided.
		this(100);
	}
	/**
	 * constructor to give the values to the pokemon super class to create a vulpix
	 * @param level
	 */
	public Vulprix(int level)
	{
		if(level > 100)
		{//the highest level any pokemon can achieve is level 100
			level = 100;
		}
		else if(level < 1)
		{//the lowest level any pokemon can achieve is level 1
			level = 100;
		}
		name = "Vulpix";
		this.level = level;
		attacks = new Move[4];
		maxHitpoints = (int)(level * 3);
		this.setAttackPower((int)(level * 3));
		this.setCurrentHitpoints(maxHitpoints);
		this.setCurrentStatus(this.getNormalStatus());
		this.setDefense((int)(.75*level));
		this.setSpecialDefense((int)(.75*level));
		this.setSpecialAttackPower((int)(3*level));
		addObservers(new MoveFactory().createFireMoves());
	}
	/**
	 * Returns the type of vulpix which is fire.
	 */
	public String getPokeType()
	{
		return "Fire";
	}
}
