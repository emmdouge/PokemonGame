package pokemon;

import moves.Move;
import status.*;
/**
 * 
 * @author  Chris Kjeldgaard
 *
 */
public abstract class Pokemon 
{
	protected String name;//Name of the pokemon created.  In a larger implementation the player would have been able to set the name.
	protected int level;//the level of the pokemon, as level goes up pokemon get more powerful
	protected Move[] attacks;//the list of attacks that the pokemon knows
	private int attackPower;//between 2 and 3 per level
	private int specialAttackPower;//between 2 and 3 per level
	private int defense;//between .75 and 1.5 per level
	private int specialDefense;//between .75 and 1.5 per level
	private int currentHitpoints;//between 3 and 6 per level
	protected int maxHitpoints;//The highest curent hitpoints is ever allowed to get
	private Status currentStatus;//always starts at normal
	private Status normalStatus = new Normal(this);//the starting condition which allows pokemon to act normaly
	private Status poisonStatus = new Poison(this);//inflicts damage whenever the pokemon attempts to attack
	private Status burnStatus = new Burn(this);//inflicts damage whenever the pokemon attempts to attack
	private Status confusedStatus = new Confused(this);//gives a random chance of the attack going through normally or striking the pokemon making the attack
	private Status deadStatus = new Dead(this);//WHEN YOU ARE DEAD YOU CAN'T DO ANYTHING

	/**
	 * This is the method to call if the change of status is run through a status to see if it is a valid new state.
	 * @param newStatus
	 */
	public void changeStatus(Status newStatus)
	{//checks with status to see if the new status is a valid status for pokemon to enter
		currentStatus.changeStatus(newStatus);
	}
	public Status getPoisonStatus() {
		return poisonStatus;//returns the poisoned status
	}
	public Status getBurnStatus() {
		return burnStatus;//returns the burned status
	}
	public Status getConfusedStatus() {
		return confusedStatus;//returns the confused status
	}
	
	public Status getCurrentStatus() {
		return currentStatus;//returns the current status of the pokemon
	}
	/**
	 * sets the current status without checking with the status.  This method is overwritten in the type class to act like the change status method.
	 * Since all pokemon have a type and type wraps the pokemon class other then Status or pokemon can access this method.
	 * @param currentStatus
	 */
	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}
	public Status getNormalStatus() {
		return normalStatus;//returns the normal status
	}
	public Status getDeadStatus(){
		return deadStatus;//returns the dead status
	}
	public int getLevel() {
		return level;//returns the level of the pokemon
	}
	public int getAttackPower() {
		return attackPower;//returns the attack power of the pokemon
	}
	public void setAttackPower(int attackPower) {
		if(attackPower < 1)
		{//The lowest attackPower can reach is 1.
			attackPower = 1;
		}
		this.attackPower = attackPower;//sets attack power
		updateObservers();//call updateObservers to inform the moves that the stats of the pokemon have changed
	}
	public int getSpecialAttackPower() {
		return specialAttackPower;//returns the special attack power of the pokemon
	}
	public void setSpecialAttackPower(int specialAttackPower) {
		if(specialAttackPower < 1)
		{//The lowest special attack power can reach is 1
			specialAttackPower = 1;
		}
		this.specialAttackPower = specialAttackPower;//sets special attack power
		updateObservers();//call updateObservers to inform the moves that the stats of the pokemon have changed
	}
	public int getDefense() {
		return defense;//returns the defense of the pokemon
	}
	public void setDefense(int defense) {
		if(defense < 1)
		{//The lowest defense can reach is 1
			defense = 1;
		}
		this.defense = defense;//sets Defense
		updateObservers();//calls updateObservers because a stat has changed
	}
	public int getSpecialDefense() {
		return specialDefense;//returns the special defense of the pokemon
	}
	public void setSpecialDefense(int specialDefense) {
		if(specialDefense < 1)
		{//The lowest special defense a pokemon can reach is 1
			specialDefense = 1;
		}
		this.specialDefense = specialDefense;//sets Special defense
		updateObservers();//calls updateObservers to inform moves about the change
	}
	public int getCurrentHitpoints() {
		return currentHitpoints;//returns current hitpoints
	}
	public void setCurrentHitpoints(int currentHitpoints) {
		if(currentHitpoints < 0)
		{//The lowest the health of a pokemon can go is 0 which indicates the dead state
			currentHitpoints = 0;
			changeStatus(getDeadStatus());
		}
		else if(currentHitpoints > getMaxHitpoints())
		{//A pokemon cannot be healed past maximum hitpoints
			currentHitpoints = this.maxHitpoints;
		}
		this.currentHitpoints = currentHitpoints;
	}
	public int getMaxHitpoints() {
		return maxHitpoints;//returns the mex number of hitpoints
	}
	public String getName() {
		return name;//returns the name of the pokemon
	}
	public Move[] getAttacks() {
		return attacks;//returns the moves the pokemon knows
		//no pokemon should know more then 4 moves
	}
	public void makeAttack(Pokemon target, int i) {
		getCurrentStatus().makeAttack(i,target);
		//sends the attack request to status to allow status to influence the attack
	}
	public String getPokeType()
	{//as an abstract class pokemon has no type thus it returns a String to indicate that is has no type
		return "???";
	}
	
	public int calcDamage(int damage, String type)
	{//Since pokemon doesn't have a type calc damage the method used to check type damage only returns the damage sent to it no matter what the attacking damage is.
		return damage;
	}
	
	/**
	 * Add an observers to the array to be used by the Pokemon and then updated upon changes to the Pokemons stats.
	 * @param attacks - Moves that can be used in battle
	 * @author Brandon Shawver
	 */
	public void addObservers(Move[] attacks)
	{
		for(int i = 0; i < 4; i++)
		{
			this.attacks[i] = attacks[i];
		}
		updateObservers();
	}
	
	/**
	 * Removes a Move Observer from the list. Should never be used until the lab is expanded to learning new moves
	 * @param index - index of the array.
	 * @author Brandon Shawver
	 */
	public void removeObservers(int index)
	{
		attacks[index] = null;
	}
	
	/**
	 * Updates the Pokemons stats for the Move Observers.
	 * @author Brandon Shawver
	 */
	public void updateObservers()
	{
		for(int i = 0; i < 4; i++)
		{
			if(attacks[i] != null)
			{
				attacks[i].getTypeOfMove().updateStats(this.getAttackPower(), this.getSpecialAttackPower(),
					                                this.getDefense(), this.getSpecialDefense(), this.getPokeType());
			}
		}
	}
}
