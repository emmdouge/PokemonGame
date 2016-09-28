package ai;

import environment.Environment;

/**
 * @author Emmanuel
 *
 */
public class AIContext {
	private AIState highHealthState;
	private AIState lowHealthState;
	private AIState criticalHealthState;
	private AIState currentState;
	
	/**
	 * Inits the states within AIContext and sets the current state to highHealthState
	 * @param env 
	 */
	public AIContext(Environment env)
	{
		highHealthState = new HighHealthState(this, env);
		lowHealthState = new LowHealthState(this, env);
		criticalHealthState = new CriticalHealthState(this, env);
		currentState = getHighHealthState();
	}

	/**
	 * will execute the current state's execute method
	 */
	public void execute()
	{
		getCurrentState().execute();
	}
	
	/**
	 * @return highHealthState
	 */
	public AIState getHighHealthState() {
		return highHealthState;
	}
	
	/**
	 * @return lowHealthState
	 */
	public AIState getLowHealthState() {
		return lowHealthState;
	}
	
	/**
	 * @return criticalHealthState
	 */
	public AIState getCriticalHealthState() {
		return criticalHealthState;
	}
	
	/**
	 * @return the current state of the pokemon
	 */
	public AIState getCurrentState() {
		return currentState;
	}
	
	/**
	 * @param state state to set the current state to
	 */
	public void setCurrentState(AIState state)
	{
		currentState = state;
	}

	
	
}
