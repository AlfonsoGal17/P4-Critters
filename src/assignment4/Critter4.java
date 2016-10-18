package assignment4;
//This critter always walks in the UP position,
//if and only if its energy is the same of that
//required to reproduce, it will reproduce
//This is a mean critter, it always wants to fight
public class Critter4 extends Critter{
	@Override
	public String toString() { return "4"; }
	@Override
	public void doTimeStep() {
		//will always walk up
		walk(0);
		if(getEnergy() == Params.min_reproduce_energy){
			reproduce(new Critter4(), 0);
		}
	}

	@Override
	public boolean fight(String oponent) {
		
		return true;
	}

}