package moves;

import pokemon.Pokemon;

public class Tackle extends Move {
	

	public Tackle(Physical phy) 
	{
		typeOfMove = phy;
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
		return false;
	}

	public String getName()
	{
		return "Tackle";
	}
}
