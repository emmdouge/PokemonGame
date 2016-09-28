package DisplayState;

import exceptions.ItemException;

/**
 * Class used for setting the PokemonSelectState and calling frame
 * method for swapping out displays
 * @author Joshua Bartle
 *
 */
public class PokemonSelect implements State{

	DisplaySwitch s; // instance variable for the DisplaySwitch
	public PokemonSelect(DisplaySwitch s){
		this.s = s; // set the instance of DisplaySwitch
	}

	/**
	 * Method for setting state to PokemonSelectState and calls
	 * methods for switching displays
	 */
	@Override
	public void setDisplay() throws ItemException {
		if(s.getEnv() == null) // if the environment is null us the mockframe
		s.getFrame().setSelectDisplay();
		else // else use the final frame
		s.getFinalFrame().setDisplay("switch");
		s.setState(s.getSelectState()); // method for changing the states
	}
	
}
