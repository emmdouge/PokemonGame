package growthBehavior;

/**
 * @author Emmanuel
 * 
 * adds/removes a constant integer amount
 *
 */
public class GrowthLinear implements GrowthBehavior
{
	private int linearGrowthRate;
	
	/**
	 * @param linearGrowthRate the constant integer amount to add/remove
	 * 
	 */
	public GrowthLinear(int linearGrowthRate)
	{
		this.linearGrowthRate = linearGrowthRate;
	}
	
	/**
	 * @return the constant integer amount to be added/removed
	 */
	@Override
	public int calculateGrowth(int currentX, int maximumX) 
	{
		if(currentX + linearGrowthRate < maximumX)
		{
			return linearGrowthRate;
		}
		else if (currentX + linearGrowthRate >= maximumX)
		{
			return maximumX - currentX;
		}
		else
		{
			return 0;
		}
	}

}
