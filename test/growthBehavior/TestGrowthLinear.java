//Emmanuel Douge
package growthBehavior;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the linear implementation of the GrowthBehavior interface
 *
 */
public class TestGrowthLinear {

	/**
	 * Tests the border cases of the linear growth implementation
	 */
	@Test
	public void testGrowthLinear()
	{
		GrowthLinear gl = new GrowthLinear(40);
		int maximumX = 30;
		int currentX = 20;
		int lifePointsToBeAdded = gl.calculateGrowth(currentX, maximumX);
		
		//amount to be added does not surpass maximumX when added to currentX
		assertEquals(maximumX, currentX+lifePointsToBeAdded);
		
		currentX = 5;
		gl = new GrowthLinear(5);
		lifePointsToBeAdded = gl.calculateGrowth(currentX, maximumX);
		
		//adds correct amount when currentX is less than maximumX
		assertEquals(10, currentX+lifePointsToBeAdded);

	}
}
