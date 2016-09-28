package DisplayState;

import exceptions.ItemException;

public class MainState implements State{

	DisplaySwitch s; // instance variable for the displaySwitch
	public MainState(DisplaySwitch s){
		this.s = s; // set the instance of display switch
	}

	/**
	 * Method for setting the display state to Main state and calls
	 * method to switch displays
	 */
	@Override
	public void setDisplay() throws ItemException {
		s.getFinalFrame().setDisplay("main"); // call method to set new display in frame
		s.setState(s.getMainState()); // switch states to main state
	}

}
