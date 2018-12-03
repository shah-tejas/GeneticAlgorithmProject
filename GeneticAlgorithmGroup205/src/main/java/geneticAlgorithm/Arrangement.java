package geneticAlgorithm;

import java.util.ArrayList;

public class Arrangement {

	ArrayList<Table> tables;
	
	private double fitness;
	
	public Arrangement() {
		tables = new ArrayList<>();
		fitness = 0;
		
		for(int i = 0; i < ArrangementManager.numberOfTables(); i++) {
			tables.add(null);
		}
	}
	
	public double getFitness() {
		
		if(fitness == 0) {
			//get fitness
			
			int totalFitness = 0;
			
			for(Table table : tables) {
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
					if(s.getPerson().getRelated() == s1.getPerson().getRelated()) {
						f += 10;
					}
					else {
						f -= 10;
					}
					
					//if the two persons are related, award 5 points to fitness
					//else deduct 5 points
					if(s.getPerson().getEating() == s1.getPerson().getEating()) {
						f += 5;
					}
					else {
						f -= 5;
					}
				}
				totalFitness += f;
			}
			fitness = (int) (totalFitness / tables.size());
			
			
		}
		return fitness;
	}
	
	public void generateArrangement() {
		
	}
	
}
