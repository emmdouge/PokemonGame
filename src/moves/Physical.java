package moves;

import pokemon.Pokemon;

/**
 * A type of ability that scales damage off of the Attack stat and is negated by Defense.
 * @author Brandon Shawver
 */
public class Physical implements AbilityType 
{
	protected int pokemonAttack;
	protected int pokemonDefense;
	protected int pokemonSAttack;
	protected int pokemonSDefense;
	protected String pokemonType;
	
	@Override
	public String getMoveType() 
	{
		return "Physical";
	}

	@Override
	public String getType() 
	{
		// Returns the users type
		return pokemonType;
	}
	
	public int getDamage() 
	{
		// Of type physical so return Attack
		return pokemonAttack;
	}

	public int getDefense(Pokemon target) 
	{
		// Of type Physical so return Defense
		return target.getDefense();
	}
	
	@Override
	public void updateStats(int Attack, int SAttack, int Defense, int SDefense, String type)
	{
		pokemonAttack = Attack;
		pokemonSAttack = SAttack;
		pokemonDefense = Defense;
		pokemonSDefense = SDefense;
		pokemonType = type;
	}
}
