package Commands;

import exceptions.ItemException;
/**
 * Interface for all commands containing the execute method for the commands
 * @author Joshua Bartle
 *
 */
public interface Command {
	 /**
	  * Method used for executing a specific command of type Command
	  * @throws ItemException
	  */
		public void execute() throws ItemException;
}
