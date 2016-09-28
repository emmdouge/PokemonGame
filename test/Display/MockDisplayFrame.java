package Display;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import environment.EnvObserver;
import exceptions.ItemException;
import DisplayState.DisplaySwitch;
import InvokerGUI.Invoker;
/**
 * This is a mock class used for testing the creation of a frame and changing the panels
 * Needed for testing the display state changes triggered by invoker actions
 * @author Joshua Bartle
 *
 */
public class MockDisplayFrame implements EnvObserver{

	private static MockDisplayFrame disframe; // stores the current instance of the frame
	private DisplaySwitch s; // stores the instance of the display switch for state changes
	private JFrame frame; // variable for the frame
	private JPanel container; // variable for the panel within the frame that holds the invoker and display
	private JPanel dis; // variable for the display
	private JPanel inv; // variable for invoker
	private Display pokemonDis; // store the instance of pokemon selection display
	private Display fightDis;	// store an instance of fight display
	private Display bagDis;
	
	/**
	 * Constructor is private and created by static reference so that the instance of the frame can
	 * be referenced by other classes such as the display switch for the state changes in display
	 */
	private MockDisplayFrame(){
		pokemonDis = new MockPokemonDisplay();
		fightDis = new MockFightDisplay();
		bagDis = new MockBagDisplay();
		Invoker i = new Invoker();
		JPanel a = i.getInvokerPanel();
		frame = new JFrame("Pokemon Game");
		frame.setVisible(true);
		frame.setSize(400,600);
		container = new JPanel(new GridLayout(2,1));
		frame.add(container);
		s = new DisplaySwitch();
		addDisplay(pokemonDis.getScreen());
		addInvoker(a);
	}

	/**
	 * Static method called for creating the instance of frame
	 * @return the display frame to hold the invoker and display panel
	 */
	public static MockDisplayFrame makeFrame(){
		disframe = new MockDisplayFrame();
		return disframe;
	}

	/**
	 * get the instance of display switch created by this class
	 * @return s, the Display Switch
	 */
	public DisplaySwitch getSwitch(){
		return s;
	}
	
	/**
	 * get the instance of MockDisplay frame stored as the instance variable disframe
	 * @return disframe
	 */
	public static MockDisplayFrame getInstance(){
		return disframe;
	}
	
	/**
	 * Method for getting the frame
	 * @return frame
	 */
	public JFrame getFrame(){
		return frame;
	}
	/**
	 * Method used for adding initial display at start of game when the frame is created
	 * @param s, the display
	 */
	public void addDisplay(JPanel s){
		// current display is s
		dis = s;
		container.add(s);
	}
	
	/**
	 * Method called by the State change. Switches out the displays to the 
	 * battle scene
	 * @throws ItemException 
	 */
	public void setFightDisplay() throws ItemException{
		replaceDisplay(fightDis.getScreen());
	}
	
	/**
	 * Method called by the state chage. Switches out the displayes to the bag display
	 * @throws ItemException 
	 */
	public void setBagDisplay() throws ItemException{
		replaceDisplay(bagDis.getScreen());
	}
	
	/**
	 * Method used to redraw the diaplays. This is called in the redraw method located
	 * in Environment.class
	 * @throws ItemException 
	 */
	public void redrawAll() throws ItemException{
		frame.revalidate();
		pokemonDis.draw();
		fightDis.draw();
		bagDis.draw();
	}
	
	/**
	 * Method called by the State change. Switches out the display to 
	 * the pokemon selection screen
	 * @throws ItemException 
	 */
	public void setSelectDisplay() throws ItemException{
		replaceDisplay(pokemonDis.getScreen());
	}
	
	/**
	 * Method used to add the invoker when the frame is first created
	 * @param i, the invoker
	 */
	public void addInvoker(JPanel i){
		this.inv = i;
		container.add(i);
	}
	
	/**
	 * Method for replacing the displays when the setSelect and setFightDisplays are called
	 * @param s, the display panel that will replace the current display
	 */
	public void replaceDisplay(JPanel s){
		frame.revalidate();
		container.remove(this.dis); // remove the current display
		container.remove(this.inv); // remove the invoker
		this.dis = s;				// set the current display to the new diaplay
		container.add(dis);			// add the display
		container.add(inv);			// readd the invoker to the container
		frame.repaint();
	}
	
	public void closeGame(){
		frame.dispose();
	}

	@Override
	public void update(){
		try {
			redrawAll();
		} catch (ItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
