package status;

import pokemon.Pokemon;
/**
 * 
 * @author ck0317
 *
 */
public class Burn extends Status {

	public Burn(Pokemon pokemon) {
		super(pokemon);
	}

	/**
	 * method which inflicts the damage for the burn condition and then makes the attack if it is still alive.
	 */
	@Override
	public void makeAttack(int attackChoosen, Pokemon target) 
	{
		//When under the effect of burn you take damage at the begining of your turn.
		subject.setCurrentHitpoints(subject.getCurrentHitpoints()-subject.getAttackPower()/10);
		
		if(subject.getCurrentHitpoints() > 0 )
		{//check to see if the subject died from burn damage.
			//if it is still alive it gets to make the attack
			subject.getAttacks()[attackChoosen].attack(target);
		}
		else
		{//otherwise its status changes to dead.
			changeStatus(subject.getDeadStatus());
		}
		
	}
	/**
	 * A burned pokemon can only change status to Normal or dead
	 */
	@Override
	public void changeStatus(Status newStatus) {
		if(newStatus.equals(subject.getNormalStatus()))
		{
			subject.setCurrentStatus(newStatus);
		}
		else if(newStatus.equals(subject.getDeadStatus()))
		{
			subject.setCurrentStatus(newStatus);
		}
	}
	
	/**
	 * Returns the acronym for the Burned Status
	 */
	public String toString()
	{
		return "BRN";
	}

}
