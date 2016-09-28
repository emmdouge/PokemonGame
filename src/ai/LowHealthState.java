package ai;

import environment.Environment;
import exceptions.ItemException;

/**
 * @author Emmanuel
 *
 */
public class LowHealthState extends AIState {

	/**
	 * @param aiContext access to the environment and ai's states
	 * @param env 
	 */
	public LowHealthState(AIContext aiContext, Environment env) {
		super(aiContext, env);
	}

	@Override
	public void execute() {
		
		//Check if my current pokemon is dead, if so Check if I have pokemon left. If I do, switch to next pokemon and setCurrentState to HasPokemon. If I dont, I have been defeated.
		if(env.getCurrentTarget().getCurrentHitpoints() <= 0)
		{
			System.out.println(env.getCurrentTarget().getName() + " has fainted!");
			switchPokemon();		
		}
		//Check if my current pokemon is alive, if so, attack or use a healing item(35%)
		//then set the current state based on the current hit points
		else
		{
			boolean success = false;
			double randomNum = Math.random();
			if(randomNum < .50)
			{
				try 
				{
					success = useItem();
				} 
				catch (ItemException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(success == false)
				{
					attackPlayer();
					System.out.println("No items left to use. Attack!");
				}
				else
				{
					System.out.println("Item used!");
				}
			}
			else
			{
				attackPlayer();
			}
		}
		
		setStateBasedOnHitPoints();
	}



}
