package mainGUI;

import items.Bag;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;

import pokemon.Pokemon;
import moves.Move;
import environment.EnvObserver;
import environment.Environment;
import exceptions.ItemException;

/**
 * 
 * @author Cassia Hulshizer
 *
 */
public class GameFrame implements EnvObserver
{
	private static GameFrame gameFrame = new GameFrame(); //instance of the game
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel invokerPanel;
	private JPanel currentDisplay; //current display of the game
	private ImageIcon[] icons = { new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/blastoise.ico")), 
			  					  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/bulbasaur.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/caterpie.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/charizard.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/charmander.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/charmeleon.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/ivysaur.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/poliwag.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/squirtle.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/venusaur.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/vulpix.ico")),
								  new ImageIcon(GameFrame.class.getResource("/mainGUI/icons/wartortle.ico")) }; 
	
	private ImageIcon[] targetTeam = new ImageIcon[6]; //list of icons for the target's team
	private ImageIcon[] playerTeam = new ImageIcon[6]; //list of icons for the player's team
	private ImageIcon target; //icon for currentTarget
	private ImageIcon player; //icon for currentPlayer
	private Move[] moves; //all moves for currentPlayer
	private Bag bag; //the bag used for the player
	private String targetStats = "Target Stats\n------------"; //all statistics for target
	private String playerStats = "Player Stats\n------------"; //all statistics for player
	private Pokemon currentPlayer; //current player's pokemon
	private Pokemon currentTarget; //current target's pokemon
	private Environment env = Environment.create(); //current instance of the environment 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GameFrame window = new GameFrame();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private GameFrame() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 392, 474);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getInfo();
		currentDisplay = new MainDisplay(target, player, targetStats, playerStats); //default display
		setCurrentDisplay();
	}

	/**
	 * 
	 * @return gameFrame the instance of the game
	 */
	public static GameFrame getFrame()
	{
		return gameFrame;
	}
	
	private void getInfo() 
	{		
		Pokemon[] playerTeam = env.getTeam("player");
		Pokemon[] targetTeam = env.getTeam("target");
		
		for (int j = 0; j < 6; j++)
		{
			this.targetTeam[j] = setIcon(targetTeam[j]);
			this.playerTeam[j] = setIcon(playerTeam[j]);
		}
		
		currentPlayer = env.getCurrentPlayer();
		player = setIcon(currentPlayer);
		playerStats = setStats(currentPlayer);
		
		currentTarget = env.getCurrentTarget();
		target = setIcon(currentTarget);
		targetStats = setStats(currentTarget);
		
		moves = currentPlayer.getAttacks();
		bag = env.getBag();
	}
	
	/**
	 * Set icon based on Pokemon
	 */
	private ImageIcon setIcon(Pokemon p)
	{
		ImageIcon i;
		switch (p.getName())
		{
			case "Blastoise":
				i = icons[0];
				break;
			case "Bulbasaur":
				i = icons[1];
				break;
			case "Caterpie":
				i = icons[2];
				break;
			case "Charizard":
				i = icons[3];
				break;
			case "Charmander":
				i = icons[4];
				break;
			case "Charmeleon":
				i = icons[5];
				break;
			case "Ivysaur":
				i = icons[6];
				break;
			case "Poliwag":
				i = icons[7];
				break;
			case "Squirtle":
				i = icons[8];
				break;
			case "Venusaur":
				i = icons[9];
				break;
			case "Vulprix":
				i = icons[10];
				break;
			case "Wartortle":
				i = icons[11];
				break;
			default:
				i = null;
				break;
		}
		return i;
	}
	
	private String setStats(Pokemon p)
	{
		String stats = "\nStatus: ";
		
		stats += p.getCurrentStatus().toString() + "\nCurrent Hit Points: " + p.getCurrentHitpoints() +
				 "\nMax Hit Points: " + p.getMaxHitpoints() + "\nAttack Power: " + p.getAttackPower() +
				 "\nSpecial Attack Power: " + p.getSpecialAttackPower() + "\nDefense: " + p.getDefense() +
				 "\nSpecial Defense: " + p.getSpecialDefense();
				
		return stats;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void setCurrentDisplay() 
	{
		mainPanel = currentDisplay;
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		invokerPanel = env.getInvoker().getInvokerPanel();
		frame.getContentPane().add(invokerPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void update() 
	{//TODO
		getInfo();
		setCurrentDisplay();
	}
	
	public void setDisplay(String displayType) throws ItemException
	{
		System.out.println("TEST SET DIS");
		frame.remove(mainPanel);
		frame.remove(invokerPanel);
		
		if (displayType == "main")
			currentDisplay = new MainDisplay(target, player, targetStats, playerStats);
		else if (displayType == "switch")
			currentDisplay = new SwitchDisplay(playerTeam, player);
		else if (displayType == "fight")
			currentDisplay = new FightDisplay(moves);
		else if (displayType == "item")
			currentDisplay = new ItemDisplay(bag);
	
		setCurrentDisplay();

	}

}
