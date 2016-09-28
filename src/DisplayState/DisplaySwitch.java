package DisplayState;
import mainGUI.GameFrame;
import environment.Environment;
import exceptions.ItemException;
import Display.Display;
import Display.MockDisplayFrame;

/**
 * Class used for creating states and storing information that 
 * the different states need to access for changing out displays
 * and changing states
 * @author Joshua Bartle
 *
 */
public class DisplaySwitch {
	State PokemonSelect; // State variable for PokemonSelection state
	State FightState; // State variable for FightState
	State BagState; // State variable for BagState
	State mainState; // State variable for mainState
	State currentState; // State variable for the currentState
	
	/**
	 * Constructor for setting up and creating the states
	 */
	public DisplaySwitch(){
		PokemonSelect = new PokemonSelect(this); // create PokemonSelectState
		FightState = new FightState(this); // create FightState
		BagState = new BagState(this); // create BagState
		mainState = new MainState(this); // create MainState
		currentState = PokemonSelect; // set the default state
	}

	/**
	 * Method for getting the MockDisplay frame
	 * this method is only used for testing purposes
	 * @return the MockDisplayFrame from the MockDisplayFrame.class
	 */
	public MockDisplayFrame getFrame(){
		return MockDisplayFrame.getInstance();
	}
	
	/**
	 * Method for getting the finalFrame for the final game
	 * @return the frame for GameFrame.class
	 */
	public GameFrame getFinalFrame(){
		return GameFrame.getFrame();
	}
	
	/**
	 * Method for setting a new state
	 * @param s the new state to be set
	 */
	public void setState(State s){
		currentState = s;
	}
	
	/**
	 * Method used to get the current state
	 * @return the current state
	 */
	public State getCurrent(){
		return currentState;
	}
	
	/**
	 * Method used to set the Fight Display
	 * @throws ItemException
	 */
	public void startFight() throws ItemException{
		FightState.setDisplay(); // call setDisplay in FightState
	}
	
	/**
	 * Method used to set the PokemonSelectionDisplay
	 * @throws ItemException
	 */
	public void selectPokemon() throws ItemException{
		PokemonSelect.setDisplay(); // call setDisplay in PokemonSelect
	}
	
	/**
	 * Method for opening the bag
	 * @throws ItemException
	 */
	public void openbag() throws ItemException{
		BagState.setDisplay(); // call setDisplay in BagState
	}
	
	/**
	 * method for getting the mainState
	 * @return mainState
	 */
	public State getMainState(){
		return mainState;
	}
	
	/**
	 * Method for getting the BagState
	 * @return BagState
	 */
	public State getBagState(){
		return BagState;
	}
	
	/**
	 * Method for getting the FightState
	 * @return FightState
	 */
	public State getFightState(){
		return FightState;
	}
	
	/**
	 * Method used for getting the PokemonSelectState
	 * @return PokemonSelect
	 */
	public State getSelectState(){
		return PokemonSelect;
	}
	
	/**
	 * Method used to set the main display in the battle scene
	 * @throws ItemException
	 */
	public void setMain() throws ItemException{
		mainState.setDisplay();
	}
	
	/**
	 * Method for getting the instance of environment
	 * used to check if null of not for testing purposes
	 * if null we use mockenv
	 * @return an instance of environment
	 */
	public Environment getEnv(){
		return Environment.getEnv();
	}
	
	
}
