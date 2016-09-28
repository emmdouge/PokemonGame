package moves;

import pokemon.Pokemon;

public class Razorleaf extends Move 
{

	public Razorleaf(Special razSpecial) 
	{
		typeOfMove = razSpecial;
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
		// TODO Auto-generated method stub
		return false;
	}

	public String getName()
	{
		return "Razorleaf";
	}
}
