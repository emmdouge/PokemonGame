package moves;

/**
 * Creates a specific move set for each type of Pokemon
 * @author Brandon Shawver
 */
public class MoveFactory 
{
	public Move[] createGrassMoves()
	{
		Move[] attacks = new Move[4];
		
		Physical phy = new Physical();
		StatChange stat = new StatChange();
		Special RazSpecial = new Special();
		Special PsnSpecial = new Special();
		
		Move Tackle = new Tackle(phy);
		Move Growl = new Growl(stat);
		Move RazorLeaf = new Razorleaf(RazSpecial);
		Move PoisonSting = new PoisonSting(PsnSpecial);
		
		attacks[0] = Tackle;
		attacks[1] = Growl;
		attacks[2] = RazorLeaf;
		attacks[3] = PoisonSting;
		
		return attacks;
	}
	
	public Move[] createFireMoves()
	{
		Move[] attacks = new Move[4];
		
		Physical phy = new Physical();
		StatChange stat = new StatChange();
		Special FlamSpecial = new Special();
		Special BrnSpecial = new Special();
		
		Move Scratch = new Scratch(phy);
		Move Growl = new Growl(stat);
		Move Flamethrower = new Flamethrower(FlamSpecial);
		Move Ember = new Ember(BrnSpecial);
		
		attacks[0] = Scratch;
		attacks[1] = Growl;
		attacks[2] = Flamethrower;
		attacks[3] = Ember;
		
		return attacks;
	}
	
	public Move[] createWaterMoves()
	{
		Move[] attacks = new Move[4];
		
		Physical phy = new Physical();
		StatChange stat = new StatChange();
		Special SurfSpecial = new Special();
		Special ConSpecial = new Special();
		
		Move Tackle = new Tackle(phy);
		Move Tailwhip = new TailWhip(stat);
		Move Surf = new Surf(SurfSpecial);
		Move Whirlpool = new Whirlpool(ConSpecial);
		
		attacks[0] = Tackle;
		attacks[1] = Tailwhip;
		attacks[2] = Surf;
		attacks[3] = Whirlpool;
		
		return attacks;
	}
	
	/*Fire Moves*/
	/**
	 * Scratch 
	 * Ember          - Status effect burn, lower base damage ie. = SAttack
	 * Growl          - Attack Power lower - Sattack and attack
	 * Flamethrower   - Increased base damage - mult 1.5
	 */

	/*Water Moves*/
	/**
	 * Tackle 
	 * Surf        - Increased base damage - mult 1.5
	 * Tail-Whip   - Defense power lower - Sdefense and defense
	 * Whirlpool   - Status effect confusion, lower base damage ie. = SAttack
	 */

	/*Grass Moves*/
	/**
	 * Tackle
	 * Razorleaf   - Increased base damage - mult 1.5
	 * Growl       - Attack Power lower - Sattack and attack
	 * PoisonSting - Status effect poison, lower base damage ie. = SAttack
	 */
}
