package status;

import pokemon.Pokemon;
/**
 * 
 * @author ck0317
 *
 */
public class Dead extends Status
{
	public Dead(Pokemon subject) {
		super(subject);
	}
	/**
 	 * The dead can't make attacks so this takes the input and doesn't execute any commands
 	 */
	@Override
	public void makeAttack(int attackChoosen, Pokemon target) 
	{
		//When your dead you can't do anything.
	}
	/**
	 * since we don't have revives no pokemon can change status once it dies.
	 */
	@Override
	public void changeStatus(Status newStatus) 
	{
		//As of right now our plan does not include the ability to revive pokemon
		//AKA the dead stay DEAD
	}
	/**
	 * returns the acronym for the dead state.
	 */
	public String toString()
	{
		return "FNT";
	}

}
