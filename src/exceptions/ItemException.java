package exceptions;

/**
 * @author Emmanuel
 * exception class for items
 */
@SuppressWarnings("serial")
public class ItemException extends Exception {

	/**
	 * @param errorMessage error message to be shown that involves items
	 */
	public ItemException(String errorMessage)
	{
		super(errorMessage);
	}
}
