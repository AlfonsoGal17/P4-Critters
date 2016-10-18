package assignment4;
/*
 * @author Alfonso Galindo
 * 
 */
/*
 * This critter will always take a walk in a
 * random direction. Then it will make a baby
 * This critter is not afraid of others, it has
 * its mind set to mess up other critters
 */
public class Critter3 extends Critter {
	
	@Override
	public String toString() { return "3"; }
	@Override
	public void doTimeStep() {
		walk(Critter.getRandomInt(8));
		//makes a baby
		if(getEnergy()> Params.min_reproduce_energy){
			reproduce(new Critter3(), Critter.getRandomInt(8));
		}
		//hates baby, runs away
		
		
	}

	@Override
	public boolean fight(String oponent) {
		
		
			return true;
		

	}

}
