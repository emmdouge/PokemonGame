package status;

import pokemon.Pokemon;
/**
 * 
 * @author ck0317
 *
 */
public abstract class Status {
	protected Pokemon subject;
	
	public Status(Pokemon subject)
	{
		this.subject = subject;
	}
	
	public abstract void makeAttack(int attachChoosen, Pokemon target);//the status conditions affect if the pokemon can make the attack
	public abstract void changeStatus(Status newStatus);//not all status effects can switch to other status effects
	public abstract String toString();//returns the acronym for the status condition afflicted.
}
