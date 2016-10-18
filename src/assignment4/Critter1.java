/* CRITTERS 
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Alfonso Galindo
 * ag49477
 * 16450
 * Nicole Muzquiz
 * ngm339
 * 16460
 * Slip days used: <0>
 * Fall 2016
 */


package assignment4;
/**
 * 
 * @author Nicole
 * This Critter is a derp
 * Never moves unless confronted in a fight. Will always try to flee and fight is a last resort when energy is too low to walk.
 * In a peaceful timeStep, just reproduces if it has energy>100. Babies ALWAYS spawn in Dir 0, 1, or 2 (1 block away from parent) 
 */

public class Critter1 extends Critter {

	@Override
	public String toString() { return "1"; }
	
	@Override
	public void doTimeStep() {
		if(getEnergy() > 100){
			Critter1 child = new Critter1();
			int childDir = Critter.getRandomInt(8) % 3;
			reproduce(child, childDir);
		}
		// TODO Auto-generated method stub

	}
	int dir = Critter.getRandomInt(8);

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		if (getEnergy()> Params.run_energy_cost){
			run(dir);
			return false;
		}
		else if(getEnergy() > Params.walk_energy_cost){
			walk(dir);
			return false;
		}
		else{
			return true;
		}
	}

}
