//Emmanuel Douge
package growthBehavior;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the fractional growth implementation of the 
 * growthBehavior interface
 *
 */
public class TestGrowthFractional {

	/**
	 * Tests the border cases in which fractional amounts may be or
	 * may not be added
	 */
	@Test
	public void testGrowthFractional() 
	{
		GrowthFractional gf = new GrowthFractional(.5);
		int maximumX = 100;
		int currentX = 100;
		int amountToBeAdded = gf.calculateGrowth(currentX, maximumX);
		
		//integer amount to be added does not surpass maximum
		assertEquals(maximumX, currentX+amountToBeAdded);
		
		currentX = 10;
		gf = new GrowthFractional(.5);
		amountToBeAdded = gf.calculateGrowth(currentX, maximumX);
		
		//adds correct integer amount
		assertEquals(15, currentX+amountToBeAdded);

	}

}
