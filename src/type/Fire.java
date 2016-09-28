package type;

import pokemon.Pokemon;
/**
 * @author  Chris Kjeldgaard
 *
 */
public class Fire extends Type
{
	
	public Fire(Pokemon sub)
	{
		super(sub);
	}
	
	public int calcDamage(int damage, String attack)
	{//When attacked by certain moves the amount of damage taken either gets reduced or increased depending on type dependency
		if(attack.contains("Water"))
		{//a water attack striking a fire pokemon gets doubled in power
			return 2* subject.calcDamage(damage, attack);
		}
		else if(attack.contains("Grass"))
		{//a grass attack striking a fire pokemon gets halved in power
			return subject.calcDamage(damage, attack)/2;
		}
		else if (attack.contains("Fire"))
		{//a fire attack striking a fire pokemon gets halved in power
			return subject.calcDamage(damage, attack)/2;
		}
		//with only the 3 implementations of types all others deal normal damage which is not increased or decreased
		return subject.calcDamage(damage, attack);
	}
	
	@Override
	public String getPokeType() {
		//returns the String name of the type the pokemon has
		return "Fire";
	}
}
