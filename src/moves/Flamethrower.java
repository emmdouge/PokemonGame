package moves;

import pokemon.Pokemon;

public class Flamethrower extends Move 
{

	public Flamethrower(Special flamSpecial) 
	{
		typeOfMove = flamSpecial;
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
		return "Flamethrower";
	}
}
