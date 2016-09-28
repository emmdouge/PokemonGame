package Commands;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import ai.AIContext;
import pokemon.Blastoise;
import pokemon.Bulbasaur;
import pokemon.Caterpie;
import pokemon.Charizard;
import pokemon.Ivysaur;
import pokemon.Pokemon;
import pokemon.Vulprix;
import Display.MockDisplayFrame;
import environment.Environment;
import exceptions.ItemException;

/**
 * Class for testing that the invoker command work correctly
 * @author Joshua Bartle
 *
 */
public class TestInvokerCommands {

	/**
	 * Method for testing the invoker commands
	 * @throws InterruptedException
	 * @throws ItemException
	 */
	@Test
	public void test() throws InterruptedException, ItemException {
		Environment.clearEnv(); // clear the environment
		/*
		 * Start of testing
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Lets test the Command, Yes to continue"));
		Environment e = Environment.createMockEnv(); // create a mock environment
		AIContext ai = new AIContext(e);
		e.setAI(ai);
		Pokemon[] t = e.getTeam("target");
		e.setCurrentTarget(t[0]);
		/*
		 * Create pokemon for the Environment
		 */
		Pokemon p1 = new Caterpie(3);
		Pokemon p2 = new Blastoise(22);
		Pokemon p3 = new Vulprix();
		Pokemon p4 = new Charizard();
		Pokemon p5 = new Ivysaur();
		Pokemon p6 = new Bulbasaur();
		
		/*
		 * Add pokemon to the environment
		 */
		e.addPokemon(p1, 0, 0);
		e.addPokemon(p2, 0, 1);
		e.addPokemon(p3, 1, 0);
		e.addPokemon(p4, 1, 1);
		e.addPokemon(p5, 2, 0);
		e.addPokemon(p6, 2, 1);
		e.update(); // update the environment
		
		Thread.sleep(3000);
		Command down = new DownCommand(); // create a new down command
		down.execute(); // execute the down command
		e.update(); // update the environment observers (GUI)
		Thread.sleep(1000);
		
		/*
		 * Dis the command move the selection down?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Did the Down Command Work?"));
		Thread.sleep(3000);
		Command up = new UpCommand(); // create a new up command
		up.execute(); // execute the up command
		e.update(); // update the environment observers
		Thread.sleep(1000);
		
		/*
		 * Did the selection move up?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Did the Up Command Work?"));
		Thread.sleep(3000);
		Command right = new RightCommand(); // create a new right command
		right.execute(); // execute the right command
		e.update(); // update environment observers
		Thread.sleep(1000);
		
		/*
		 * Did the selection move right?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Did the Right Command Work?"));
		Thread.sleep(3000);
		Command left = new LeftCommand(); // create a new left command
		left.execute(); //execute the left command
		e.update(); // update environment observers
		Thread.sleep(1000);
		
		/*
		 * Did the selection move left?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Did the Left Command Work?"));
		Thread.sleep(3000);
		Command a = new ACommand(); // create new A command
		a.execute(); // execute A command
		e.update(); // update observers
		Thread.sleep(2500);
		a.execute(); // execute A command again
		
		/*
		 * Did the A command process correctly? Are you viewing attacks?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Did the A Command Work?"));
		Thread.sleep(3000);
		Command b = new BCommand(); // create new B command
		b.execute(); // execute the B command
		e.update(); // update the environment observers
		Thread.sleep(1000);
		
		/*
		 * Did the B command work? Are you viewing the options again?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Did the B Command Work?"));
		
	}

}
