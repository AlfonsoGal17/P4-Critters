/* CRITTERS
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Alfonso Galindo
 * ag49477
 * 16450
 * <Nicole Muzquiz>
 * <ngm339>
 * <16460>
 * Slip days used: <0>
 * Fall 2016
 */


package assignment4;
/*
 * Do not change this file.
 */
import assignment4.Critter.TestCritter;

public class Algae extends TestCritter {

	public String toString() { return "@"; }
	
	public boolean fight(String not_used) { return false; }
	
	public void doTimeStep() {
		setEnergy(getEnergy() + Params.photosynthesis_energy_amount);
		
		//spawning more algae
		for (int x = 0; x<Params.refresh_algae_count; x++){
			try {
				Critter.makeCritter("assignment4.Algae");
			} catch (InvalidCritterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
