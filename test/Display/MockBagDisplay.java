package Display;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.Environment;
import exceptions.ItemException;

/**
 * Class for mockdisplay used for testing invoker
 * @author Joshua Bartle
 *
 */
public class MockBagDisplay implements Display{
	Environment e;
	
	JPanel screen  = new JPanel(new GridLayout(6, 1));
	JPanel selected = new JPanel();
	JLabel[] pok = new JLabel[6];
	int sx = 0;
	int sy = 2;

	public MockBagDisplay(){
			for(int x = 0; x < 6; x++){
				pok[x] = new JLabel("EMPTY", JLabel.CENTER);
			}
		screen = getScreen();
	}
	
	public JPanel getScreen(){

			for(int x = 0; x < 6; x++){
				pok[x].setOpaque(true);
				screen.add(pok[x]);
			}
		return screen;
	}
	

	public MockBagDisplay getDisplay(){
		return this;
	}
	
	public void draw() throws ItemException{
		e = e.getMockEnv();
		screen.revalidate();
			for(int x = 0; x < 6; x++){
				if(e.getItem(x) == e.getSelectedItem()){
					pok[x].setBackground(Color.RED);
			}else
				if(e.getItem(x) == null || e.getItem(x).isEmpty() == true){
					pok[x].setText("EMTY");
					pok[x].setBackground(Color.GRAY);}
				else{
					pok[x].setBackground(Color.GRAY);
					pok[x].setText(e.getItem(x).getName());}
		}
		screen.repaint();
		//System.out.println(e.getSelectedItem());
		//System.out.println(e.getPokemon(1,0));
	}
}
