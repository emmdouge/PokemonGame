package team;

import java.util.Iterator;

import pokemon.PokeFactory;
import pokemon.Pokemon;

public interface Team 
{
	
	public void createTeam();
	
	public Iterator<Pokemon> createIterator();
}
