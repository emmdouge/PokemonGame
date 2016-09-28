package type;

import pokemon.Pokemon;
import status.Status;
import moves.Move;
/**
 * 
 * @author  Chris Kjeldgaard
 *
		//with only the 3 implementations of types all others deal normal damage which is not increased or decreased
 */
public abstract class Type extends Pokemon 
{
	protected Pokemon subject;
	
	public Type(Pokemon sub) {
		subject = sub;
	}
	
	public abstract int calcDamage(int damage, String Attack);//When attacked by certain moves the amount of damage taken either gets reduced or increased depending on type dependency
	public abstract String getPokeType();//returns the String name of the type the pokemon has
	
	//Type is a decorator which decorates a pokemon to change the way it takes damage.
	//All the following methods don't change the way the methods work so type just passes the method call to the pokemon
	
	public void updateObservers()
	{
		subject.updateObservers();
	}
	
	public void changeStatus(Status newStatus)
	{
		subject.changeStatus(newStatus);
	}
	public Status getPoisonStatus() {
		return subject.getPoisonStatus();
	}
	public Status getBurnStatus() {
		return subject.getBurnStatus();
	}
	public Status getConfusedStatus() {
		return subject.getConfusedStatus();
	}
	
	public Status getCurrentStatus() {
		return subject.getCurrentStatus();
	}
	public void setCurrentStatus(Status currentStatus) {
		subject.changeStatus(currentStatus);
	}
	public Status getNormalStatus() {
		return subject.getNormalStatus();
	}
	public Status getDeadStatus(){
		return subject.getDeadStatus();
	}
	public int getLevel() {
		return subject.getLevel();
	}
	public int getAttackPower() {
		return subject.getAttackPower();
	}
	public void setAttackPower(int attackPower) {
		subject.setAttackPower(attackPower);
	}
	public int getSpecialAttackPower() {
		return subject.getSpecialAttackPower();
	}
	public void setSpecialAttackPower(int specialAttackPower) {
		subject.setSpecialAttackPower(specialAttackPower);
	}
	public int getDefense() {
		return subject.getDefense();
	}
	public void setDefense(int defense) {
		subject.setDefense(defense);
	}
	public int getSpecialDefense() {
		return subject.getSpecialDefense();
	}
	public void setSpecialDefense(int specialDefense) {
		subject.setSpecialDefense(specialDefense);
	}
	public int getCurrentHitpoints() {
		return subject.getCurrentHitpoints();
	}
	public void setCurrentHitpoints(int currentHitpoints) {
		subject.setCurrentHitpoints(currentHitpoints);
	}
	public int getMaxHitpoints() {
		return subject.getMaxHitpoints();
	}
	public String getName() {
		return subject.getName();
	}
	public Move[] getAttacks() {
		return subject.getAttacks();
	}
	public void makeAttack(Pokemon target, int i) {
		subject.getAttacks()[i].attack(target);
	}
}
