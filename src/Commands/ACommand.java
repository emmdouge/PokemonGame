package Commands;

import environment.Environment;
import exceptions.ItemException;
/**
 * Class used to process when the A command is called by the invoker
 * @author Joshua Bartle
 *
 */

public class ACommand implements Command{

	Environment e; // instance variable of the current environment
	
	/**
	 * Method used for executing the ACommand
	 * @throws ItemException
	 */
	@Override
	public void execute() throws ItemException {
		if(Environment.getEnv() == null) // if the environment is null use the mock environment (for testing)
		e = Environment.getMockEnv();
		else
		e = Environment.getEnv(); // else use the real environment
		e.processAClicked();
		e.update();
	}

}
