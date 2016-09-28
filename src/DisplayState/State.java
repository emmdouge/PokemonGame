package DisplayState;

import exceptions.ItemException;

/**
 * Interface class used by all states for displays
 * @author Joshua Bartle
 *
 */
public interface State {
	/**
	 * method used by all State types for switching states
	 * @throws ItemException
	 */
		public void setDisplay() throws ItemException;
}
