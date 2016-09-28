package ai;

import environment.Environment;

/**
 * @author Emmanuel
 *
 */
public class HighHealthState extends AIState {

	/**
	 * @param aiContext access to the environment and ai's states
	 * @param env 
	 */
	public HighHealthState(AIContext aiContext, Environment env) {
		super(aiContext, env);
	}

	@Override
	public void execute() {
		
		//Check if my current pokemon is dead, if so Check if I have pokemon left. If I do, switch to next pokemon. If I dont, I have been defeated.
		if(env.getCurrentTarget().getCurrentHitpoints() <= 0)
		{
			System.out.println(env.getCurrentTarget().getName() + " has fainted!");
			switchPokemon();		
		}
		//Check if my current pokemon is alive, if so, attack
		//then set the current state based on the current hit points
		else
		{
			attackPlayer();
		}
		setStateBasedOnHitPoints();
	}

}
