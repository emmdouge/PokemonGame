package team;

import java.util.Iterator;
import java.util.Random;

import pokemon.PokeFactory;
import pokemon.Pokemon;

/**
 * 
 * @author Cassia Hulshizer
 *
 */
public class PokeTeam implements Team
{
	private Pokemon[] pokemon = new Pokemon[6];
	
	public PokeTeam()
	{
		createTeam();
	}
	
	public void createTeam()
	{
		PokeFactory factory = new PokeFactory();
		String name = "";
		
		boolean incomplete = true;
		boolean found = false;
		int[] rand = new int[6];
		Random randGen = new Random();
		int random;
		int r = 0;
		while (incomplete)
		{
			found = false;
			random = randGen.nextInt(12);
			for (int k = 0; k < 6; k++)
			{
				if (random == rand[k])
				{
					found = true;
					break;
				}
			}
			if (!found)
			{
				rand[r] = random;
				r++;
				if (r == 6) incomplete = false;
			}
			else
				continue;
		}
					
		for(int i = 0; i < 6; i++)
		{
			switch (rand[i])
			{
				case 0:
					name = "Blastoise";
					break;
				case 1:
					name = "Bulbasaur";
					break;
				case 2:
					name = "Caterpie";
					break;
				case 3:
					name = "Charizard";
					break;
				case 4:
					name = "Charmander";
					break;
				case 5:
					name = "Charmeleon";
					break;
				case 6:
					name = "Ivysaur";
					break;
				case 7:
					name = "Poliwag";
					break;
				case 8:
					name = "Squirtle";
					break;
				case 9:
					name = "Venusaur";
					break;
				case 10:
					name = "Vulprix";
					break;
				case 11:
					name = "Wartortle";
					break;
			}
			pokemon[i] = factory.generatePokemon(name);
			//System.out.println(pokemon[i]);
		}	
	}
	
	@Override
	public Iterator<Pokemon> createIterator() 
	{
		return new TeamIterator(pokemon);		
	}

}
