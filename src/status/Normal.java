package status;

import pokemon.Pokemon;
/**
 * 
 * @author ck0317
 *
 */
public class Normal extends Status
{
	public Normal(Pokemon subject) {
		super(subject);
	}
	/**
	 *  As long as the pokemon is not dead a pokemon under the normal status can make any attack it contains
	 */
	@Override
	public void makeAttack(int attackChoosen, Pokemon target) 
	{
		if(subject.getCurrentHitpoints() == 0)
		{
			changeStatus(subject.getDeadStatus());
		}
		else
		{
			subject.getAttacks()[attackChoosen].attack(target);
		}
	}
	/**
	 * a pokemon under the normal status can change to any other status it wants to.
	 */
	@Override
	public void changeStatus(Status newStatus) 
	{
		subject.setCurrentStatus(newStatus);
	}
	/**
	 * the normal status has no acronym
	 */
	public String toString()
	{
		return "   ";
	}

}
