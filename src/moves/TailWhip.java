package moves;

import pokemon.Pokemon;

public class TailWhip extends Move 
{

	public TailWhip(StatChange stat) 
	{
		typeOfMove = stat;
	}

	@Override
	public int calcDamage() 
	{
		// Does no damage so return 0.
		return 0;
	}

	@Override
	public int calcDefense(int damage, Pokemon target) 
	{
		// Does no damage so can not be negated. Return 0.
		return 0;
	}

	@Override
	public boolean checkStatusChange(Pokemon target) 
	{
		// Lowers the Defense of the target.
		target.setDefense(target.getDefense() - 1);
		target.setSpecialDefense(target.getSpecialDefense() - 1);
		target.updateObservers();
		return true;
	}

	public String getName()
	{
		return "Tailwhip";
	}
}
