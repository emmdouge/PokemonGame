package mainGUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.EnvObserver;

@SuppressWarnings("serial")
public class SwitchDisplay extends JPanel implements Display, EnvObserver
{
	private ImageIcon[] choices;
	private ImageIcon currentPlayer;	
	
	/**
	 * Create the panel.
	 */
	public SwitchDisplay(ImageIcon[] choices, ImageIcon currentPlayer)
	{
		this.choices = choices;
		this.currentPlayer = currentPlayer;
		
		drawDisplay();
	}

	@Override
	public void drawDisplay() 
	{
		setLayout(new GridLayout(3,2));
		
		//create and add labels		
		JLabel lblChoiceOne = new JLabel(choices[0], JLabel.CENTER);
		add(lblChoiceOne);
		
		JLabel lblChoiceTwo = new JLabel(choices[1], JLabel.CENTER);
		add(lblChoiceTwo);
		
		JLabel lblChoiceThree = new JLabel(choices[2], JLabel.CENTER);
		add(lblChoiceThree);
		
		JLabel lblChoiceFour = new JLabel(choices[3], JLabel.CENTER);
		add(lblChoiceFour);
		
		JLabel lblChoiceFive = new JLabel(choices[4], JLabel.CENTER);
		add(lblChoiceFive);
		
		JLabel lblChoiceSix = new JLabel(choices[5], JLabel.CENTER);
		add(lblChoiceSix);
		
		//set current player visible to user
		int cP = 0;//current player location in array
		for (int i = 0; i < 6; i++)
		{
			if (currentPlayer == choices[i])
				cP = i;
		}
		
		switch (cP)
		{
			case 0:
				lblChoiceOne.setBackground(Color.GREEN);
				break;
			case 1:
				lblChoiceTwo.setBackground(Color.GREEN);
				break;
			case 2:
				lblChoiceThree.setBackground(Color.GREEN);
				break;
			case 3:
				lblChoiceFour.setBackground(Color.GREEN);
				break;
			case 4:
				lblChoiceFive.setBackground(Color.GREEN);
				break;
			case 5:
				lblChoiceSix.setBackground(Color.GREEN);
				break;
			default:
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeSelection(Point point) {
		// TODO Auto-generated method stub
		
	}

}
