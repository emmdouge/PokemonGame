package status;

import pokemon.Pokemon;
/**
 * 
 * @author ck0317
 *
 */
public class Confused extends Status {

	public Confused(Pokemon pokemon) {
		super(pokemon);
	}

	/**
	 * when confused a pokemon have a 50% chance of hiting themselves with their move.
	 * this runs the numbers and either inflicts damage on themselves or their initial target.
	 */
	@Override
	public void makeAttack(int attackChoosen, Pokemon target) 
	{
		if(subject.getCurrentHitpoints() == 0)
		{
			changeStatus(subject.getDeadStatus());
		}
		else if(Math.random() > 0.5)
		{//The confused effect has a 50% chance to cause a Pokemon to hit itself instead of the other Pokemon.  
			subject.getAttacks()[attackChoosen].attack(subject);
		}
		else
		{//the other 50% of the time it makes the attack normally
			subject.getAttacks()[attackChoosen].attack(target);
		}
		
		if(subject.getCurrentHitpoints() == 0)
		{//checks to see if the pokemon is dead and transitions the state if it is
			changeStatus(subject.getDeadStatus());
		}
		else if(Math.random() > .75)
		{//the confused status has a percent chance of wearing off every round.
			subject.changeStatus(subject.getNormalStatus());
		}
	}

	/**
	 * once confused a pokemon can only transition to 2 other states this enforces that.
	 */
	@Override
	public void changeStatus(Status newStatus) {
		//once a Pokemon is confused it can not transition to a burned or poisoned status for the duration of the confused effect.
		//however it can transition into the dead or normal state.
		if(newStatus.equals(subject.getNormalStatus()))
		{
			subject.setCurrentStatus(newStatus);
		}
		else if (newStatus.equals(subject.getDeadStatus()))
		{
			subject.setCurrentStatus(subject.getDeadStatus());
		}
	}
	/**
	 * returns the acronym for the confused state
	 */
	public String toString()
	{
		return "CNF";
	}

}
