package mainGUI;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.EnvObserver;

@SuppressWarnings("serial")
public class MainDisplay extends JPanel implements Display, EnvObserver
{	
	private ImageIcon target;
	private ImageIcon player;
	private String targetStats;
	private String playerStats;
		
	/**
	 * Create the panel.
	 */
	public MainDisplay(ImageIcon target, ImageIcon player, String targetStats, String playerStats) 
	{
		this.target = target;
		this.player = player;
		
		this.targetStats = targetStats;
		this.playerStats = playerStats;
		
		drawDisplay();
	}

	@Override
	public void drawDisplay() 
	{
		setLayout(new GridLayout(2,2));
		
		JLabel lblTargetStats = new JLabel(targetStats, JLabel.CENTER);
		add(lblTargetStats);
		
		JLabel lblTarget = new JLabel(target, JLabel.CENTER);
		add(lblTarget);
		
		JLabel lblPlayer = new JLabel(player, JLabel.CENTER);
		add(lblPlayer);
		
		JLabel lblPlayerStats = new JLabel(playerStats, JLabel.CENTER);
		add(lblPlayerStats);
		
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
