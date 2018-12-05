package geneticAlgorithm;

import java.util.ArrayList;

public class GeneticAlgorithm {

	
	public static final double mutationRate = 0.020;
	
	public static final int tournamentSize = 10;
	
	public static final boolean elitism = true;
	
	
	public static Population evolvePopulation(Population population){
		Population newPopulation=new Population(population.populationSize(), false);
		
		int elitismOffset = 0;
		
		if(elitism){
			newPopulation.saveArrangement(0, population.getFittest());
			elitismOffset=1;
		}
		
		// crossover population
		for (int i = elitismOffset; i < population.populationSize(); i++) {
			
			Arrangement parent1 = selectParent(population);	
			Arrangement parent2 = selectParent(population);
			Arrangement child = crossover(parent1, parent2);
			newPopulation.saveArrangement(i, child);
		}
		
		for(int i = elitismOffset; i < newPopulation.populationSize(); i++){
			mutate(newPopulation.getArrangement(i));
		}
		
		
		return newPopulation;
		
	}
	
	public static Arrangement crossover(Arrangement parent1, Arrangement parent2){
		
		Arrangement child= new Arrangement();
		
		ArrayList<Seat> parent1Seats = parent1.getArrangementSeats();
		ArrayList<Seat> parent2Seats = parent2.getArrangementSeats();

		int startPosition= (int) (Math.random() * parent1Seats.size());
		int endPosition = (int) (Math.random() * parent1Seats.size());
		
		ArrayList<Seat> childSeats=new ArrayList<>(parent1Seats.size());
		for(int i = 0; i < parent1Seats.size(); i++) {
			childSeats.add(new Seat(-1));
		}
		
		//select the seats from parent 1 to crossover
		for (int i = 0; i < parent1Seats.size(); i++) { 							
			if(startPosition < endPosition && i > startPosition && i < endPosition){
				childSeats.set(i, parent1.getArrangementSeats().get(i));
			}
			else if(startPosition > endPosition){
				if(!(i < startPosition && i > endPosition)){
					childSeats.set(i, parent1.getArrangementSeats().get(i));
				}
			}
		}
		
		//select the seats from parent 2 to crossover
		for (int i = 0; i < parent2Seats.size(); i++) {
			if(!childSeats.contains(parent2Seats.get(i))){
				for (int j = 0; j < parent2Seats.size(); j++) {
					if(childSeats.get(j).getPerson() == null){
						childSeats.set(j, parent2Seats.get(i));
						break;
					}
				}
			}
		}
		
		child.setArrangmentSeats(childSeats);
		return child;
	}
	
	public static void mutate(Arrangement arrangement){
		
		// loop for selecting two random tables
		for(int i=0; i < arrangement.getArrangement().size(); i++){
			
			if(Math.random() < mutationRate){
				
				int j = (int) (arrangement.getArrangement().size()* Math.random());
				
				Table table1 = arrangement.getArrangement().get(i);
				Table table2 = arrangement.getArrangement().get(j);
				
				//select random seat position from table
				int k1 = (int) (table1.getSeats().size()* Math.random());
				int k2 = (int) (table2.getSeats().size()* Math.random());
				
				//swap persons seated at k1 and k2 positions from table1 and table2
				Person person1=table1.getSeats().get(k1).getPerson();
				Person person2=table2.getSeats().get(k2).getPerson();
				table1.getSeats().get(k1).setPerson(person2);
				table2.getSeats().get(k2).setPerson(person1);
				
			}
			
		}
		
		
	}
	
	private static Arrangement selectParent(Population population){
		
		Population tournament = new Population(tournamentSize, false);
		
		for (int i = 0; i < tournamentSize; i++) {
			int random=(int) Math.random() * population.populationSize();
			tournament.saveArrangement(i, population.getArrangement(random));
		}
		
		Arrangement arrangement = tournament.getFittest();
				
		return arrangement;
	}
	
}
