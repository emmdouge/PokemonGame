package Commands;

import environment.Environment;
import exceptions.ItemException;

/**
 * Class used for processing the DownCommand triggered by the invoker
 * @author Joshua Bartle
 *
 */
public class DownCommand implements Command{

	Environment e; // instance variable for the current environment
	
	/**
	 * Method used for executing the DownCommand
	 * @throws ItemException
	 */
	@Override
	public void execute() throws ItemException {
		if(Environment.getEnv() == null) //if the environment is null use the mockEnvironment(for testing)
		e = Environment.getMockEnv();
		else // else use the real environment
		e = Environment.getEnv();
		e.setSelected(1, 0); // Method in environment that sets the currently selected choice
		e.update(); // update all observers
	}
	
}
