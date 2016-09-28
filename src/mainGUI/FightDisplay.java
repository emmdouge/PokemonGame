package mainGUI;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

import moves.Move;
import environment.EnvObserver;

@SuppressWarnings("serial")
public class FightDisplay extends JPanel implements Display, EnvObserver
{
	private Move[] moves;
	/**
	 * Create the panel.
	 */
	public FightDisplay(Move[] moves) 
	{
		this.moves = moves;
		
		drawDisplay();
	}

	@Override
	public void drawDisplay() 
	{
		setLayout(new GridLayout(3,2));
		
		JLabel lblMoveOne = new JLabel(moves[0].getName(), JLabel.CENTER);
		add(lblMoveOne);
		
		JLabel lblMoveTwo = new JLabel(moves[1].getName(), JLabel.CENTER);
		add(lblMoveTwo);
		
		JLabel lblMoveThree = new JLabel(moves[2].getName(), JLabel.CENTER);
		add(lblMoveThree);
		
		JLabel lblMoveFour = new JLabel(moves[3].getName(), JLabel.CENTER);
		add(lblMoveFour);
		
		//JLabel lblMoveFive = new JLabel(moves[4].getName(), JLabel.CENTER);
		//add(lblMoveFive);
		
		//JLabel lblMoveSix = new JLabel(moves[5].getName(), JLabel.CENTER);
		//add(lblMoveSix);
	
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
