package moves;

import pokemon.Pokemon;

public class Whirlpool extends Move 
{

	public Whirlpool(Special conSpecial) 
	{
		typeOfMove = conSpecial;
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
		// TODO NEEDS TO CONFUSE THE TARGET
		target.changeStatus(target.getConfusedStatus());
		return true;
	}

	public String getName()
	{
		return "Whirlpool";
	}
}
