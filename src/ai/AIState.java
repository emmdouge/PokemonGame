package ai;

import items.Bag;
import items.Item;
import pokemon.Pokemon;
import environment.Environment;
import exceptions.ItemException;

/**
 * @author Emmanuel
 *
 */
public abstract class AIState {

	protected AIContext aiContext;
	protected Environment env;
	
	/**
	 * @param aiContext access to the environment and ai's states
	 * @param env 
	 */
	public AIState(AIContext aiContext, Environment env)
	{
		this.aiContext = aiContext;
		this.env = env;
	}
	
	/**
	 * action taken when current state is called
	 */
	public abstract void execute();
	
	/**
	 * Will set the current state of the ai based on the health of the current target pokemon
	 */
	public void setStateBasedOnHitPoints() {
		if(env.getCurrentTarget().getCurrentHitpoints() <= env.getCurrentTarget().getMaxHitpoints()*.25)
		{
			aiContext.setCurrentState(aiContext.getCriticalHealthState());
		}
		else if(env.getCurrentTarget().getCurrentHitpoints() <= env.getCurrentTarget().getMaxHitpoints()*.50)
		{
			aiContext.setCurrentState(aiContext.getLowHealthState());
		}
		else
		{
			aiContext.setCurrentState(aiContext.getHighHealthState());
		}
	}
	
	/**
	 * @return true if the pokemon was successfully switched out
	 */
	public boolean switchPokemon()
	{
		boolean success = false;
		int index = 0;
		Pokemon[] targetTeam = env.getTeam("target");
		Pokemon[] possiblePokemonToChooseFrom = new Pokemon[6];

		for(int i = 0; i < 6; i++)
		{
			if(targetTeam[i].getCurrentHitpoints() > 0)
			{
				possiblePokemonToChooseFrom[index] = targetTeam[i];
				index++;
			}
		}
		
		if(index > 0)
		{
			int randomLivePokemon = (int)(Math.random()*index);
			env.setCurrentTarget(possiblePokemonToChooseFrom[randomLivePokemon]);
			success = true;
		}
		
		return success;
	}
	
	/**
	 * Makes the current target pokemon attack the player's current pokemon
	 */
	public void attackPlayer()
	{
		int move = (int)(Math.random()*4);
		env.getCurrentTarget().makeAttack(env.getCurrentPlayer(), move);
	}
	
	/**
	 * @return true if an item was used
	 * @throws ItemException
	 */
	public boolean useItem() throws ItemException 
	{
		boolean success = false;
		int index = 0;
		Bag targetBag = env.getTargetBag();
		Item[] possibleItemsToUse = new Item[6];

		for(int i = 0; i < 6; i++)
		{
			if(targetBag.getItem(i).isEmpty() == false)
			{
				possibleItemsToUse[index] = targetBag.getItem(i);
				index++;
			}
		}
		
		if(index > 0)
		{
			int randomItem = (int)(Math.random()*index);
			possibleItemsToUse[randomItem].use(env.getCurrentTarget());;
			success = true;
		}
		
		return success;
		
	}
	
	/**
	 * @return the aiContext instance variable
	 */
	public AIContext getAI()
	{
		return aiContext;
	}
}
