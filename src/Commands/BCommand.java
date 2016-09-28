package Commands;

import environment.Environment;
import exceptions.ItemException;

/**
 * Class used to process the B command when called by the invoker
 * @author Joshua Bartle
 *
 */
public class BCommand implements Command{

	Environment e; // instance variable for the current environment
	
	/**
	 * Method used for executing the B Command
	 * @throws Itemexception
	 */
	@Override
	public void execute() throws ItemException {
		if(Environment.getEnv() == null) // if the environment is null use the mock environment (for testing)
		e = Environment.getMockEnv();
		else	// else use the real environment
		e = Environment.getEnv();
		e.processBClicked();
		e.update();
	}
}
