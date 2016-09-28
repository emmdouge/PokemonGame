package DisplayState;

import static org.junit.Assert.*;

import org.junit.Test;

import ai.AIContext;
import pokemon.Caterpie;
import pokemon.Charmander;
import pokemon.Ivysaur;
import pokemon.Pokemon;
import pokemon.Poliwag;
import pokemon.Squirtle;
import pokemon.Vulprix;
import pokemon.Wartortle;
import Display.MockDisplayFrame;
import environment.Environment;
import exceptions.ItemException;

/**
 * Class for testing that the display states are changing correctly 
 * @author Joshua Bartle
 *
 */
public class TestDisplayState {

	/**
	 * Method for testing that states are changed correctly
	 * @throws InterruptedException
	 * @throws ItemException
	 */
	@Test
	public void testStateChanges() throws InterruptedException, ItemException{
		
		Environment.clearEnv(); // clear the environment
		Environment e = Environment.createMockEnv(); // create a new mock environment
		AIContext ai = new AIContext(e);
		e.setAI(ai);
		Pokemon[] t = e.getTeam("target");
		e.setCurrentTarget(t[0]);
		/*
		 * Add pokemon to the environment
		 */
		Pokemon p1 = new Wartortle(3);
		Pokemon p2 = new Ivysaur(22);
		Pokemon p3 = new Vulprix();
		Pokemon p4 = new Squirtle();
		Pokemon p5 = new Poliwag();
		Pokemon p6 = new Charmander();
		
		/*
		 * Add the pokemon to the environment
		 */
		e.addPokemon(p1, 0, 0);
		e.addPokemon(p2, 0, 1);
		e.addPokemon(p3, 1, 0);
		e.addPokemon(p4, 1, 1);
		e.addPokemon(p5, 2, 0);
		e.addPokemon(p6, 2, 1);
		e.update(); // update the environment
		MockDisplayFrame frame = MockDisplayFrame.getInstance();
		DisplaySwitch s = frame.getSwitch(); // get the instance of display switch
		
		// did the state start in the pokemon select state
		assertTrue(s.getCurrent() == s.getSelectState());
		
		Thread.sleep(1500);
		e.update(); // update the display
		s.startFight(); // switch to fight state
		e.update();
		Thread.sleep(1500);
		
		Thread.sleep(1500);
		e.setSelected(0, 1); // move to the bag option
		e.update(); // update display
		Thread.sleep(1500);
		e.update();
		s.openbag(); // switch to the open bag state
		e.update();
		Thread.sleep(1500);
		
		assertTrue(s.getCurrent() == s.getBagState()); // are we in the bag state?
	}
}
