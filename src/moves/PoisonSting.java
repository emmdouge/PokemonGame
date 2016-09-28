package moves;

import pokemon.Pokemon;

public class PoisonSting extends Move 
{

	public PoisonSting(Special psnSpecial) 
	{
		typeOfMove = psnSpecial;
	}

	@Override
	public int calcDamage() 
	{
		return typeOfMove.getDamage();
	}

	@Override
	public int calcDefense(int damage, Pokemon target) 
	{
		int calcDefense;
		calcDefense = damage - typeOfMove.getDefense(target);
		return calcDefense;
	}

	@Override
	public boolean checkStatusChange(Pokemon target) 
	{
		// TODO NEEDS TO POISON THE TARGET
		target.changeStatus(target.getPoisonStatus());
		return true;
	}

	public String getName()
	{
		return "Poisonsting";
	}
}
