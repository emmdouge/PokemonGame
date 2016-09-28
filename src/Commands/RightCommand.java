package Commands;

import environment.Environment;
import exceptions.ItemException;

/**
 * Class used for processing the RightCommand called by the invoker
 * @author Joshua Bartle
 *
 */
public class RightCommand implements Command{

	Environment e; // instance variable for current instance of environment
	
	/**
	 * method used for processing the Rightcommand
	 * @throws ItemException
	 */
	@Override
	public void execute() throws ItemException {
		if(Environment.getEnv() == null) // if the environment is null use the mock environment (for testing)
		e = Environment.getMockEnv();
		else //else use the real environment
		e = Environment.getEnv();
		e.setSelected(0, 1); // method in environment for setting the selected choice
		e.update(); // update all observers
	}

}
