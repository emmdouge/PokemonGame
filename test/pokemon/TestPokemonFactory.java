package pokemon;
/**
 * @author Chris Kjeldgaard
 */
import static org.junit.Assert.*;

import org.junit.Test;

import type.Water;

public class TestPokemonFactory {

	@Test
	public void test() 
	{
		PokeFactory poke = new PokeFactory();
		Pokemon testSubject = poke.generatePokemon(poke.Blastoise);
		assertEquals(testSubject.getName(), "Blastoise");
		testSubject = poke.generatePokemon(poke.Bulbasaur);
		assertEquals(testSubject.getName(), "Bulbasaur");
		testSubject = poke.generatePokemon(poke.Caterpie);
		assertEquals(testSubject.getName(), "Caterpie");
		testSubject = poke.generatePokemon(poke.Charizard);
		assertEquals(testSubject.getName(), "Charizard");
		testSubject = poke.generatePokemon(poke.Charmander);
		assertEquals(testSubject.getName(), "Charmander");
		testSubject = poke.generatePokemon(poke.Charmeleon);
		assertEquals(testSubject.getName(), "Charmeleon");
		testSubject = poke.generatePokemon(poke.Ivysaur);
		assertEquals(testSubject.getName(), "Ivysaur");
		testSubject = poke.generatePokemon(poke.Poliwag);
		assertEquals(testSubject.getName(), "Poliwag");
		testSubject = poke.generatePokemon(poke.Squirtle);
		assertEquals(testSubject.getName(), "Squirtle");
		testSubject = poke.generatePokemon(poke.Venusaur);
		assertEquals(testSubject.getName(), "Venusaur");
		testSubject = poke.generatePokemon(poke.Vulpix);
		assertEquals(testSubject.getName(), "Vulpix");
		testSubject = poke.generatePokemon(poke.Wartortle);
		assertEquals(testSubject.getName(), "Wartortle");
		testSubject = poke.generatePokemon(poke.Bulbasaur);
		assertEquals(testSubject.getName(), "Bulbasaur");
		testSubject = poke.generatePokemon(poke.Bulbasaur);
		assertEquals(testSubject.getName(), "Bulbasaur");
		testSubject = poke.generatePokemon("Bob");
		assertNull(testSubject);
		
	}

}
