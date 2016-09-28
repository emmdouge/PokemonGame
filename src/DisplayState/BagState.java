package DisplayState;

import exceptions.ItemException;

/**
 * Class for changing the displays to the bag state
 * @author Joshua Bartle
 *
 */
public class BagState implements State{

	DisplaySwitch s; // instance of the display switch containing information on all states
	public BagState(DisplaySwitch s){
		this.s = s; // set display switch instance
	}
	
	/**
	 * Method for setting the current display to BagState and BagDisplay
	 */
	@Override
	public void setDisplay() throws ItemException {
		if(s.getEnv() == null) // if the environment is null use the mockEnvironment (for testing)
		s.getFrame().setBagDisplay(); // use the test frame method for swapping out displays
		else //else if the environment is not null
		s.getFinalFrame().setDisplay("item"); // use the final frame for testing
		s.setState(s.getBagState()); // set the current state to bag state
	}

}
