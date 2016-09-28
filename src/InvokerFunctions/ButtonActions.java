package InvokerFunctions;

import java.awt.event.ActionEvent;
import environment.Environment;
import exceptions.ItemException;
import Commands.ACommand;
import Commands.BCommand;
import Commands.Command;
import Commands.DownCommand;
import Commands.LeftCommand;
import Commands.RightCommand;
import Commands.UpCommand;
import InvokerGUI.*;

/**
 * Class used for creating command and calling the execute 
 * methods for those command when called by the invoker
 * @author Joshua Bartle
 *
 */
public class ButtonActions{
	
	Invoker i; // instance of invoker is stored for the button actions
	Command command[]; // array of several different commands are stored
	Environment env; // instance variable for environment
	public ButtonActions(Invoker i){
		this.i = i;
		command = new Command[10];
		command[0] = new UpCommand(); // create up command
		command[1] = new DownCommand(); // create down command
		command[2] = new RightCommand(); // create right command
		command[3] = new LeftCommand(); // create left command
		command[4] = new ACommand(); // create a command
		command[5] = new BCommand(); // create b command
	}

	/**
	 * Method for when the action even is called in the invoker gui
	 * @param e
	 * @throws ItemException
	 */
	public void ActionFunction(ActionEvent e) throws ItemException{
		// if the a button is clicked
		if(e.getSource() == i.getAButton()){
			System.out.println("A worked");
			command[4].execute();
		}
		// if the b button is clicked
		if(e.getSource() == i.getBButton()){
			System.out.println("B worked");
			command[5].execute();
		}
		// if the down button is clicked
		if(e.getSource() == i.getDownButton()){
			System.out.println("Down worked");
			command[1].execute();
		}
		// if the up button is clicked
		if(e.getSource() == i.getUpButton()){
			System.out.println("UP worked");
			command[0].execute();
		}
		// if the right button is clicked
		if(e.getSource() == i.getRightButton()){
			System.out.println("Right worked");
			command[2].execute();
		}
		// if the left button is clicked
		if(e.getSource() == i.getLeftButton()){
			System.out.println("Left worked");
			command[3].execute();
		}
		// if the start button is clicked
		if(e.getSource() == i.getStartButton()){
			System.out.println("Start worked");
		}
		// if the select button is clicked
		if(e.getSource() == i.getSelectButton()){
			System.out.println("Select worked");
		}
	}
}
	
	

