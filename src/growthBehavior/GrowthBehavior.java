//Emmanuel Douge
package growthBehavior;

/**
 * part of the strategy pattern for the item class
 * to make behaviors interchangeable and
 * maintainable
 *
 */
public interface GrowthBehavior
{
	/**
	 * @param currentX the current amount
	 * @param maximumX maximum amount 
	 * @return the amount to be added/removed
	 */
	int calculateGrowth(int currentX, int maximumX);
}
