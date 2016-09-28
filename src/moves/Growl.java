package moves;

import pokemon.Pokemon;

public class Growl extends Move 
{
	public Growl(StatChange stat) 
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
		// Lowers the targets attack power.
		target.setAttackPower(target.getAttackPower() - 1);
		target.setSpecialAttackPower(target.getSpecialAttackPower() - 1);
		target.updateObservers();
		return true;
	}
	
	public String getName()
	{
		return "Growl";
	}
}
