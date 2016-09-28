import exceptions.TestItemException;
import growthBehavior.TestGrowthFractional;
import growthBehavior.TestGrowthLinear;
import items.TestAllItems;
import items.TestBag;
import moves.*;

import org.junit.runner.RunWith; 
import org.junit.runners.Suite; 

import pokemon.*;
import status.*;
import type.*;
import Commands.TestInvokerCommands;
import DisplayState.TestDisplayState;
import InvokerGUI.TestInvokerGUI;
import ai.TestAIContext;
import ai.TestAIState;
import ai.TestCriticalHealthState;
import ai.TestHighHealthState;
import ai.TestLowHealthState;

/** 
 * Runs all of the tests in this project 
 * @author Emmanuel
 * @author Chris
 * @author Cassia
 * @author Josh
 * @author Brandon
 */ 
@RunWith(Suite.class) 
@Suite.SuiteClasses
( 
	{  
		TestInvokerCommands.class,
		TestDisplayState.class,
		TestInvokerGUI.class,
		TestAllItems.class,
		TestGrowthFractional.class,
		TestGrowthLinear.class,
		TestBag.class,
		TestItemException.class,
		TestPokemon.class,
		TestPokemonFactory.class,
		TestBlastoise.class,
		TestBulbasaur.class,
		TestCaterpie.class,
		TestCharizard.class,
		TestCharmander.class,
		TestCharmeleon.class,
		TestIvysaur.class,
		TestPoliwag.class,
		TestSquirtle.class,
		TestVenusaur.class,
		TestVulpix.class,
		TestWartortle.class,
		testBurn.class,
		testConfused.class,
		testDead.class,
		testNormal.class,
		testPoison.class,
		TestType.class,
		TestFire.class,
		TestWater.class,
		TestGrass.class,
		testEmber.class,
		testFlamethrower.class,
		testGrowl.class,
		testMove.class,
		testMoveFactory.class,
		testPoisonSting.class,
		testScratch.class,
		testSurf.class,
		testTackle.class,
		testTailWhip.class,
		testWhirlpool.class,
		testRazorleaf.class,
//		TestInvokerGUI.class,
		TestAIContext.class,
		TestAIState.class,
		TestHighHealthState.class,
		TestLowHealthState.class,
		TestCriticalHealthState.class
	}
) 
 
public class AllGameTests 
{ 
} 

