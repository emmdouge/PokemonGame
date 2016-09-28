package DisplayState;

import exceptions.ItemException;

/**
 * Class for setting the Bag State and calling methods to 
 * switch out the displays
 * @author Joshua Bartle
 *
 */
public class FightState implements State{

	DisplaySwitch s; // instance of display switch containing information on states
	public FightState(DisplaySwitch s){
		this.s = s; // set the DisplaySwitch
	}

	/**
	 * Method for setting the new state and switching out the displays
	 * @throws ItemException
	 */
	@Override
	public void setDisplay() throws ItemException {
		if(s.getEnv() == null) // if the environment is null use the mockdisplay
		s.getFrame().setFightDisplay();
		else // else use the final display 
		s.getFinalFrame().setDisplay("fight");
		s.setState(s.getFightState()); // set the state to fight state
	}

}
