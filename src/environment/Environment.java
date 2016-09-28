package environment;

import items.Bag;
import items.Item;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.ItemException;
import ai.AIContext;
import Display.MockDisplayFrame;
import DisplayState.BagState;
import DisplayState.DisplaySwitch;
import DisplayState.FightState;
import DisplayState.MainState;
import DisplayState.PokemonSelect;
import InvokerGUI.Invoker;
import pokemon.Blastoise;
import pokemon.Bulbasaur;
import pokemon.Caterpie;
import pokemon.Charizard;
import pokemon.Charmeleon;
import pokemon.Ivysaur;
import pokemon.PokeFactory;
import pokemon.Pokemon;
import pokemon.Squirtle;
import team.PokeTeam;
import team.TargetTeam;
import team.Team;

/**
 * 
 * @author Cassia Hulshizer
 *
 */
public class Environment 
{
	/**
	 * Instance Variables
	 */
	private static Environment mockEnv = null;
	private static Environment env = null; //static environment variable
	private ArrayList<EnvObserver> observers; //array list of EnvObservers for updating
	
	private Iterator<Pokemon> pokemonIterator;
	private Iterator<Pokemon> targetIterator;
	private Team pokemon;
	private Team target;
	
	private Bag bag; //bag of items for player
	private Bag targetBag; //bag of items for target
	
	private Pokemon[] playerTeam = new Pokemon[6]; //team of player's pokemon
	private Pokemon[] targetTeam = new Pokemon[6]; //team of target's pokemon
	private Pokemon currentPlayer; //current player's pokemon
	private Pokemon currentTarget; //current target's pokemon
	
	private AIContext ai;
	
	private Invoker invoker; //invoker panel - used for button clicks and selections
	private DisplaySwitch s = null; //instance of displaySwitch for display states -JB
	private Pokemon[][] p = new Pokemon[3][2]; //pokemon from playerTeam - used for invoker selections - JB
	private Item selectedItem; //currently selected item - JB
	private int[][] fightOptions = new int[2][2]; //create an array of options within the fight display - JB
	  							  //1. attack
	  							  //2. bag
	  							  //3. switch pokemon
	  							  //4. run
	private int selectedOption = -1; //currently selected option - JB
	private boolean attacksDisplayed = false;  //keeps track of whether the attacks
											   //or the options on the fight display
	  										   //currently visible - JB
	private int[][] attack = new int[2][2]; //the attacks of the currentPokemon - JB
	private int attackNumber = -1; //currently selected attack - JB
	private MockDisplayFrame frame;

	/**
	 * creates the environment
	 * @throws  
	 */
	private Environment(String s)
	{
		PokeFactory p = new PokeFactory();
		if(s == null)
		{
			observers = new ArrayList<EnvObserver>();
			pokemon = new PokeTeam();
			target = new TargetTeam();
					
			createTeams();
			
			int o = 0;
			for (int m = 0; m < 3; m++)
			{
				for (int n = 0; n < 2; n++)
				{
					addPokemon(playerTeam[o], m, n);
					o++;
				}
			}
			
			currentPlayer = playerTeam[0];
			currentTarget = targetTeam[0];
			bag = new Bag();
			bag.fillBag();
			targetBag = new Bag();
			targetBag.fillBag();
			invoker = new Invoker();
			this.s = new DisplaySwitch();
		}
		
		// DO NOT REMOVE - JB
		else if(s == "mock")
		{
			observers = new ArrayList<EnvObserver>();
			frame = MockDisplayFrame.makeFrame();
			bag = new Bag();
			bag.fillBag();
			targetBag = new Bag();
			targetBag.fillBag();
			targetTeam[0] = p.generatePokemon(p.Charmeleon);
			targetTeam[1] = p.generatePokemon(p.Caterpie);
			targetTeam[2] = p.generatePokemon(p.Ivysaur);
			targetTeam[3] = p.generatePokemon(p.Charizard);
			targetTeam[4] = p.generatePokemon(p.Bulbasaur);
			targetTeam[5] = p.generatePokemon(p.Blastoise);
			this.s = frame.getSwitch();
			addObserver(frame);
			
		}
		
	}
	
	/**
	 * builds the team arrays of the environment from the teamIterator
	 */
	private void createTeams()
	{
	
		pokemonIterator = pokemon.createIterator();
		int i = 0;
		while (pokemonIterator.hasNext())
		{
			playerTeam[i] = pokemonIterator.next();
			i++;
		}
		
		targetIterator = target.createIterator();
		int j = 0;
		while (targetIterator.hasNext())
		{
			targetTeam[j] = targetIterator.next();
			j++;
		}
	}
	
	/**
	 * creates an instance of environment and returns it
	 * @return env the current instance of environment of the game
	 */
	public static Environment create()
	{
		if (env == null)
			env = new Environment(null);
		return env;
	}

	public static Environment createMockEnv()
	{
		mockEnv = new Environment("mock");
		return mockEnv;
	}
	
	public static Environment getMockEnv()
	{
		return mockEnv;
	}
	
	/**
	 * creates a new environment if currently null, and returns the environment
	 * @return env the current environment of the game
	 */
	public static Environment getEnv()
	{
		//if (env == null)
		//	create();
		return env;
	}
	
	/**
	 * returns one of the teams based on a description of which team is needed
	 * @param description name of the team
	 * @return playerTeam or targetTeam the team of pokemon which was requested
	 */
	public Pokemon[] getTeam(String description)
	{
		if (description == "player")
			return playerTeam;		
		else if (description == "target")
			return targetTeam;
		else
			return null;
	}
	
	/**
	 * sets the currentPlayer
	 * @param cP
	 */
	public void setCurrentPlayer(Pokemon cP)
	{
		currentPlayer = cP;
	}
	
	/**
	 * 
	 * @return currentPlayer the player's current pokemon
	 */
	public Pokemon getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	/**
	 * sets the currentTarget
	 * @param cT
	 */
	public void setCurrentTarget(Pokemon cT)
	{
		currentTarget = cT;
	}
		
	/**
	 * 
	 * @return currentTarget the opponent's current pokemon
	 */
	public Pokemon getCurrentTarget()
	{
		return currentTarget;
	}
	
	/**
	 * 
	 * @return invoker the current invoker panel
	 */
	public Invoker getInvoker()
	{
		return invoker;
	}
	
	/**
	 * 
	 * @return bag the bag of items currently held
	 */
	public Bag getBag()
	{
		return bag;
	}
	
	/**
	 * 
	 * @return bag the bag of items currently held for the enemy
	 */
	public Bag getTargetBag()
	{
		return targetBag;
	}
	
	/**
	 * 
	 * @return aiContext
	 */
	public AIContext getAI()
	{
		ai = new AIContext(env);
		return ai;
	}
	
	/**
	 * @param ai ai to be set
	 */
	public void setAI(AIContext ai)
	{
		this.ai = ai;
	}
	
	/**
	 * updates all observers in array of any change when called
	 */
	public void update()
	{
		int alive = 0;
		int enemyalive = 0;
		for(int i = 0; i < 6; i++){
			if(targetTeam[i].getCurrentHitpoints() != 0)
				enemyalive++;
		}
		if(targetTeam[0] != null)
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 3; j++){
				if(getPokemon(j, i).getCurrentHitpoints() != 0){
					alive++;
				}
			}
		}
		if(alive == 0 || enemyalive == 0)
			s.getFrame().getFrame().dispose();
		for (EnvObserver e: observers)
		{
			e.update();
		}
	}
	
	/**
	 * adds an observer to the observer array
	 * @param e
	 */
	public void addObserver(EnvObserver e)
	{
		observers.add(e);
	}
	
	/**
	 * removes an observer from the observer array
	 * @param e
	 */
	public void removeObserver(EnvObserver e)
	{
		observers.remove(e);
	}
	
	/**
	 * Method used for setting the currently selected options. 
	 * This method is called by the commands when the D - Pad is clicked left, right, up, or down
	 * @param dv
	 * @param dh
	 * @throws ItemException 
	 */
	public void setSelected(int dv, int dh) throws ItemException
	{
		if(s.getCurrent() instanceof BagState)
		{
			if(selectedItem == null)
				selectedItem = bag.getItem(0);
			
			for(int i = 0; i < bag.getMaxItemsBagHolds(); i++)
			{
				if(selectedItem == bag.getItem(i))
				{
					if((i + dv < bag.getMaxItemsBagHolds() && i + dv >=0))
					{
						//System.out.println(bag.getItem(i + dv));
						selectedItem = bag.getItem(i + dv);
					}
					return;
				}
			}
		}//end if currentState is Bag
		
		// This method will use this condition if the current state is in pokemon selections state
		if(s.getCurrent() instanceof PokemonSelect)
		{
			if(currentPlayer == null)
				currentPlayer = p[0][0];
		
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					if(currentPlayer == p[i][j])
					{
						if((i + dv >=0 && i + dv < 3) && (j + dh < 2 && j + dh >= 0) && getPokemon(i + dv, j + dh) != null)
						{
								currentPlayer = p[i + dv][j + dh];
								return;
						}
					}
				}
			}
		}//end if currentState is Switch
		
		// The method will use this condition if the current state is in fight state
		if(s.getCurrent() instanceof FightState || s.getCurrent() instanceof MainState)
		{
			// sets the values of the attacks, used for keeping track of which options are selected 
			// on the display
			if(attackNumber == -1)
			{
				attack[0][0] = 0;
				attack[0][1] = 1;
				attack[1][0] = 2;
				attack[1][1] = 3;
				attackNumber = attack[0][0];
				//System.out.println("attacks set");
			}
			// sets the values of selected options, used for keeping track of which option is currently
			// selected on the diplay. (fight, run, switch, bag)
			if(selectedOption == -1)
			{
				fightOptions[0][0] = 0;
				fightOptions[0][1] = 1;
				fightOptions[1][0] = 2;
				fightOptions[1][1] = 3;
				selectedOption = fightOptions[0][0];
				//System.out.println("set default option");
			}
			//if the attack option was not selected use this conditions to navigate around the options (fight, switch, 
			//run, bag)
			if(attacksDisplayed == false || s.getCurrent() instanceof MainState)
			{
				for(int i = 0; i < 2; i++)
				{
					for(int j = 0; j < 2; j++)
					{
						if(selectedOption == fightOptions[i][j])
						{
							if((i + dv >=0 && i + dv < 2) && (j + dh < 2 && j + dh >= 0))
							{
								selectedOption = fightOptions[i + dv][j + dh];
								//System.out.println(selectedOption);
								return;
							}
						}
					}
				}
			}
			//else if we have chosen to attack and are selecting an attack use this condition to navigate through
			//the pokemons attacks
			else
			{
				for(int i = 0; i < 2; i++)
				{
					for(int j = 0; j < 2; j++)
					{
						if(attackNumber == attack[i][j])
						{
							if((i + dv >=0 && i + dv < 2) && (j + dh < 2 && j + dh >= 0))
							{
								attackNumber = attack[i + dv][j + dh];
								//System.out.println("Attack number - " + attackNumber);
								return;
							}
						}
					}
				}
			}
		}//end if currentState is Fight
	}//end setSelected
	
	/**
	 * Method for returning which options we are currently sitting on (the highlighted or selected option)
	 * @return the currently selected option
	 * @author Joshua Bartle
	 */
	public int getfightOption()
	{
		return selectedOption;
	}
	
	/**
	 * Method for returning which attack is currently selected
	 * @return the attack we are sitting on or highlighted option
	 * @author Joshua Bartle
	 */
	public int getAttackIndex()
	{
		return attackNumber;
	}
	
	/**
	 * 
	 * @param p
	 * @param r
	 * @param c
	 * @author Joshua Bartle
	 */
	public void addPokemon(Pokemon p, int r, int c)
	{
		this.p[r][c] = p;
	}
	
	/**
	 * This method returns a pokemon in a specific location
	 * @param r , the row
	 * @param c , the column
	 * @return the pokemon
	 * @author Joshua Bartle
	 */
	public Pokemon getPokemon(int r, int c)
	{
		return p[r][c];
	}
	
	/**
	 * Method for processing when the A button is clicked
	 * @author Joshua Bartle
	 * @throws ItemException 
	 */
	public void processAClicked() throws ItemException
	{
		
		if(s.getCurrent() instanceof BagState)
		{
			selectedItem.use(getCurrentPlayer());
			ai.execute();
			System.out.println(getCurrentPlayer().getName() + ": " + getCurrentPlayer().getCurrentHitpoints());
			System.out.println(getCurrentTarget().getName() + ": " + getCurrentTarget().getCurrentHitpoints());
			for(int i = 0; i < bag.getMaxItemsBagHolds(); i ++)
			{
				if(selectedItem == bag.getItem(i))
				{
					bag.removeItem(i);
					
					if(i + 1 < bag.getMaxItemsBagHolds())
						selectedItem = bag.getItem(i + 1);
					
					//System.out.println(getCurrentPlayer().getCurrentHitpoints());
					s.startFight();
					return;
				}
			}
		}//end if currentState is Bag
		//System.out.println(s.getCurrent());
		
		// condition based on which display is currently set
		// of if we were in the pokemon select state we will then switch to the fight state
		if(s.getCurrent() instanceof PokemonSelect)
		{
			if(currentPlayer.getCurrentHitpoints() <= 0)
				return;
			if(env != null){
			s.setMain();
			return;
			}
			s.startFight();
			return;
		}//end if currentState is Switch
		
		// conditinos based on which diaply is currently set
		if(s.getCurrent() instanceof FightState || s.getCurrent() instanceof MainState)
		{
			// if the attacks are currently displayed when the a button is clicked then make an attack with
			// the selected pokemon on the AI and revert back to the options panel
			if(attacksDisplayed == true)
			{
				currentPlayer.makeAttack(getCurrentTarget(), attackNumber);
				ai.execute();
				System.out.println(getCurrentPlayer().getName() + ": " + getCurrentPlayer().getCurrentHitpoints());
				System.out.println(getCurrentTarget().getName() + ": " + getCurrentTarget().getCurrentHitpoints());
				//System.out.println("Health is - " + currentPlayer.getCurrentHitpoints());
				attacksDisplayed = false;
				if(currentPlayer.getCurrentHitpoints() <= 0)
				{
					s.selectPokemon();
					return;
				}
				if(env != null)
					s.setMain();
				return;
			}
			
			// if we are on the switch pokemon option
			if(selectedOption == 2)
			{	
				
				s.selectPokemon();
				return;
			}
			// if we are on the attack option
			if(selectedOption == 0)
			{
				if(env != null){
					s.startFight();
				}
				attacksDisplayed = true;
				return;
			}
			// opens the bag if the bad option in the fight is selected
			if(selectedOption == 1)
			{
				s.openbag();
				return;
			}
			//if(selectedOption == 3)
		}//end if currentState is Fight
		
		if(s.getCurrent() instanceof BagState)
		{
			//System.out.println("BAG OPEN");
			return;
		}
	}//end processAClicked
	
	/**
	 * Method for processing when the B button is clicked
	 * @author Joshua Bartle
	 * @throws ItemException 
	 */
	public void processBClicked() throws ItemException
	{
		if(s.getCurrent() instanceof BagState)
		{
			s.startFight();
			return;
		}
		

		if(s.getCurrent() instanceof FightState)
		{
			if(attacksDisplayed == true && env != null)
			{
				if(s.getCurrent() instanceof FightState)
				{
					if(areAttacking() == true)
						attacksDisplayed = false;
		
					return;
				}
			}
		
			if(attacksDisplayed == true){
				attacksDisplayed = false;
						return;
			}else{
				s.startFight();
			}
		}
	}//end processBClicked

	/**
	 * 
	 * @return
	 * @author Joshua Bartle
	 */
	public boolean areAttacking()
	{
		return attacksDisplayed;
	}
	
	public Item getSelectedItem()
	{
		return selectedItem;
	}
	
	public Item getItem(int i) throws ItemException
	{
		return bag.getItem(i);
	}
	
	public static void clearEnv()
	{
		env = null;
		mockEnv = null;
	}
}
