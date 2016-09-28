package Commands;

import environment.Environment;
import exceptions.ItemException;

/**
 * Class used to process the LeftCommand from the invoker buttons
 * @author Joshua Bartle
 *
 */
public  class LeftCommand implements Command{

	Environment e; // instance variable for the current environment
	
	/**
	 * Method for executing the Left Command
	 * @throws ItemException
	 */
	@Override
	public void execute() throws ItemException {
		if(Environment.getEnv() == null) // if the environment is null use the mockenvironment(for testing)
		e = Environment.getMockEnv();
		else // else use the real environment
		e = Environment.getEnv();
		e.setSelected(0, -1); // calls method in environment for setting current selection
		e.update(); // update all observers
	}

}
