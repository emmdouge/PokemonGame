//Emmanuel Douge
package growthBehavior;

/**
 * @author Emmanuel
 *
 * an implementation  of the recoveryBehavior that recovers based
 * on the currentLifePoints of a lifeform
 *
 */
public class GrowthFractional implements GrowthBehavior
{
	private double fracGrowthRate;
	
	/**
	 * @param fracGrowthRate the fractional growth rate based on 
	 * the current amount of lifePoints of the lifeform
	 */
	public GrowthFractional(double fracGrowthRate)
	{
		this.fracGrowthRate = fracGrowthRate;
	}
	
	/**
	 * @return returns the amount of lifePoints to be added based on
	 * the current amount of lifePoints of the lifeform
	 */
	@Override
	public int calculateGrowth(int currentX, int maximumX) 
	{
		int lifePointsToBeAdded = (int)(currentX * fracGrowthRate);
		
		if(lifePointsToBeAdded + currentX < maximumX)
		{
			return lifePointsToBeAdded;
		}
		else if (lifePointsToBeAdded + currentX >= maximumX)
		{
			return maximumX - currentX;
		}
		else
		{
			return 0;
		}
	}

}
