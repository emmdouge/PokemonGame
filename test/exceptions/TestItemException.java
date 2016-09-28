package exceptions;

import static org.junit.Assert.*;
import items.Bag;

import org.junit.Test;

/**
 * @author Emmanuel
 * Tests all cases in which an item exception must be thrown
 */
public class TestItemException {

	/**
	 * @throws ItemException when bag tries to access invalid slot 
	 */
	@Test (expected = ItemException.class)
	public void testBagGetItem() throws ItemException {
		Bag bag = new Bag();
		bag.getItem(-1);
		bag.getItem(7);
	}

}
