package geneticAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class Arrangement {

	ArrayList<Table> arrangement;
	ArrayList<Seat> arrangementSeats;
	
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
	
	public void createArrangementSeats() {
		for(Table table : arrangement) {
			for(Seat s : table.getSeats()) {
				arrangementSeats.add(s);
			}
		}
	}
	
	public ArrayList<Seat> getArrangementSeats() {
		if(arrangementSeats == null) {
			arrangementSeats = new ArrayList<>();
			createArrangementSeats();
		}
		return arrangementSeats;
	}
	
	public void setArrangmentSeats(ArrayList<Seat> seats) {
		this.arrangementSeats = seats;
		
		HashMap<Integer, Table> tables = new HashMap<Integer, Table>();
		for(int i = 0; i < ArrangementManager.numberOfTables(); i++) {
			arrangement.add(null);
		}
		
		for(Seat s : seats) {
			Integer tabledId = s.getTableId();
			if(!tables.containsKey(tabledId)) {
				Table t = new Table();
				t.setTableId(tabledId);
				tables.put(tabledId, t);
			}
			tables.get(tabledId).getSeats().add(s);
		}
		
		for(Table t : tables.values()) {
			arrangement.add(t);
		}
		
	}

	public void generateArrangement() {
		
	}
	
	public int arrangementSize(){
		return arrangement.size();
	}
	
}
