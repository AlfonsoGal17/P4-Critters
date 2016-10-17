package assignment4;

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
			walk(Critter.getRandomInt(5));
			return true;
		}
		else{
			return true;
		}
	}

}
