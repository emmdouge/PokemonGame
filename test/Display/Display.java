package Display;

import javax.swing.JPanel;

import exceptions.ItemException;
/**
 * Interface for all Mockdisplays
 * @author Joshua Bartle
 *
 */

public interface Display {
	/**
	 * Gets the game screen
	 * @return JPanel
	 */
	public JPanel getScreen();
	
	/**
	 * Gets the display
	 * @return Display
	 */
	public Display getDisplay();
	
	/**
	 * Redraws the display
	 * @throws ItemException
	 */
	public void draw() throws ItemException;
}
