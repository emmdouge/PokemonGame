package InvokerGUI;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.junit.Test;

import ai.AIContext;
import environment.Environment;
import exceptions.ItemException;
import pokemon.*;
import Display.MockDisplayFrame;
import DisplayState.DisplaySwitch;

/**
 * Class for testing the invoker GUI using the buttons and navigating
 * around the screen
 * @author Joshua Bartle
 */
public class TestInvokerGUI {

	/**
	 * Test method for the invoker panel only. Does the invoker show?
	 * @throws InterruptedException
	 */
	@Test
	public void testInvokerGUI() throws InterruptedException{
		reset();
		Invoker i = new Invoker(); // create an invoker
		JPanel testscreen = new JPanel();  // create a blank scree
		testscreen.setBackground(Color.BLUE);
		JPanel test = new JPanel(new GridLayout(2,1));
		JFrame frame = new JFrame("INVOKER TEST FRAME"); // create a test frame
		test.add(testscreen); // add the test screen
		frame.add(test); // add the test panel to invoker
		test.add(i.getInvokerPanel()); // add the invoker panel
		frame.setSize(400, 600);
		frame.setAutoRequestFocus(true);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); // will exit on close
		/*
		 * Does the invoker show up?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Is the invoker Visible?"));
	}
	
	/**
	 * Method for testing that the invoker is interactive
	 * Can the user use the invoker to navigate through the displays?
	 * @throws ItemException
	 * @throws InterruptedException
	 */
	@Test
	public void testButtons() throws ItemException, InterruptedException{
		reset(); // clear the environment
		
		/*
		 * Start of testing 
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Lets test the Buttons, Yes to continue"));
		Environment e = Environment.createMockEnv(); // create a mock environment
		AIContext ai = new AIContext(e);
		e.setAI(ai);
		Pokemon[] t = e.getTeam("target");
		e.setCurrentTarget(t[0]);
		/*
		 * create pokemon for the environment
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
		e.update();
		
		MockDisplayFrame frame = MockDisplayFrame.getInstance();
		DisplaySwitch s = frame.getSwitch();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Are the pokemon Visible? Take Your time to select one."));
	
		do{
		Thread.sleep(10);
		}while(s.getCurrent() == s.getSelectState());
		assertTrue(s.getCurrent() == s.getFightState());
		
		/*
		 * did the invoker button cause the display to change?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Your are now in the fight State, Open the bag"));
		
		do{
		Thread.sleep(10);
		}while(s.getCurrent() == s.getFightState());
		
		/*
		 * did the state also change?
		 */
		assertTrue(s.getCurrent() == s.getBagState());
		
		/*
		 * Did the Bag option open the bag? Can we Go Back?
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "You are now in bag State, Press B to go back"));
		
		do{
			Thread.sleep(10);
		}while(s.getCurrent() == s.getBagState());
		
		
		/*
		 * Did the state change when we went back?
		 */
		assertTrue(s.getCurrent() == s.getFightState());
		
		/*
		 * This tests that the attacks are displayed when we select attack
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "You are back to the fight. Try attacking"));
		
		do{
			Thread.sleep(10);
		}while(e.areAttacking() == false);
		 
		/*
		 * are we attacking?
		 */
		assertTrue(e.areAttacking());
		
		do{
			Thread.sleep(10);
		}while(e.areAttacking() == true);
		
		/*
		 * Are we no longer attacking now that we selected an attack?
		 */
		assertFalse(e.areAttacking());
		
		/*
		 * Prompt to keep attacking
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Attack Until You are defeated"));
		
		do{
			Thread.sleep(10);
		}while(s.getCurrent() == s.getFightState());
		
		/*
		 * Did we return to select when the pokemon fainted
		 */
		assertTrue(s.getCurrent() == s.getSelectState());
		
		/*
		 * Did the display change
		 */
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "The pokemon died. did you return to select?"));
	}
	
	/**
	 * Method for resetting the environment
	 */
	public void reset(){
		Environment.clearEnv();
	}
}
