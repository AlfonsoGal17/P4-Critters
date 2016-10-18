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
 * Slightly smarter Critter.
 * In a timeStep, will reproduce if it has high energy, otherwise will run (if energy> 2*run cost) or walk (if energy> walk cost).
 * If in a fight, will fight if energy> 100 OR energy<walk cost. If energy<100 AND energy> walk cost, then it will attempt to flee
 */

public class Critter2 extends Critter {

	@Override
	public String toString() { return "2"; }
	
	@Override
	public void doTimeStep() {
		if (getEnergy() > 200){
			Critter2 child = new Critter2();
			int childDir = Critter.getRandomInt(8);
			while (!(childDir%2 == 0)){ //want the babies to NOT spawn diagonally
				childDir = Critter.getRandomInt(8);
			}
			reproduce(child,childDir);
		}
		else if (getEnergy()> 2*Params.run_energy_cost){
			
		}
		else if (getEnergy() > Params.walk_energy_cost){
			
		}
		
		// TODO Auto-generated method stub

	}

	@Override
	public boolean fight(String oponent) {
		if(getEnergy()<= 100 && getEnergy() > Params.walk_energy_cost ){
			int dir = Critter.getRandomInt(5); 
			walk(dir);
			return false;
		}
		else{
			return true;
		}
	}

}
