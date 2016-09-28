package pokemon;

import type.Fire;
import type.Grass;
import type.Water;
/**
 * @author Chris Kjeldgaard
 */
public class PokeFactory {
	
	public final String Blastoise = "Blastoise";
	public final String Bulbasaur = "Bulbasaur";
	public final String Caterpie = "Caterpie";
	public final String Charizard = "Charizard";
	public final String Charmander = "Charmander";
	public final String Charmeleon = "Charmeleon";
	public final String Ivysaur = "Ivysaur";
	public final String Poliwag = "Poliwag";
	public final String Squirtle = "Squirtle";
	public final String Venusaur = "Venusaur";
	public final String Vulpix = "Vulpix";
	public final String Wartortle = "Wartortle";
	
	
	/**
	 * @param pokeName, String representation of the pokemon
	 * @param level, power level of the pokemon
	 * @return the pokemon that was generated if one was.
	 */
	public Pokemon generatePokemon(String pokeName, int level)
	{
		//takes the String input which determines the pokemon that is requested and returns a new version of that pokemon.
		switch (pokeName)
		{
			case Blastoise:
				return new Water(new Blastoise(level));
			case Bulbasaur:
				return new Grass(new Bulbasaur(level));
			case Caterpie:
				return new Grass(new Caterpie(level));
			case Charizard:
				return new Fire(new Charizard(level));
			case Charmander:
				return new Fire(new Charmander(level));
			case Charmeleon:
				return new Fire(new Charmeleon(level));
			case Ivysaur:
				return new Grass(new Ivysaur(level));
			case Poliwag:
				return new Water(new Poliwag(level));
			case Squirtle:
				return new Water(new Squirtle(level));
			case Venusaur:
				return new Grass(new Venusaur(level));
			case Vulpix:
				return new Fire(new Vulprix(level));
			case Wartortle:
				return new Water(new Wartortle(level));
			default:
				return null;//If the string does not exist no pokemon can be returned
		}
	}
	/**
	 * All pokemon have a level so if none is provided the level is assumed to be 100.
	 * @param pokeName
	 * @return
	 */
	public Pokemon generatePokemon(String pokeName)
	{//all pokemon must have a level so if none is provided the code assumes the pokemon is max level.
		return generatePokemon(pokeName,100);
	}
}
