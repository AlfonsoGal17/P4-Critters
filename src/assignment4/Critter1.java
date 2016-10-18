package assignment4;

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
		}
		else if(getEnergy() > Params.walk_energy_cost){
			walk(dir);
		}
		else{
			return true;
		}
		return false;
	}

}
