package mainGUI;

import items.Bag;
import items.Item;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.EnvObserver;
import exceptions.ItemException;

@SuppressWarnings("serial")
public class ItemDisplay extends JPanel implements Display, EnvObserver
{
	private Bag bag;
	private Item[] items;
	
	/**
	 * Create the panel.
	 * @throws ItemException 
	 */
	public ItemDisplay(Bag bag) throws ItemException 
	{
		this.bag = bag;
		for (int i = 0; i < 6; i++)
		{
			items[i] = bag.getItem(i);
		}
		
		drawDisplay();
	}

	@Override
	public void drawDisplay() 
	{
		setLayout(new GridLayout(3,2));
		
		JLabel lblItemOne = new JLabel(items[0].getName(), JLabel.CENTER);
		add(lblItemOne);
		
		JLabel lblItemTwo = new JLabel(items[1].getName(), JLabel.CENTER);
		add(lblItemTwo);
		
		JLabel lblItemThree = new JLabel(items[2].getName(), JLabel.CENTER);
		add(lblItemThree);
		
		JLabel lblItemFour = new JLabel(items[3].getName(), JLabel.CENTER);
		add(lblItemFour);
		
		JLabel lblItemFive = new JLabel(items[4].getName(), JLabel.CENTER);
		add(lblItemFive);
		
		JLabel lblItemSix = new JLabel(items[5].getName(), JLabel.CENTER);
		add(lblItemSix);
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
