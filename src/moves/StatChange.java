package moves;

import pokemon.Pokemon;

/**
 * A type of ability that effects the stats of the user or the target pokemon.
 * @author Brandon Shawver
 */
public class StatChange implements AbilityType 
{

	protected int pokemonAttack;
	protected int pokemonDefense;
	protected int pokemonSAttack;
	protected int pokemonSDefense;
	protected String pokemonType;

	@Override
	public String getMoveType() 
	{
		return "StatChange";
	}
	
	@Override
	public String getType() 
	{
		// Needs to return the users type
		return pokemonType;
	}

	@Override
	public int getDamage() 
	{
		// Of Type Stat Change so does not scale from any attack. Return 0.
		return 0;
	}

	@Override
	public int getDefense(Pokemon target) 
	{
		// Of Type Stat Change so does not scale from any defense. Return 0.
		return 0;
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
