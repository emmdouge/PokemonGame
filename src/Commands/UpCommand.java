package Commands;
import environment.Environment;
import exceptions.ItemException;

/**
 * Class for processing the UpCommand called by the invoker
 * @author Joshua Bartle
 *
 */
public class UpCommand implements Command{

	Environment e = null; // instance variable for the current environment
	
	/**
	 * Method used for processing the UpCommand
	 * @throws ItemException
	 */
	@Override
	public void execute() throws ItemException {
		if(Environment.getEnv() == null) //if the environment is null use the mock environment(for testing)
		e = Environment.getMockEnv();
		else //else use the real environment
		e = Environment.getEnv();
		e.setSelected(-1, 0); // method in environment for setting the selected choice
		e.update(); // update the observers in environment
	}

}
