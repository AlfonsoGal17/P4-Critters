package assignment4;
//This Critter will ALWAYS try to reproduce
//after it makes a baby, it will run() away
//because it doesn't like babies.
//This critter will choose a number at random
//if the number is less than 4 it will fight
//otherwise it will not fight and accept its
//death
public class Critter3 extends Critter {
	
	@Override
	public String toString() { return "3"; }
	@Override
	public void doTimeStep() {
		//makes a baby
		if(getEnergy()> Params.min_reproduce_energy){
			reproduce(new Critter3(), Critter.getRandomInt(8));
		}
		//hates baby, runs away
		walk(Critter.getRandomInt(8));
		
	}

	@Override
	public boolean fight(String oponent) {
		
		
			return true;
		

	}

}
