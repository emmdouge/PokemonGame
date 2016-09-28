package team;

import java.util.Iterator;

import pokemon.Pokemon;

public class TeamIterator implements Iterator<Pokemon>
{
	Pokemon[] team;
	int position = 0;
	
	public TeamIterator(Pokemon[] team)
	{
		this.team = team;
	}
	
	@Override
	public boolean hasNext() 
	{
		if (position >= team.length || team[position] == null)
			return false;
		else
			return true;
	}

	@Override
	public Pokemon next() 
	{
		Pokemon pokemon = team[position];
		position++;
		return pokemon;
	}
}
