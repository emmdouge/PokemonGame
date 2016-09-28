package moves;

import pokemon.Pokemon;

/**
 * Provides the behavior different types of moves.
 * @author Brandon Shawver
 */
public interface AbilityType 
{
	public String getMoveType();
	
	public String getType();
	
	public int getDamage();
	
	public int getDefense(Pokemon target);
	
	public void updateStats(int Attack, int SAttack, int Defense, int SDefense, String type);
}
