package ai;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pokemon;
import environment.Environment;
import exceptions.ItemException;

/**
 * @author Emmanuel
 *
 */
public class TestAIState {

	/**
	 * Tests the initialization of the AIState
	 * @throws ItemException 
	 */
	@Test
	public void testInitialization() throws ItemException {
		Environment.clearEnv();
		Environment env = Environment.createMockEnv();	
		AIContext ai = new AIContext(env);
		Pokemon player = new Charmander();
		Pokemon target = new Bulbasaur();
		env.setCurrentPlayer(player);
		env.setCurrentTarget(target);
		env.setAI(ai);
		assertEquals(player, env.getCurrentPlayer());
		assertEquals(target, env.getCurrentTarget());
		assertEquals(env, ai.getCurrentState().env);
	}
	
	/**
	 * Tests state's ability to attack the player
	 */
	@Test
	public void testAttackPlayer()
	{
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
		
		for(int i = 0; i < 1; i++)
		{
			player.makeAttack(target, 0);
		}
		ai.execute();
		assertEquals(550, env.getCurrentTarget().getCurrentHitpoints());
		assertEquals(ai.getHighHealthState(), ai.getCurrentState());

		assertEquals(600, env.getCurrentPlayer().getMaxHitpoints());
		ai.getHighHealthState().attackPlayer();
		
		boolean success = false;
		
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
		assertTrue(success);
	}

	/**
	 * Tests state's ability to switch pokemon
	 */
	@Test
	public void testSwitchPokemon()
	{
		Environment.clearEnv();
		Environment env = Environment.createMockEnv();
		AIContext ai = new AIContext(env);
		Pokemon player = new Charmander();
		Pokemon target = new Bulbasaur();
		env.setCurrentPlayer(player);
		env.setCurrentTarget(target);
		env.setAI(ai);
		assertEquals(player, env.getCurrentPlayer());
		assertEquals(target, env.getCurrentTarget());
		env.getTargetBag().fillBag();
		
		assertEquals(600, env.getCurrentTarget().getCurrentHitpoints());
		assertEquals(ai.getHighHealthState(), ai.getCurrentState());
		
		for(int i = 0; i < 3; i++)
		{
			player.makeAttack(target, 0);
		}
		ai.execute();
		assertEquals(150, env.getCurrentTarget().getCurrentHitpoints());
		assertEquals(ai.getCriticalHealthState(), ai.getCurrentState());
		
		
		ai.getCriticalHealthState().switchPokemon();		
		assertNotEquals(target, env.getCurrentTarget());
	}
	
	/**
	 * Tests state's ability to use item
	 * @throws ItemException if invalid index is used to access an item within bag
	 */
	@Test
	public void testUseItem() throws ItemException
	{
		Environment.clearEnv();
		Environment env = Environment.createMockEnv();
		AIContext ai = new AIContext(env);
		Pokemon player = new Charmander();
		Pokemon target = new Bulbasaur();
		env.setCurrentPlayer(player);
		env.setCurrentTarget(target);
		env.setAI(ai);
		assertEquals(player, env.getCurrentPlayer());
		assertEquals(target, env.getCurrentTarget());
		env.getTargetBag().fillBag();
		
		assertEquals(600, env.getCurrentTarget().getCurrentHitpoints());
		assertEquals(ai.getHighHealthState(), ai.getCurrentState());
		
		for(int i = 0; i < 2; i++)
		{
			player.makeAttack(target, 0);
		}
		ai.execute();
		assertEquals(300, env.getCurrentTarget().getCurrentHitpoints());
		assertEquals(ai.getLowHealthState(), ai.getCurrentState());
		

		ai.getLowHealthState().useItem();
		
		boolean success = false;
		
		//3 types of affect on health using one of 3 random health adding items
		if(env.getCurrentTarget().getCurrentHitpoints() == 320)
		{
			success = true;
			assertEquals(ai.getLowHealthState(), ai.getCurrentState());
		}
		else if(env.getCurrentTarget().getCurrentHitpoints() == 450)
		{
			success = true;
			assertEquals(ai.getLowHealthState(), ai.getCurrentState());
		}
		else if(env.getCurrentTarget().getCurrentHitpoints() == 350)
		{
			success = true;
			assertEquals(ai.getLowHealthState(), ai.getCurrentState());
		}

		assertTrue(success);
	}
}
