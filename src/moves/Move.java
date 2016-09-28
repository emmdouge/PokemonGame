package moves;

import pokemon.Pokemon;

public abstract class Move 
{
	protected AbilityType typeOfMove;
	//private int PowerPoints;       // MAY BE IMPLEMENTED LATER BUT FOR NOW IGNORE.
									 // Number of times an ability can be used. If all moves are 0 PowerPoints then the pokemon uses
	                                 // an auto attack that deals 1/2 of the attack stat and then does 1/4 of the attack stat to iteself
	
	public abstract int calcDamage();
	
	public int calcTypeAdvantage(int damage, Pokemon target)
	{
		int typeAdvantage;
		
		if(typeOfMove.getMoveType() == "Special")
		{
			typeAdvantage = target.calcDamage(damage, typeOfMove.getType());
		}
		else
		{
			typeAdvantage = damage;
		}
		return typeAdvantage;
	}
	
	public abstract int calcDefense(int damage, Pokemon target);
	public abstract boolean checkStatusChange(Pokemon target);
	
	/**
	 * Outline of the Template Pattern
	 * 		- typeOfMove get damage - SAttack or Attack
	 * 		- Multiply type advantage first
	 * 		- typeOfMove negate damage based on defense - SDefense or Defense
	 * 		- check for status effect. Status effects happen 100% of the time.
	 * @param target - The pokemon the user of this move is fighting. 
	 */
	public void attack(Pokemon target)
	{
		int damage = 0;
		
		damage = calcDamage();
		damage = calcTypeAdvantage(damage, target);
		damage = calcDefense(damage, target);
		checkStatusChange(target);
		target.setCurrentHitpoints(target.getCurrentHitpoints() - damage);
	}
	
	public AbilityType getTypeOfMove()
	{
		return typeOfMove;
	}

	public abstract String getName();
}

/*Fire Moves*/
/**
 * Scratch 
 * Ember          - Status effect burn, lower base damage ie. = SAttack
 * Growl          - Attack Power lower - Sattack and attack
 * Flamethrower   - Increased base damage - mult 1.5
 */

/*Water Moves*/
/**
 * Tackle 
 * Surf        - Increased base damage - mult 1.5
 * Tail-Whip   - Defense power lower - Sdefense and defense
 * Whirlpool   - Status effect confusion, lower base damage ie. = SAttack
 */

/*Grass Moves*/
/**
 * Tackle
 * Razorleaf   - Increased base damage - mult 1.5
 * Growl       - Attack Power lower - Sattack and attack
 * PoisonSting - Status effect poison, lower base damage ie. = SAttack
 */