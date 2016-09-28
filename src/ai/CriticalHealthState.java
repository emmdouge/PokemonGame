package ai;

import environment.Environment;

/**
 * @author Emmanuel
 *
 */
public class CriticalHealthState extends AIState {

	/**
	 * @param aiContext access to the environment and ai's states
	 */
	public CriticalHealthState(AIContext aiContext, Environment env) {
		super(aiContext, env);
	}

	@Override
	public void execute() {
		
		
		//Check if my current pokemon is dead, if so Check if I have pokemon left. If I do, switch to next pokemon and setCurrentState to based on pokemon's hit points. If I dont, I have been defeated.
		if(env.getCurrentTarget().getCurrentHitpoints() <= 0)
		{
			System.out.println(env.getCurrentTarget().getName() + " has fainted!");
			switchPokemon();		
		}
		//Check if my current pokemon is alive, if so, attack or switch pokemon(35%)
		//then set the current state based on the current hit points
		else
		{
			double randomNum = Math.random();
			if(randomNum < .90)
			{
				switchPokemon();
				System.out.println("Enemy switched Pokemons!");
			}
			else
			{
				attackPlayer();
			}
		}
		setStateBasedOnHitPoints();
		
	}
	




}
