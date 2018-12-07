package geneticAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import org.apache.log4j.Logger;

public class Arrangement {

	ArrayList<Table> arrangement;
	ArrayList<Seat> arrangementSeats; 
	final static Logger logger = Logger.getLogger(GAImplementationConsole.class);
	
	private double fitness;
	
	public Arrangement() {
		arrangement = new ArrayList<>();
		fitness = 0;
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
						f += 20;
					}
					else {
						f -= 20;
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
		
		ArrayList<Table> newArrangement = new ArrayList<>();
		
		HashMap<Integer, Table> tables = new HashMap<Integer, Table>();
		
		for(Seat s : seats) {
			Integer tabledId = s.getTableId();
			if(!tables.containsKey(tabledId)) {
				Table t = new Table(tabledId);
				tables.put(tabledId, t);
			}
			tables.get(tabledId).getSeats().add(s);
		}
		
		for(Table t : tables.values()) {
			newArrangement.add(t);
		}
		
		this.arrangement = newArrangement;
	}

	public void generateArrangement() {
		
		int NumberOfPersonsPerTable = ArrangementManager.getGuestsPerTable();
		
		ArrayList<Seat> allSeats = ArrangementManager.getAllSeats();
		
		//Shuffle the seats
		Collections.shuffle(allSeats);
		
		for(int tableno = 0; tableno < ArrangementManager.numberOfTables(); tableno++) {
			Table t = ArrangementManager.getTable(tableno);
			
			t.emptyAllSeats();
			
			for(int i = 0 ; i < NumberOfPersonsPerTable ; i++) {
				
				//Pick a random seat
				Random random = new Random();
				int randomSeat = random.nextInt(allSeats.size());
				Seat s = allSeats.get(randomSeat);
				s.setTableId(t.getTableId());
				t.addSeat(s);
				allSeats.remove(randomSeat);
			}
			
			arrangement.add(t);

		}
	}
	
	public ArrayList<Table> getArrangement() {
		return arrangement;
	}

	public int arrangementSize(){
		return arrangement.size();
	}
	
	
	
	public void displayArrangement() {
		for(Table t : arrangement) {
			logger.debug("Table Id : " + t.getTableId());
			for(Seat s : t.getSeats()) {
				logger.debug("\tPerson Id : " + s.getPerson().getPersonId() + " Views: " + s.getPerson().getViews() + " Relation: " + s.getPerson().getRelation() + " Eating: " + s.getPerson().getEatingPreferences());
			}
		}
	}
	
}
