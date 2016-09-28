package moves;

import pokemon.Pokemon;

/**
 * A type of ability that scales damage off of the Special Attack stat and is negated by Special Defense.
 * @author Brandon Shawver
 */
public class Special implements AbilityType 
{

	protected int pokemonAttack;
	protected int pokemonDefense;
	protected int pokemonSAttack;
	protected int pokemonSDefense;
	protected String pokemonType;
	
	@Override
	public String getMoveType()
	{
		return "Special";
	}
	
	@Override
	public String getType() 
	{
		// Needs to return the users Type.
		return pokemonType;
	}
	
	@Override
	public int getDamage() 
	{
		// Of type Special so returns Sattack
		return pokemonSAttack;
	}

	@Override
	public int getDefense(Pokemon target) 
	{
		// Of type special so Special Defense will be negated from the damage.
		
		return target.getSpecialDefense();
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
