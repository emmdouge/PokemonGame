package moves;

import pokemon.Pokemon;

public class Surf extends Move 
{

	public Surf(Special surfSpecial) 
	{
		typeOfMove= surfSpecial;
	}

	@Override
	public int calcDamage() 
	{
		int damage;
		damage = (int) (typeOfMove.getDamage()* 1.5);
		return damage;
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
		return false;
	}

	public String getName()
	{
		return "Surf";
	}
}
