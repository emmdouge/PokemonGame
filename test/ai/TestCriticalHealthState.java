package ai;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pokemon;
import environment.Environment;

/**
 * @author Emmanuel
 *
 */
public class TestCriticalHealthState {

	/**
	 * Tests the action taken when in the critical health state
	 */
	@Test
	public void testCriticalHealthState() {
		Environment.clearEnv();
		Environment env = Environment.createMockEnv();		

		AIContext ai = new AIContext(env);
		Pokemon player = new Bulbasaur();
		Pokemon target = new Bulbasaur();
		env.setCurrentPlayer(player);
		env.setCurrentTarget(target);
		env.setAI(ai);
		assertEquals(player, env.getCurrentPlayer());
		assertEquals(target, env.getCurrentTarget());
		env.getTargetBag().fillBag();
		
		assertEquals(600, env.getCurrentTarget().getCurrentHitpoints());
		assertEquals(ai.getHighHealthState(), ai.getCurrentState());
		
		for(int i = 0; i < 10; i++)
		{
			player.makeAttack(target, 0);
		}
		ai.execute();
		assertEquals(100, env.getCurrentTarget().getCurrentHitpoints());
		assertEquals(ai.getCriticalHealthState(), ai.getCurrentState());

		assertEquals(600, env.getCurrentPlayer().getMaxHitpoints());
		ai.execute();
		
		boolean success = false;
		
		//effects on player's health after taking one of 4 attacks from the target
		if(env.getCurrentPlayer().getCurrentHitpoints() == 600)
		{
			success = true;
		}
		else if(env.getCurrentPlayer().getCurrentHitpoints() == 550)
		{
			success = true;
		}
		else if(env.getCurrentPlayer().getCurrentHitpoints() == 500)
		{
			success = true;
		}	
		else if(env.getCurrentPlayer().getCurrentHitpoints() == 450)
		{
			success = true;
		}			
		else if(env.getCurrentPlayer().getCurrentHitpoints() == 400)
		{
			success = true;
		}			
		else if(env.getCurrentPlayer().getCurrentHitpoints() == 300)
		{
			success = true;
		}
		else
		{
			System.out.println(env.getCurrentPlayer().getCurrentHitpoints());
		}
		
		//target switched
		if(env.getCurrentTarget() != target)
		{
			success = true;
		}

		
		assertTrue(success);
		
		player = new Charmander();
		env.setCurrentPlayer(player);
		
		for(int i = 0; i < 3; i++)
		{
			env.getCurrentPlayer().makeAttack(target, 0);
		}
		
		//if pokemon not switched, check that the pokemon is dead
		if(env.getCurrentTarget() == target)
		{
			assertEquals(0, env.getCurrentTarget().getCurrentHitpoints());
		}
		
		ai.execute();
	
		assertNotEquals(target, env.getCurrentTarget());
	}

}
