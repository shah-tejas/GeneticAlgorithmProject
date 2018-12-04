package geneticAlgorithm;

import java.util.ArrayList;

public class Arrangement {

	ArrayList<Table> arrangement;
	
	private double fitness;
	
	public Arrangement() {
		arrangement = new ArrayList<>();
		fitness = 0;
		
		for(int i = 0; i < ArrangementManager.numberOfTables(); i++) {
			arrangement.add(null);
		}
	}
	
	public double getFitness() {
		
		if(fitness == 0) {
			//get fitness
			
			int totalFitness = 0;
			
			for(Table table : arrangement) {
				int f = 0;
				Object o[] = table.getSeats().toArray();
				for(int i = 0 ; i < o.length - 1; i++) {
					Seat s = (Seat) o[i];
					Seat s1 = (Seat) o[i+1];
					
					//If two persons' views are same, award 5 points to fitness
					//else deduct difference of views from fitness
					if(s.getPerson().getViews() == s1.getPerson().getViews()) {
						f += 5;
					}
					else {
						f -= Math.abs(s.getPerson().getViews() - s1.getPerson().getViews());
					}
					
					//if the two persons are related, award 10 points to fitness
					//else deduct 10 points
					if(s.getPerson().getRelation() == s1.getPerson().getRelation()) {
						f += 10;
					}
					else {
						f -= 10;
					}
					
					//if the two persons are related, award 5 points to fitness
					//else deduct 5 points
					if(s.getPerson().getEatingPreferences() == s1.getPerson().getEatingPreferences()) {
						f += 5;
					}
					else {
						f -= 5;
					}
				}
				totalFitness += f;
			}
			fitness = (int) (totalFitness / arrangement.size());
			
			
		}
		return fitness;
	}
	
	public void generateArrangement() {
		
	}
	
	public int arrangementSize(){
		return arrangement.size();
	}
	
}
