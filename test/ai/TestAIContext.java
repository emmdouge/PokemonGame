package ai;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;

/**
 * @author Emmanuel
 *
 */
public class TestAIContext {

	/**
	 * Test the initialization of the AIContext
	 */
	@Test
	public void testInitialization() {
		Environment env = Environment.create();			
		Environment.clearEnv();
		AIContext ai = new AIContext(env);
		
		assertNotNull(ai.getCriticalHealthState());
		assertNotNull(ai.getHighHealthState());
		assertNotNull(ai.getLowHealthState());
		
		assertEquals(ai.getCurrentState(), ai.getHighHealthState());	
		
		ai.setCurrentState(ai.getLowHealthState());		
		assertEquals(ai.getCurrentState(), ai.getLowHealthState());
		
		ai.setCurrentState(ai.getCriticalHealthState());
		assertEquals(ai.getCurrentState(), ai.getCriticalHealthState());	
		
		assertEquals(ai.getCurrentState().env, env);
	}
	
	/**
	 * Tests the setCurrentState() of the AIContext class
	 */
	@Test
	public void testSetCurrentState()
	{
		Environment env = Environment.create();	
		Environment.clearEnv();

		AIContext ai = new AIContext(env);
		
		assertEquals(ai.getCurrentState(), ai.getHighHealthState());	
		
		ai.setCurrentState(ai.getLowHealthState());		
		assertEquals(ai.getCurrentState(), ai.getLowHealthState());
		
		ai.setCurrentState(ai.getCriticalHealthState());
		assertEquals(ai.getCurrentState(), ai.getCriticalHealthState());	
					
	}

}
