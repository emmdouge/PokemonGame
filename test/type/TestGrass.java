package type;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.MockPokemon;
import pokemon.PokeFactory;
import pokemon.Pokemon;
/**
 * 
 * @author Chris Kjeldgaard
 *
 */
public class TestGrass {

	@Test
	public void test() {
		PokeFactory poke = new PokeFactory();
		Pokemon punchingBag = new Grass(new MockPokemon());
		Pokemon fire = poke.generatePokemon(poke.Charizard);//a fire type for testing
		Pokemon water = poke.generatePokemon(poke.Blastoise);//a water type for testing
		Pokemon grass = poke.generatePokemon(poke.Venusaur);//a grass type for testing
		Pokemon normal = new MockPokemon();// a normal type for testing
		
		assertEquals("Grass", punchingBag.getPokeType());
		assertEquals(fire.getAttackPower()*2, punchingBag.calcDamage(fire.getAttackPower(), fire.getPokeType()));
		assertEquals(grass.getAttackPower()/2, punchingBag.calcDamage(grass.getAttackPower(), grass.getPokeType()));
		assertEquals(water.getAttackPower()/2, punchingBag.calcDamage(water.getAttackPower(), water.getPokeType()));
		assertEquals(normal.getAttackPower(), punchingBag.calcDamage(normal.getAttackPower(), normal.getPokeType()));
	}

}
