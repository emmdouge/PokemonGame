package InvokerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import exceptions.ItemException;
import InvokerFunctions.ButtonActions;

/**
 * Class used for creating the invoker GUI
 * @author Joshua Bartle
 *
 */
public class Invoker implements ActionListener{
	JPanel base = new JPanel(new BorderLayout()); // creates a base panel for the invoker
	JPanel buttonGrid = new JPanel(new GridLayout(7,8)); // creates a grid to place the buttons on
	JPanel[][] blankPanel; // creates an array for blank panels
	JButton AButton = new JButton(); // creates the A button
	JButton BButton = new JButton(); // creates the B button
	JButton DU = new JButton(); // creates an up button
	JButton DD =  new JButton(); // creates a down button
	JButton DR = new JButton(); // creates a right button
	JButton DL = new JButton(); // creates a left button
	JButton Start = new JButton(); // creates a start button
	JButton Select = new JButton(); // create a select button
	ButtonActions a = new ButtonActions(this); // pass a reference to this class into the ButtonActions class
	
	/**
	 * Constructor for invoker
	 */
	public Invoker(){
		
		blankPanel = new JPanel[7][8];
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 8; j++){
				blankPanel[i][j] = new JPanel();
				blankPanel[i][j].setBackground(Color.black);
			}
		}
		
	
		buttonGrid.setBackground(Color.BLACK);
		
		/*
		 * Add action listeners to all of the buttons
		 */
		AButton.addActionListener(this);
		BButton.addActionListener(this);
		DD.addActionListener(this);
		DR.addActionListener(this);
		DL.addActionListener(this);
		DU.addActionListener(this);
		Start.addActionListener(this);
		Select.addActionListener(this);
		
		/*
		 * Remove the borders from the buttons
		 */
		AButton.setBorderPainted(false);
		BButton.setBorderPainted(false);
		Select.setBorderPainted(false);
		Start.setBorderPainted(false);
		addButtons(); // method call to add the buttons to the invoker
	}
	
	/**
	 * Method used for creating images for different buttons
	 * @param button
	 * @return the button image
	 */
	public ImageIcon createImage(JButton button){
		Graphics g;
		BufferedImage image = new BufferedImage(30,30, BufferedImage.TYPE_3BYTE_BGR);
		g = image.getGraphics();
		
		if(button == AButton){
			char a[] = {'A'};
			g.setColor(Color.RED);
			g.fillOval(0, 0, 30, 30);
			g.setColor(Color.BLACK);
			g.drawChars(a, 0, 1, 12, 20);
		}
		
		if(button == BButton){
			char b[] = {'B'};
			g.setColor(Color.RED);
			g.fillOval(0, 0, 30, 30);
			g.setColor(Color.BLACK);
			g.drawChars(b, 0, 1, 12, 20);
			
		}
		if(button == Select){
			g.setColor(Color.RED);
			g.fillOval(1, 10, 30, 10);
		}
		if(button == Start){
			g.setColor(Color.RED);
			g.fillOval(1, 10, 30, 10);
		}
		if(button == DL){
			g.setColor(Color.gray);
			g.fillRect(0, 0, 30, 30);
			g.setColor(Color.DARK_GRAY);
			g.fillPolygon(new int[]{1,29,29}, new int[]{15,29, 1}, 3);
		}
		if(button == DU){
			g.setColor(Color.gray);
			g.fillRect(0, 0, 30, 30);
			g.setColor(Color.DARK_GRAY);
			g.fillPolygon(new int[]{15, 1, 29}, new int[]{1, 29, 29} , 3);
		}
		if(button == DD){
			g.setColor(Color.gray);
			g.fillRect(0, 0, 30, 30);
			g.setColor(Color.DARK_GRAY);
			g.fillPolygon(new int[]{15, 29, 1}, new int[]{29, 1, 1}, 3);
		}
		if(button == DR){
			g.setColor(Color.gray);
			g.fillRect(0, 0, 30, 30);
			g.setColor(Color.DARK_GRAY);
			g.fillPolygon(new int[]{29,1,1}, new int[]{15,29,1}, 3);
		}
		return new ImageIcon(image);
	}
	
	/**
	 * Method for getting instance of buttons actions class
	 * @return
	 */
	public ButtonActions getButtonActions(){
		return a;
	}
	
	/**
	 * Method for adding buttons to the invoker
	 */
	private void addButtons(){
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 8; j++){
				if( i == 2 && j == 7){
					buttonGrid.add(AButton);
					AButton.setBackground(Color.BLACK);
					AButton.setIcon(createImage(AButton));}
				else
				if( i == 1 && j == 1){
					DU.setIcon(createImage(DU));
					DU.setBackground(Color.GRAY);
					buttonGrid.add(DU);}
				else
				if( i == 2 && j == 0){
					buttonGrid.add(DL);
					DL.setIcon(createImage(DL));
					DL.setBackground(Color.GRAY);}
				else
				if( i == 2 && j == 2){
					DR.setBackground(Color.GRAY);
					DR.setIcon(createImage(DR));
					buttonGrid.add(DR);}
				else
				if( i == 3 && j == 6){
					buttonGrid.add(BButton);
					BButton.setBackground(Color.BLACK);
					BButton.setIcon(createImage(BButton));}
				else
				if( i == 3 && j == 1){
					DD.setBackground(Color.GRAY);
					DD.setIcon(createImage(DD));
					buttonGrid.add(DD);}
				else
				if( i == 6 && j == 3){
					Start.setIcon(createImage(Start));
					Start.setBackground(Color.BLACK);
					buttonGrid.add(Start);}
				else
				if( i == 6 && j == 4){
					Select.setIcon(createImage(Select));
					Select.setBackground(Color.black);
					buttonGrid.add(Select);}
				else
					buttonGrid.add(blankPanel[i][j]);
			}
		}
	}
	
	/**
	 * Method for getting the AButton
	 * @return AButton
	 */
	public JButton getAButton(){
		return AButton;
	}
	
	/**
	 * Method for getting the BButton
	 * @return BButton
	 */
	public JButton getBButton(){
		return BButton;
	}
	
	/**
	 * Method for getting the up button
	 * @return DU
	 */
	public JButton getUpButton(){
		return DU;
	}
	
	/**
	 * Method for getting the down button
	 * @return DD
	 */
	public JButton getDownButton(){
		return DD;
	}
	
	/**
	 * Method for getting the right button
	 * @return DR
	 */
	public JButton getRightButton(){
		return DR;
	}
	
	/**
	 * Method for getting the left button
	 * @return DL
	 */
	public JButton getLeftButton(){
		return DL;
	}
	
	/**
	 * Method for getting the start button
	 * @return Start
	 */
	public JButton getStartButton(){
		return Start;
	}
	
	/**
	 * Method for getting the select button
	 * @return Select
	 */
	public JButton getSelectButton(){
		return Select;
	}
	
	/**
	 * Method for getting the invoker
	 * @return buttonGrid
	 */
	public JPanel getInvokerPanel(){
		return buttonGrid;
	}

	/**
	 * Method for sending action event to the ButtonFunctions class
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			try {
				a.ActionFunction(e);
			} catch (ItemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
}


