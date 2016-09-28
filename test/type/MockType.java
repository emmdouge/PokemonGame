package type;

import pokemon.Pokemon;

public class MockType extends Type
{

	public MockType(Pokemon sub) {
		super(sub);
	}

	@Override
	public int calcDamage(int damage, String attack) {
		// TODO Auto-generated method stub
		return subject.calcDamage(damage, attack);
	}

	@Override
	public String getPokeType() {
		// TODO Auto-generated method stub
		return subject.getPokeType();
	}

}
