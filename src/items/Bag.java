package items;

import exceptions.ItemException;

/**
 * @author Emmanuel
 * Bag will hold a collection of items
 */
public class Bag {
	
	private static final int maxItemsBagHolds = 6;
	
	private Item[] itemBag = new Item[maxItemsBagHolds];
	
	/**
	 * fills the bag with NoItem instances to prevent null pointer exceptions
	 */
	public Bag()
	{
		for(int i = 0; i < this.getMaxItemsBagHolds(); i++)
		{
			itemBag[i] = new NoItem();
		}
	}
	
	/**
	 * @param index index of item to be returned from the bag
	 * @return the item indexed by bag
	 */
	public Item getItem(int index) throws ItemException
	{
		Item item = new NoItem();
		if(index < this.getMaxItemsBagHolds() && index >= 0)
			item = itemBag[index];
		else
		{
			throw new ItemException("Accessing invalid item slot");
		}
		return item;
	}
	
	/**
	 * fills the bag with random items
	 */
	public void fillBag()
	{
		for(int i = 0; i < this.getMaxItemsBagHolds(); i++)
		{
			if(itemBag[i].isEmpty() == true)
			{
				itemBag[i] = ItemFactory.create((int)(Math.random()*AllItems.getNumPossibleItems()));
			}
		}		
	}
	
	/**
	 * @param item the id of the item to be created by the itemfactory and added to the bag
	 */
	public void addItem(int item)
	{
		boolean emptySlot = false;
		if(item < AllItems.getNumPossibleItems() && item >= 0)
		{
			for(int i = 0; (i < this.getMaxItemsBagHolds()) && (emptySlot == false); i++)
			{
				if(itemBag[i].isEmpty() == true)
				{
					itemBag[i] = ItemFactory.create(item);
					emptySlot = true;
				}
			}
		}
	}
	
	/**
	 * @param index the index of item to be removed from the bag
	 */
	public void removeItem(int index)
	{
		if(index < this.getMaxItemsBagHolds() && index >= 0)
		itemBag[index] = new NoItem();
	}
	
	/**
	 * @param index the index of the item to get the name from within bag
	 * @return the name of the item
	 */
	public String getItemName(int index)
	{
		Item item = new NoItem();
		if(index < this.getMaxItemsBagHolds() && index >= 0)
			item = itemBag[index];
			
		return item.getName();
	}
	
	/**
	 * @return the max number of items a bag can hold
	 */
	public int getMaxItemsBagHolds()
	{
		return maxItemsBagHolds;
	}
}
