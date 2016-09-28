package moves;

import pokemon.Pokemon;

public class Ember extends Move 
{

	public Ember(Special brnSpecial) 
	{
		typeOfMove = brnSpecial;
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
		// TODO NEEDS TO BURN THE TARGET
		target.changeStatus(target.getBurnStatus());
		return true;
	}
	
	public String getName()
	{
		return "Ember";
	}
}
