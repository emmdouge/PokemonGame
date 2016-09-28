package items;

import pokemon.Pokemon;

/**
 * @author Emmanuel
 * Makes sure that an item can never be null
 */
public class NoItem implements Item {

	@Override
	public void use(Pokemon pokemon) {
		//do nothing
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

}
